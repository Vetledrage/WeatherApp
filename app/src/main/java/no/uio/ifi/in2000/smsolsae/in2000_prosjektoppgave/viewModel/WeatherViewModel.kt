package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.metalerts.AlertsRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.metalerts.ImplementedAlertsRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather.ImplementedWeatherRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather.WeatherRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AppUiState
import java.io.IOException

/**
 * Weather view model. This class fetches weather data based on the user's location. It extends the ViewModel class. (More information to be added)
 *
 *
 */
class WeatherViewModel : ViewModel() {
    private val repository: WeatherRepository = ImplementedWeatherRepository()
    private val metRepository : AlertsRepository = ImplementedAlertsRepository()

    private val _appUiState: MutableStateFlow<AppUiState> = MutableStateFlow(AppUiState.Loading)
    val appUiState: StateFlow<AppUiState> = _appUiState.asStateFlow()


    /**
     * Updates the ui state with new weather info (more information to be added)
     * @param lat latitude
     * @param long longitude
     * @param altitude altitude
     */
    fun getWeatherInfo(lat: String, long: String, altitude: String? = null){
        viewModelScope.launch {
            try {
                val locationDeferred = viewModelScope.async (Dispatchers.IO) {
                    repository.getLocationWeather(latitude = lat, longitude = long, altitude = altitude)
                }
                val locationP = locationDeferred.await()

                val alertsDeffered = viewModelScope.async(Dispatchers.IO) {
                    metRepository.getAlertsInfo(lat, long)
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

    init {
        getWeatherInfo("59.9139", "10.7522") //Henter vær data til Oslo. Senere må byttes om til at man henter fra location på tlf.
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


}