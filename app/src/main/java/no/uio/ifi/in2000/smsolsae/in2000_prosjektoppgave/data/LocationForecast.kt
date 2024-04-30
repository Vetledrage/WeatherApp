package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data

data class Model(
    val type : String,
    val geometry: Geometry,
    val properties: Properties
)
data class Geometry(
    val type: String,
    val coordinates: List<Float>
)
data class Properties(
    val meta: Meta,
    val timeseries: List<Timeseries>
)
data class Meta(
    val updated_at: String,
    val units: Map<String, String>
)
data class Timeseries(
    val time: String,
    val data: Data
)
data class Data(
    val instant : Instant,
    val next_12_hours: Next12,
    val next_1_hours : Next1,
    val next_6_hours: Next6
)
data class Instant(
    val details: Details
)
data class Next12(
    val summary: Map<String, String>,
    val details: Details
)
data class Next1(
    val summary: Map<String, String>,
    val details: Details
)
data class Next6(
    val summary: Map<String, String>,
    val details: Details
)

data class Details(
    var time : String,
    var symbol_code : String,
    var air_temperature : Float,
    var precipitation_amount: Float,
    var relative_humidity: Float,
    var ultraviolet_index_clear_sky: Float,
    var wind_speed: Float,
)