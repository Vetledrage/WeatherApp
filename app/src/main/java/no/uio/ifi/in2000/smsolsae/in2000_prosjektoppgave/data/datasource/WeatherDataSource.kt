package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource


import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.gson.gson
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.Model

/**
 * Data source for Weather data
 * @param baseUrl url to fetch weather data from
 */
class WeatherDataSource(val baseUrl: String){
    /**
     * Method that calls on the data with a proxy server
     * @param client the httpclient to use
     * @param url The url to use
     * @return result of a get request on the url (More information to be added)
     */
    private suspend fun serverCall(client: HttpClient, url: String) : HttpResponse{
        return client.get(url){
            headers{
                append("X-Gravitee-API-Key", "1c203c70-6b10-467d-9150-986d844c082b")
            }
        }
    }

    /**
     * Fetches location forecast based on position
     * @param lat latitude
     * @param long longitude
     * @param altitude altitude
     * @return Model object with result of requesting weather data to the server based on location
     *
     */
    suspend fun fetchLocationForecastData(lat: String, long: String, altitude: String? = null): Model {
        var cordinates = "lat=${lat}&lon=${long}"
        if (altitude != null) {
            cordinates += "&altitude=$altitude"
        }

        val client = HttpClient{
            install(ContentNegotiation){
                gson()
            }
        }

        val  url = "$baseUrl/locationforecast/2.0/complete?$cordinates"
        return serverCall(client, url).body()
    }

}