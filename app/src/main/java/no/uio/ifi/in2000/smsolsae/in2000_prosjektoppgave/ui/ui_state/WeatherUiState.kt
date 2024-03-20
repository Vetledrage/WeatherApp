package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state

data class WeatherLocationInfo(
    val temperatureL: Int,
    val fog_area_fractionL: Float,
    val cloud_area_fraction: Float,
    var cloud_area_fraction_high: Float,
    var cloud_area_fraction_low: Float,
    var cloud_area_fraction_medium: Float,
    val rainL: Float,
    val tempNext1: Int,
    val tempNext2: Int,
    val tempNext3: Int,
    val tempNext4: Int,
    val tempNext5: Int,
    val tempNext6: Int,
    val tempNext7: Int,
    val tempNext8: Int,
    val tempNext9: Int,
    val tempNext10: Int,
    val tempNext11: Int,
    val tempNext12: Int,

    val temp_day1: Int,
    val temp_day2: Int,
    val temp_day3: Int,
    val temp_day4: Int,
    val cloud_day1: Float,
    val cloud_day2: Float,
    val cloud_day3: Float,
    val cloud_day4: Float,
)

sealed interface AppUiState {
    data class Success(val locationF: WeatherLocationInfo) : AppUiState
    object Error : AppUiState
    object Loading : AppUiState
}
