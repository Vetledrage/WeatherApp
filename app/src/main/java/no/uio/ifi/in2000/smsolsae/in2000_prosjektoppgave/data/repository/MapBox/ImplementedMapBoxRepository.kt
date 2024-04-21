package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.MapBox

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource.MapSearchDataSource

class ImplementedMapBoxRepository : MapBoxRepository {
    private val mapDataSource = MapSearchDataSource()
    override suspend fun getCoordinatesForAddress(city: String): Pair<Double, Double>? {
        val res = mapDataSource.fetchMapSearch(city = city)

        val map = res.features

        if (map.isEmpty() || map[0].geometry == null){
            return null
        }

        val geometry = map[0].geometry!!
        val coordinates = geometry.coordinates



        return Pair(coordinates[0], coordinates[1])
    }




}