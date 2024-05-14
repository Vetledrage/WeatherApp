package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.MapModel

/**
 * Data source for searching for location with Mapbox Geocoding API.
 */
class MapSearchDataSource {
    //Base url for the Mapbox Geocoding API
    private val baseUrl = "https://api.mapbox.com/geocoding/v5/mapbox.places"

    //Access token for authenticating the API requests.
    private val accessToken = "pk.eyJ1Ijoic2FpZHNvbHNhZXYiLCJhIjoiY2x2NzFlemp4MDR3dzJtbW1mNDZhMzZlOCJ9.o3m4bbSHN6Zxo1PJsqfesA"

    //HTTP client with configured Gson content negotiation plugin
    private val client = HttpClient {
        install(ContentNegotiation) {
            gson()
        }
    }

    /**
     * Fetches the map search results for a given city.
     *
     * @param city The name of the city to search for.
     * @return A [MapModel] object containing the search results. Null if an error occurs.
     */
    suspend fun fetchMapSearch(city: String) : MapModel?{
        return try {
            // Doing GET request to the Mapbox Geocoding API. The result is assigned to the variable "response".
            val response = client.get("$baseUrl/$city.json?limit=1&access_token=$accessToken")

            return response.body() //returning the body of the response.
        }catch (e: Exception){
            //An error message is logged if an exception occurs during the function call.
            Log.e("MapSearchDataSource", "FEIL ved henting: ${e.message}")
            null
        }
    }
}