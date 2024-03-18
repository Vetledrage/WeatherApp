package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData.getDay
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData.getIconId
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData.getNext12Hours
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData.getNext7Dates
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData.getRandomTemp
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.uiStates.HourlyWeather
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.uiStates.WeeklyWeather



//Prøvde meg på ViewModel, men ble ikke ferdig. Trengs mer jobbing noen som kan det her, prøv det ut
class WeatherViewModel : ViewModel() {

    private val _weeklyWeatherUiState = MutableStateFlow<List<WeeklyWeather>>(emptyList())
    val weeklyWeatherUiState = _weeklyWeatherUiState.asStateFlow()

    private val _hourlyWeatherUiState = MutableStateFlow<List<HourlyWeather>>(emptyList())
    val hourlyWeather = _hourlyWeatherUiState.asStateFlow()

    init {
        loadWeatherData()
    }

    private fun loadWeatherData(){
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
        }
    }



}