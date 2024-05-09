package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state

/**
 * Represents weather info for a specific location (more information to be added)
 * @property temperature temperature in celcius
 * @property weatherCode string representing the current weather condition
 * @property rain current rain level in millimeters
 * @property tempNext12hrs a list of temperatureNext12Hours-objects representing the temperature the next 12 hours
 * @property tempNext7Days a list of temperatureNext9Days-objects representing the temperature the next 9 days
 * @property uvIndex the uvindex
 * @property windSpeed the wind speed in meters per second
 * @property humidity the humidity in percentage
 */
data class WeatherLocationInfo(
    val temperature: Int,
    val weatherCode: String,
    val rain: Float,
    val tempNext12hrs: List<TemperatureNext12Hours>,
    val tempNext7Days: List<TemperatureNext7Days>,
    val uvIndex: Float,
    val windSpeed: Float,
    val humidity: Int,
)


/**
 * Data class for temperature the next 12 hours. Used in the data class Weatherlocationinfo
 * @property time Current time as a string
 * @property temp current temperature in celcius
 * @property iconId The icon id
 */
data class TemperatureNext12Hours(
    val time: String,
    val temp: Int?,
    val iconId: String?,
)


/**
 * Data class for the temperature the next 9 days. Used in the data class WeatherLocationInfo
 * @property time The current time as a string
 * @property temp current temperature in celcius
 * @property iconId The icon id
 */
data class TemperatureNext7Days(
    val time: String,
    val temp: Int?,
    val iconId: String?
)

//Change the variable names under AlertInfo and fix to let them be more understandable!!!!
data class AlertInfo(
    val area: String?,
    val type: String?,
    val consequense: String?,
    val recomendation : String?,
    val description : String?,
    val alertType: String?,
    val alertLevel: String?,
    val timeInterval: List<String?>?
)

/**
 * Represents the possible states of the ui related to fetching and display of weather information.
 * Three states that express the states the UI can be in
 * @property Success A state expressing that the data has been successfully fetched
 * @property Error A state expressing that there was something failed in the fetching of the weather data
 * @property Loading A state expressing that weather data is currently being fetched
 *
 */
sealed interface AppUiState {
    data class Success(
        val weather: WeatherLocationInfo,
        val alerts: MutableList<AlertInfo>
    ) : AppUiState
    data object Error : AppUiState
    data object Loading : AppUiState

}
