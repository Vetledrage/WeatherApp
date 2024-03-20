package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state

data class WeatherLocationInfo(

    val temperature: Int,
    val weatherCode: String,

    val rainL: Float,
    val tempNext12hrs: MutableList<Int?>,
    val tempNext9Days: MutableList<Int?>,
    val uvIndex: Float,
    val wind_speed: Float,
    val humidity: Int, //Luft fuktighet. I prosent.

    /*val fog_area_fractionL: Float,
    val cloud_area_fraction: Float,
    var cloud_area_fraction_high: Float,
    var cloud_area_fraction_low: Float,
    var cloud_area_fraction_medium: Float,*/


    )

sealed interface AppUiState {
    data class Success(val weather: WeatherLocationInfo) : AppUiState
    object Error : AppUiState
    object Loading : AppUiState
}
