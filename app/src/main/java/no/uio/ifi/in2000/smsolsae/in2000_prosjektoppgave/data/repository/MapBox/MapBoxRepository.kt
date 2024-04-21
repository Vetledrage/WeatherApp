package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.MapBox

interface MapBoxRepository {
    suspend fun getCoordinatesForAddress(city: String): Pair<Double, Double>?
}