package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.MapModel

class MapSearchDataSource {
    private val baseUrl = "https://api.mapbox.com/geocoding/v5/mapbox.places"
    private val accessToken = "pk.eyJ1Ijoic2FpZHNvbHNhZXYiLCJhIjoiY2x2NzFlemp4MDR3dzJtbW1mNDZhMzZlOCJ9.o3m4bbSHN6Zxo1PJsqfesA"

    private val client = HttpClient {
        install(ContentNegotiation) {
            gson()
        }
    }


    suspend fun fetchMapSearch(city: String) : MapModel?{
        return try {
            val response = client.get("$baseUrl/$city.json?limit=1&access_token=$accessToken")
            return response.body()
        }catch (e: Exception){
            Log.e("MapSearchDataSource", "FEIL ved henting: ${e.message}")
            null
        }
    }
}