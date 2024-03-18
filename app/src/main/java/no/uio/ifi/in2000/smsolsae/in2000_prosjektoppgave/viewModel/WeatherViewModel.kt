package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.uiStates.WeeklyWeather



//Prøvde meg på ViewModel, men ble ikke ferdig. Trengs mer jobbing noen som kan det her, prøv det ut
class WeatherViewModel() : ViewModel() {

    private val _weeklyWeatherUiState = MutableStateFlow(
        WeeklyWeather(
            weekDay = "",
            date = "",
            temperature = 0,
            weatherIconId = 0
        )
    )

    val weeklyWeatherUiState: StateFlow<WeeklyWeather> = _weeklyWeatherUiState.asStateFlow()

    private fun setWeeklyWeather(weekDay: String, date: String, temperature: Int, weatherIcon: Int){
        _weeklyWeatherUiState.update { currState ->
            currState.copy(
                weekDay = weekDay,
                date = date,
                temperature = temperature,
                weatherIconId = weatherIcon
            )
        }
    }


}