package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.gson.gson
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.Build

class MetAlertsDataSource(val baseUrl: String) {
    private val client = HttpClient{
        install(ContentNegotiation){
            gson()
        }
    }

    private suspend fun proxyCall(url: String) : HttpResponse{
        return client.get(url){
            headers{
                append(
                    "X-Gravitee-API-Key", "1c203c70-6b10-467d-9150-986d844c082b"
                )
            }
        }
    }

    suspend fun fetchMetAlerts(lat: String, long: String) : Build {
        val coordinates = "lat=$lat&lon=$long"
        Log.d("FETCHING METALERTS", "Fetcher METALERTS data nå ")
        return proxyCall("$baseUrl/metalerts/2.0/all.json?$coordinates&lang=en").body()
    }
}