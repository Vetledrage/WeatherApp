package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.mapbox

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource.MapSearchDataSource

/**
 *
 * Repository for the MapBox API
 */
class ImplementedMapBoxRepository : MapBoxRepository {
    private val mapDataSource = MapSearchDataSource()

    /**
     *
     * Function to get coordinates for Adress
     * @param city The city that we will get the coordinates for
     */
    override suspend fun getCoordinatesForAddress(city: String): Pair<Double, Double>? {
        return try {
            val res = mapDataSource.fetchMapSearch(city = city)


            val map = res!!.features

            if (map.isEmpty() || map[0].geometry == null){
                return null
            }

            val geometry = map[0].geometry!!
            val coordinates = geometry.coordinates



            Pair(coordinates[0], coordinates[1])
        }catch (e: Exception){
            e.printStackTrace()
            null
        }
    }
}