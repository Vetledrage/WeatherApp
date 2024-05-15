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
     * Method that makes a Get request to the server with a proxy
     * @param client the Httpclient to use for making the request
     * @param url The URL to send the GET request to
     * @return HttpResponse Result of a get request on the specified URL
     */
    private suspend fun serverCall(client: HttpClient, url: String) : HttpResponse{
        return client.get(url){
            headers{
                //Adding the necessary API for authentication
                append("X-Gravitee-API-Key", "1c203c70-6b10-467d-9150-986d844c082b")
            }
        }
    }

    /**
     * Fetches location forecast based on the coordinates provided to the function
     * @param lat Latitude of the location
     * @param long Longitude of the location
     * @param altitude Altitude of the location (this parameter is optional)
     * @return Model object containing the result of requesting weather data request
     *
     */
    suspend fun fetchLocationForecastData(lat: String, long: String, altitude: String? = null): Model {
        var cordinates = "lat=${lat}&lon=${long}"
        if (altitude != null) {
            //Appending altitude to the coordinates if it is provided
            cordinates += "&altitude=$altitude"
        }

        // Create a HttpClient instance with JSON (Gson) support, assigned to the variable called client
        val client = HttpClient{
            install(ContentNegotiation){
                gson()
            }
        }

        //Here we construct the URL for the weather data request
        val  url = "$baseUrl/locationforecast/2.0/complete?$cordinates"
        //Make the server call and return the parsed response body
        return serverCall(client, url).body()
    }

}