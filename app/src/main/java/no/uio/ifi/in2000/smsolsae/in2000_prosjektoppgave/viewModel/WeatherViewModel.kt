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
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather.ImplementedWeatherRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather.WeatherRepository
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AppUiState
import java.io.IOException


class WeatherViewModel : ViewModel() {
    private val repository: WeatherRepository = ImplementedWeatherRepository()

    private val _appUiState: MutableStateFlow<AppUiState> = MutableStateFlow(AppUiState.Loading)
    val appUiState: StateFlow<AppUiState> = _appUiState.asStateFlow()

    fun getWeatherInfo(lat: String, long: String, altitude: String? = null){
        viewModelScope.launch {
            try {
                val locationDeferred = viewModelScope.async (Dispatchers.IO) {
                    repository.getLocationWeather(latitude = lat, longitude = long, altitude = altitude)
                }
                val locationP = locationDeferred.await()

                _appUiState.update {
                    AppUiState.Success(
                        weather = locationP
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

    fun updateWeatherInfo(lat: String, long: String, altitude: String? = null){
        getWeatherInfo(lat, long, altitude)
    }


}