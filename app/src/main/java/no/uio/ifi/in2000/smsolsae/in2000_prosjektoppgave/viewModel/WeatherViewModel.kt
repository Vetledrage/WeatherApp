package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.mapbox.ImplementedMapBoxRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.mapbox.MapBoxRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.metalerts.AlertsRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.metalerts.ImplementedAlertsRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather.ImplementedWeatherRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather.WeatherRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AppUiState
import java.io.IOException
import java.util.Locale

/**
 * Weather view model. This class fetches weather data based on the user's location. It extends the ViewModel class.
 */
class WeatherViewModel : ViewModel() {
    private val repository: WeatherRepository = ImplementedWeatherRepository()
    private val metRepository : AlertsRepository = ImplementedAlertsRepository()
    private val mapRepository: MapBoxRepository = ImplementedMapBoxRepository()

    //Mutable state flow to manage the UI state
    private val _appUiState: MutableStateFlow<AppUiState> = MutableStateFlow(AppUiState.Loading)
    //State flow to expose the UI state
    val appUiState: StateFlow<AppUiState> = _appUiState.asStateFlow()

    //Mutable state flow to manage the location name
    private val _locationName = MutableStateFlow("Oslo")
    //State flow to expose the location name
    val locationName: StateFlow<String> = _locationName.asStateFlow()



    //Mutable state flow to manage error messages
    private val _errorMessage = MutableStateFlow<String?>(null)
    //State flow to expose error messages
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    /**
     * Updates the UI state with new weather info.
     * @param lat Latitude of the location.
     * @param long Longitude of the location.
     * @param altitude Altitude of the location (optional).
     */
    fun getWeatherInfo(lat: String, long: String, altitude: String? = null){
        viewModelScope.launch {
            try {
                //Update UI state to loading
                _appUiState.update {
                    AppUiState.Loading
                }
                //Fetch weather information asynchronously
                val locationDeferred = viewModelScope.async (Dispatchers.IO) {
                    repository.getLocationWeather(latitude = lat, longitude = long, altitude = altitude)
                }
                val locationP = locationDeferred.await()



                //Fetch alerts information asynchronously
                val alertsDeffered = viewModelScope.async(Dispatchers.IO) {
                    metRepository.getAlertsInfo()
                }
                val alerts = alertsDeffered.await()

                //Update UI state to success with weather and alerts information
                _appUiState.update {
                    AppUiState.Success(
                        weather = locationP,
                        alerts = alerts
                    )
                }
            } catch (e: IOException){
                //Update UI state to error in case of an exception
                _appUiState.update {
                    AppUiState.Error
                }
            }
        }
    }

    /**
     * Resets the error message to null.
     */
    fun setErrorMesageNull(){
        _errorMessage.value = null
    }

    /**
     * Fetches coordinates for a given city and updates the state.
     * @param city The name of the city to get coordinates for.
     */
    fun getCoordinates(city: String){
        viewModelScope.launch(Dispatchers.IO) {
            //Fetch coordinates for the given city
            val result = mapRepository.getCoordinatesForAddress(city)

            if (result != null){
                setErrorMesageNull()

                updateWeatherInfo(result.second.toString(),  result.first.toString())
            } else{
                //Set error message if coordinates could not be fetched
                _errorMessage.value = "Oops! Cannot get data for this location "
            }
        }
    }

    /**
     * Updates the existing UI state with new weather info.
     * @param lat Latitude of the location.
     * @param long Longitude of the location.
     * @param altitude Altitude of the location (optional).
     */
    fun updateWeatherInfo(lat: String, long: String, altitude: String? = null){
        getWeatherInfo(lat, long, altitude)
    }

    /**
     * Checks if the app has location permission.
     * @param context Context of the application.
     * @return True if location permission is granted, false otherwise.
     */
    fun hasLocationPermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Gets the user's current location and updates the location in the app.
     * @param context Context of the application.
     */
    @SuppressLint("MissingPermission")
    fun getCurrentLocation(context: Context) {

        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->

                if (location != null) {
                    val lat = location.latitude
                    val long = location.longitude
                    println("$lat, $long")

                    //Update weather and location name based on the current location
                    updateWeatherInfo(lat.toString(), long.toString())
                    updateLocationName(context, lat, long)
                }else {
                    _appUiState.update {
                        AppUiState.Error
                    }
                }
            }
            .addOnFailureListener { exception ->
                // Handle location retrieval failure
                exception.printStackTrace()
                println(exception.printStackTrace())
            }
    }

    /**
     * Updates the location name based on the provided latitude and longitude.
     * @param context Context of the application.
     * @param latitude Latitude of the location.
     * @param longitude Longitude of the location.
     */
    @Suppress("DEPRECATION")
    private fun updateLocationName(context: Context, latitude: Double, longitude: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            try {

                //Use Geocoder to get thr location name from coordinates
                val geocoder = Geocoder(context, Locale.getDefault())
                val addresses = geocoder.getFromLocation(latitude, longitude, 1)
                if (addresses!!.isNotEmpty()) {
                    val address = addresses.first()
                    val locality = address.locality ?: "Unknown location"
                    _locationName.value = locality
                } else {
                    _locationName.value = "Location not found!"
                }
            } catch (e: IOException) {
                _locationName.value = "Error in getting location"
            }
        }
    }

    /**
     * Fetches the latest alerts information and updates the UI state.
     */
    fun updateAlerts(){
        viewModelScope.launch {
            try {
                //Fetch alerts information asynchronously
                val alertsDeferred = viewModelScope.async(Dispatchers.IO) {
                    metRepository.getAlertsInfo()
                }
                val alerts = alertsDeferred.await()

                //Update UI state with new alerts information
                _appUiState.update { currentState ->
                    when (currentState) {
                        is AppUiState.Success -> currentState.copy(alerts = alerts)
                        else -> currentState
                    }
                }
            } catch (e: IOException) {
                //Update UI state to error in case of an exception
                _appUiState.update { AppUiState.Error }
            }
        }
    }

    /**
     * Sets the location name.
     * @param newLocation The new location name to be set.
     */
    fun setLocationName(newLocation: String){
        _locationName.value = newLocation
    }

}