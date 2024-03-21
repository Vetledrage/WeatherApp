package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state

data class WeatherLocationInfo(

    val temperature: Int,
    val weatherCode: String,

    val rain: Float,
    val tempNext12hrs: List<TemperatureNext12Hours>,
    val tempNext9Days: List<TemperatureNext9Days>,
    val uvIndex: Float,
    val wind_speed: Float,
    val humidity: Int, //Luft fuktighet. I prosent.

    /*val fog_area_fractionL: Float,
    val cloud_area_fraction: Float,
    var cloud_area_fraction_high: Float,
    var cloud_area_fraction_low: Float,
    var cloud_area_fraction_medium: Float,*/


)


//Data klasse for å ha temperaturer for de neste 12 timene i en liste.
data class TemperatureNext12Hours(
    val time: String,
    val temp: Int?,
    val iconId: String?,
)

data class TemperatureNext9Days(
    val time: String,
    val temp: Int?,
    val iconId: String?
)

sealed interface AppUiState {
    data class Success(val weather: WeatherLocationInfo) : AppUiState
    object Error : AppUiState
    object Loading : AppUiState
}
