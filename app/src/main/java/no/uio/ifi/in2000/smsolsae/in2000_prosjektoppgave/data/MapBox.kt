package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data

/**
 * Represents the map model containing query and features.
 * @property query The list of query strings.
 * @property features The list of map features.
 */
data class MapModel(
    var query: List<String>,
    var features : List<MapFeatures>,
)

/**
 * Represents the features of the map.
 * @property id The ID of the feature.
 * @property type The type of the feature.
 * @property placeType The list of place types.
 * @property relevance The relevance score of the feature.
 * @property text The text description of the feature.
 * @property placeName The name of the place.
 * @property geometry The geometry of the feature.
 * @property address The address of the feature.
 */
data class MapFeatures(
    var id: String?,
    var type: String?,
    var placeType: List<String>,
    var relevance: Int?,
    var text: String?,
    var placeName: String?,
    var geometry: MapGeometry?,
    var address: String?,
)

/**
 * Represents the geometry information of the map feature.
 * @property type The type of geometry.
 * @property coordinates The list of coordinates.
 */
data class MapGeometry(
    val type: String?,
    val coordinates: List<Double>
)

