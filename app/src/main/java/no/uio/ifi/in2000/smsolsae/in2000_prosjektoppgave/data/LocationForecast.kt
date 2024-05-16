package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data

/**
 * Represents the weather model.Contains type, geometry, and properties.
 * @property type The type of the model.
 * @property geometry The geometry information of the model.
 * @property properties The properties of the model.
 */
data class Model(
    val type : String,
    val geometry: Geometry,
    val properties: Properties
)

/**
 * Represents the geometry information.
 * @property type The type of geometry.
 * @property coordinates The list of coordinates.
 */
data class Geometry(
    val type: String,
    val coordinates: List<Float>
)

/**
 * Represents the properties of the model.
 * @property meta Metadata information.
 * @property timeseries List of timeseries data.
 */
data class Properties(
    val meta: Meta,
    val timeseries: List<Timeseries>
)

/**
 * Represents metadata information.
 * @property updated_at The timestamp when the data was last updated.
 * @property units The units of measurement for the data.
 */
data class Meta(
    val updated_at: String,
    val units: Map<String, String>
)

/**
 * Represents timeseries data.
 * @property time The time of the timeseries data.
 * @property data The actual data of the timeseries.
 */
data class Timeseries(
    val time: String,
    val data: Data
)

/**
 * Represents detailed weather data.
 * @property instant The instantaneous weather details.
 * @property next_12_hours The weather summary and details for the next 12 hours.
 * @property next_1_hours The weather summary and details for the next 1 hour.
 * @property next_6_hours The weather summary and details for the next 6 hours.
 */
data class Data(
    val instant : Instant,
    val next_12_hours: Next12,
    val next_1_hours : Next1,
    val next_6_hours: Next6,
)

/**
 * Represents instantaneous weather details.
 * @property details The detailed weather information.
 */
data class Instant(
    val details: Details
)

/**
 * Represents weather summary and details for the next 12 hours.
 * @property summary The summary of the weather.
 * @property details The detailed weather information.
 */
data class Next12(
    val summary: Map<String, String>,
    val details: Details
)

/**
 * Represents weather summary and details for the next 1 hour.
 * @property summary The summary of the weather.
 * @property details The detailed weather information.
 */
data class Next1(
    val summary: Map<String, String>,
    val details: Details
)

/**
 * Represents weather summary and details for the next 6 hours.
 * @property summary The summary of the weather.
 * @property details The detailed weather information.
 */
data class Next6(
    val summary: Map<String, String>,
    val details: Details
)

/**
 * Represents detailed weather information.
 * @property time The time of the weather data.
 * @property symbol_code The symbol code representing the weather condition.
 * @property air_temperature The air temperature.
 * @property precipitation_amount The amount of precipitation.
 * @property relative_humidity The relative humidity.
 * @property ultraviolet_index_clear_sky The UV index for clear sky.
 * @property wind_speed The wind speed.
 */
data class Details(
    var time : String,
    var symbol_code : String,
    var air_temperature : Float,
    var precipitation_amount: Float,
    var relative_humidity: Float,
    var ultraviolet_index_clear_sky: Float,
    var wind_speed: Float,
)