package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data


import com.google.gson.annotations.SerializedName

/**
 * Represents the build information containing features, language, last change, and type.
 * @property features The list of features.
 * @property lang The language of the build.
 * @property lastChange The last change timestamp of the build.
 * @property type The type of the build.
 */
data class Build (
    val features: List<Features>?,
    val lang : String?,
    val lastChange: String?,
    val type: String?
)

/**
 * Represents the features of the build.
 * @property geometry The geometry of the feature.
 * @property properties The properties of the feature.
 * @property type The type of the feature.
 * @property time The time information of the feature.
 */
data class Features(
    val geometry : GeometryAlert,
    val properties: PropertiesAlert?,
    val type : String?,
    @SerializedName("when") val time : WhenMet?,
)

/**
 * Represents the time information.
 * @property interval The list of time intervals.
 */
data class WhenMet(
    val interval : List<String?>
)

/**
 * Represents the properties of the alert.
 * @property area The area of the alert.
 * @property awarenessResponse The response awareness.
 * @property awarenessSeriousness The seriousness awareness.
 * @property awarenessLevel The level of awareness.
 * @property awarenessType The type of awareness.
 * @property certainty The certainty of the alert.
 * @property consequences The consequences of the alert.
 * @property county The list of county codes.
 * @property description The description of the alert.
 * @property event The event of the alert.
 * @property eventAwarenessName The name of the event awareness.
 * @property eventEndingTime The ending time of the event.
 * @property geographicDomain The geographic domain of the alert.
 * @property id The ID of the alert.
 * @property instruction The instructions for the alert.
 * @property resources The list of resources related to the alert.
 * @property severity The severity of the alert.
 * @property title The title of the alert.
 * @property triggerLevel The trigger level of the alert.
 * @property type The type of the alert.
 */
data class PropertiesAlert(
    val area : String?,
    val awarenessResponse : String?,
    val awarenessSeriousness : String?,
    val awarenessLevel : String?,
    val awarenessType : String?,
    val certainty : String?,
    val consequences : String?,
    val county : List<Int>?,
    val description : String?,
    val event : String?,
    val eventAwarenessName : String?,
    val eventEndingTime: String?,
    val geographicDomain : String?,
    val id : String?,
    val instruction : String?,
    val resources: List<Resources?>?,
    val severity : String?,
    val title : String?,
    val triggerLevel : String?,
    val type: String?
)

/**
 * Represents resources related to the alert.
 * @property description The description of the resource.
 * @property mimeType The MIME type of the resource.
 * @property uri The URI of the resource.
 */
data class Resources(
    val description: String?,
    val mimeType : String?,
    val uri : String?
)

/**
 * Represents the geometry information of the alert.
 * @property coordinates The list of coordinates.
 * @property type The type of geometry.
 */
data class GeometryAlert(
    val coordinates : List<List<Any>>,
    val type : String?
)