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
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.MapBox.ImplementedMapBoxRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.MapBox.MapBoxRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.metalerts.AlertsRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.metalerts.ImplementedAlertsRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather.ImplementedWeatherRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather.WeatherRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AppUiState
import java.io.IOException
import java.util.Locale

/**
 * Weather view model. This class fetches weather data based on the user's location. It extends the ViewModel class. (More information to be added)
 *
 *
 */
class WeatherViewModel : ViewModel() {
    private val repository: WeatherRepository = ImplementedWeatherRepository()
    private val metRepository : AlertsRepository = ImplementedAlertsRepository()
    private val mapRepository: MapBoxRepository = ImplementedMapBoxRepository()

    private val _appUiState: MutableStateFlow<AppUiState> = MutableStateFlow(AppUiState.Loading)
    val appUiState: StateFlow<AppUiState> = _appUiState.asStateFlow()

    private val _currentLocation = MutableStateFlow<Pair<Double, Double>?>(null)
    val currentLocation: StateFlow<Pair<Double, Double>?> = _currentLocation.asStateFlow()

    private val _locationName = MutableStateFlow("Oslo")
    val locationName: StateFlow<String> = _locationName.asStateFlow()

    private val _coordinatesState = MutableStateFlow<Pair<Double, Double>?>(null)
    val coordinatesState: StateFlow<Pair<Double, Double>?> = _coordinatesState.asStateFlow()

    /**
     * Updates the ui state with new weather info (more information to be added)
     * @param lat latitude
     * @param long longitude
     * @param altitude altitude
     */
    private fun getWeatherInfo(lat: String, long: String, altitude: String? = null){
        viewModelScope.launch {
            try {
                _appUiState.update {
                    AppUiState.Loading
                }
                val locationDeferred = viewModelScope.async (Dispatchers.IO) {
                    repository.getLocationWeather(latitude = lat, longitude = long, altitude = altitude)
                }
                val locationP = locationDeferred.await()

                val alertsDeffered = viewModelScope.async(Dispatchers.IO) {
                    metRepository.getAlertsInfo()
                }
                val alerts = alertsDeffered.await()

                _appUiState.update {
                    AppUiState.Success(
                        weather = locationP,
                        alerts = alerts
                    )
                }
            } catch (e: IOException){
                _appUiState.update {
                    AppUiState.Error
                }
            }
        }
    }

    fun getCoordinates(city: String){
        viewModelScope.launch(Dispatchers.IO) {
            val result = mapRepository.getCoordinatesForAddress(city)

            if (result != null){
                _coordinatesState.value = Pair(result.second, result.first)
                updateWeatherInfo(result.second.toString(),  result.first.toString())
            }
        }
    }

    init {
        getWeatherInfo("59.9139", "10.7522") //Fetches weather data in Oslo as default, to begin with, change this to current location afterwards!
    }

    /**
     * Updates already existing UI state.
     * @param lat latitude
     * @param long longitude
     * @param altitude altitude
     */
    fun updateWeatherInfo(lat: String, long: String, altitude: String? = null){
        getWeatherInfo(lat, long, altitude)
    }

    fun hasLocationPermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    /**
     * Get current location from user and updates the location in the app.
     * @param context Context
     */
    @SuppressLint("MissingPermission")
    fun getCurrentLocation(context: Context) {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                if (location != null) {
                    val lat = location.latitude
                    val long = location.longitude
                    _currentLocation.value = Pair(lat, long)
                    updateWeatherInfo(lat.toString(), long.toString())
                    updateLocationName(context, lat, long)
                }
            }
            .addOnFailureListener { exception ->
                // Handle location retrieval failure
                exception.printStackTrace()
            }
    }

    fun updateLocationName(context: Context, latitude: Double, longitude: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
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

    fun updateAlerts(){
        viewModelScope.launch {
            try {
                val alertsDeferred = viewModelScope.async(Dispatchers.IO) {
                    metRepository.getAlertsInfo()
                }
                val alerts = alertsDeferred.await()

                _appUiState.update { currentState ->
                    when (currentState) {
                        is AppUiState.Success -> currentState.copy(alerts = alerts)
                        else -> currentState
                    }
                }
            } catch (e: IOException) {
                _appUiState.update { AppUiState.Error }
            }
        }
    }

    fun setLocationName(newLocation: String){
        _locationName.value = newLocation
    }

}