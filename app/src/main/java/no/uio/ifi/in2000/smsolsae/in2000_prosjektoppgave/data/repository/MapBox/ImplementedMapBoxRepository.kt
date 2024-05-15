package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.MapBox

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource.MapSearchDataSource
/**
 * Implementation of the MapBoxRepository interface.
 */
class ImplementedMapBoxRepository : MapBoxRepository {
    private val mapDataSource = MapSearchDataSource()

    /**
     * Fetches the coordinates (latitude and longitude) for a given city.
     * @param city The name of the city to get coordinates for.
     * @return A Pair of Doubles representing the latitude and longitude, or null if the coordinates could not be found.
     */
    override suspend fun getCoordinatesForAddress(city: String): Pair<Double, Double>? {
        return try {
            //Fetch map search results for the given city
            val res = mapDataSource.fetchMapSearch(city = city)

            //Extract the features from the response
            val map = res!!.features

            //Check if the features list is empty or geometry is null
            if (map.isEmpty() || map[0].geometry == null) {
                return null
            }

            //Extract geometry and coordinates
            val geometry = map[0].geometry!!
            val coordinates = geometry.coordinates

            //Returning the coordinates as a Pair
            Pair(coordinates[0], coordinates[1])
        } catch (e: Exception) {
            //Print the stack trace in case of any exceptions
            e.printStackTrace()
            null
        }
    }
}
