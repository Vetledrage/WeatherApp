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
 * @property updatedAt The timestamp when the data was last updated.
 * @property units The units of measurement for the data.
 */
data class Meta(
    val updatedAt: String,
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
 * @property next12Hours The weather summary and details for the next 12 hours.
 * @property next1Hours The weather summary and details for the next 1 hour.
 * @property next6Hours The weather summary and details for the next 6 hours.
 */
data class Data(
    val instant : Instant,
    val next12Hours: Next12,
    val next6Hours: Next6,
    val next1Hours : Next1,
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
 * @property symbolCode The symbol code representing the weather condition.
 * @property airTemperature The air temperature.
 * @property precipitationAmount The amount of precipitation.
 * @property relativeHumidity The relative humidity.
 * @property ultravioletIndexClearSky The UV index for clear sky.
 * @property windSpeed The wind speed.
 */
data class Details(
    var time : String,
    var symbolCode : String,
    var airTemperature : Float,
    var precipitationAmount: Float,
    var relativeHumidity: Float,
    var ultravioletIndexClearSky: Float,
    var windSpeed: Float,
)