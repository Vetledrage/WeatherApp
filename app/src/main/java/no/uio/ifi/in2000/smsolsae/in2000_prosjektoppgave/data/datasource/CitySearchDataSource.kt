package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.gson.gson

class CitySearchDataSource(val baseUrl: String) {

    private val client = HttpClient{
        install(ContentNegotiation) {
            gson()
        }
    }

    private suspend fun proxyCall(url: String) : HttpResponse {
        return client.get(url){
            headers{
                append(
                    "X-Gravitee-API-Key", "1c203c70-6b10-467d-9150-986d844c082b"
                )
            }
        }
    }

    suspend fun fetchCitySearch(countryCode: String, city: String) : List<String> {
        Log.d("FETCHING City Search", "Fetcher citysearch data nå ")
        return proxyCall("$baseUrl/v1/reference-data/locations/cities?countryCode=$countryCode&keyword=$city&max=1").body()
    }

}