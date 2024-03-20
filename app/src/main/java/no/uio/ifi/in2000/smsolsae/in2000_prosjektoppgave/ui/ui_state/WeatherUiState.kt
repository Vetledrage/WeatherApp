package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state

data class WeatherLocationInfo(

    val temperature: Int,
    val wind_speed: Float,
    val weatherCode: String,
    val fog_area_fractionL: Float,
    val cloud_area_fraction: Float,
    var cloud_area_fraction_high: Float,
    var cloud_area_fraction_low: Float,
    var cloud_area_fraction_medium: Float,

    val rainL: Float,
    val tempNext12hrs: MutableList<Int?>,

    /*val tempNext1h: Int,
    val tempNext2h: Int,
    val tempNext3h: Int,
    val tempNext4h: Int,
    val tempNext5h: Int,
    val tempNext6h: Int,
    val tempNext7h: Int,
    val tempNext8h: Int,
    val tempNext9h: Int,
    val tempNext10h: Int,
    val tempNext11h: Int,
    val tempNext12h: Int,*/

    val tempNext9Days: MutableList<Int?>,

    /*val temp_day1: Int,
    val temp_day2: Int,
    val temp_day3: Int,
    val temp_day4: Int,
    val temp_day5: Int,
    val temp_day6: Int,
    val temp_day7: Int,
    val temp_day8: Int,*/
)

sealed interface AppUiState {
    data class Success(val weather: WeatherLocationInfo) : AppUiState
    object Error : AppUiState
    object Loading : AppUiState
}
