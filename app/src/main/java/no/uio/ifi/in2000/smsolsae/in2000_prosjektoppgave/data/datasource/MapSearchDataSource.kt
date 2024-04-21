package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.MapModel

class MapSearchDataSource() {
    private val base_url = "https://api.mapbox.com/geocoding/v5/mapbox.places"
    private val access_token = "pk.eyJ1Ijoic2FpZHNvbHNhZXYiLCJhIjoiY2x2NzFlemp4MDR3dzJtbW1mNDZhMzZlOCJ9.o3m4bbSHN6Zxo1PJsqfesA"

    private val client = HttpClient {
        install(ContentNegotiation) {
            gson()
        }
    }


    suspend fun fetchMapSearch(city: String) : MapModel{
        return client.get("$base_url/$city.json?limit=1&access_token=$access_token").body()
    }
}