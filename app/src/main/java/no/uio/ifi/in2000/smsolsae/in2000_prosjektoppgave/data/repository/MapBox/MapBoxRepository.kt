package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.MapBox

/**
 * Interface for the MapBoxRepository. Implemented in the class ImplementedMapBoxRepository
 */
interface MapBoxRepository {

    /**
     * Fetches the coordinates (latitude and longitude) for a given city.
     * @param city The name of the city to get coordinates for.
     * @return A Pair of Doubles representing the latitude and longitude, or null if the coordinates could not be found.
     */
    suspend fun getCoordinatesForAddress(city: String): Pair<Double, Double>?
}