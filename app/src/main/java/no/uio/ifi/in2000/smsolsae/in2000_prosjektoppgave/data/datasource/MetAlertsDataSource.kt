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


/**
 * Data source for the MetAlerts API.
 *
 * @param baseUrl The base url for the MetAlerts API
 *
 */
class MetAlertsDataSource(val baseUrl: String) {
    private val client = HttpClient{
        install(ContentNegotiation){
            gson()
        }
    }

    /**
     * Makes a proxy call to the specified URL.
     *
     * @param url The URL that we make the GET request to.
     * @return The HTTP response from the GET request.
     */
    private suspend fun proxyCall(url: String) : HttpResponse{
        return client.get(url){
            headers{
                append(
                    "X-Gravitee-API-Key", "1c203c70-6b10-467d-9150-986d844c082b"
                )
            }
        }
    }

    /**
     * Fetches the MetAlerts data.
     *
     * @return A [Build] object which contains the MetAlerts data.
     */
    suspend fun fetchMetAlerts() : Build {
        Log.d("FETCHING METALERTS", "Fetcher METALERTS data nå ")
        return proxyCall("$baseUrl/metalerts/2.0/current.json?&lang=en").body()
    }
}