package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data

data class MapModel(
    var query: List<String>,
    var features : List<MapFeatures>,
)

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

data class MapGeometry(
    val type: String?,
    val coordinates: List<Double>
)

