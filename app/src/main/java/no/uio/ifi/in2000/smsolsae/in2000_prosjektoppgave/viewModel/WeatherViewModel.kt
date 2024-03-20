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
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData.getDay
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData.getIconId
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData.getNext12Hours
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData.getNext7Dates
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData.getRandomTemp
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.uiStates.HourlyWeather
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.uiStates.WeeklyWeather
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AppUiState
import java.io.IOException


//Prøvde meg på ViewModel, men ble ikke ferdig. Trengs mer jobbing noen som kan det her, prøv det ut
class WeatherViewModel : ViewModel() {

    private val _weeklyWeatherUiState = MutableStateFlow<List<WeeklyWeather>>(emptyList())
    val weeklyWeatherUiState = _weeklyWeatherUiState.asStateFlow()

    private val _hourlyWeatherUiState = MutableStateFlow<List<HourlyWeather>>(emptyList())
    val hourlyWeather = _hourlyWeatherUiState.asStateFlow()

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

    private var isDataLoaded = false
    init {
        //getWeatherInfo("53", "13", "")
        loadWeatherData()
    }

    private fun loadWeatherData(){
        if (isDataLoaded == false){
            viewModelScope.launch {
                val hourlyData = mutableListOf<HourlyWeather>()
                for (i in getNext12Hours().indices){
                    val temp = getRandomTemp()
                    hourlyData.add(HourlyWeather(getNext12Hours()[i], temp, getIconId(temp)))
                }
                _hourlyWeatherUiState.value = hourlyData

                val weeklyData = mutableListOf<WeeklyWeather>()
                for (date in getNext7Dates()){
                    val temp = getRandomTemp()
                    weeklyData.add(WeeklyWeather(getDay(date), date, temp, getIconId(temp)))
                }
                _weeklyWeatherUiState.value = weeklyData

                isDataLoaded = true
            }
        }
    }



}