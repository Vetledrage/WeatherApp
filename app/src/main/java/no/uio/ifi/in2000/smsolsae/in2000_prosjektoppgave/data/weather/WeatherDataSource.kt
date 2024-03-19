package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.weather


import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.gson.gson
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.Model

class WeatherDataSource(val basePath: String){

    //Metode som kaller på data med proxy server.
    private suspend fun serverCall(client: HttpClient, url: String) : HttpResponse{
        return client.get(url){
            headers{
                append("X-Gravitee-API-Key", "1c203c70-6b10-467d-9150-986d844c082b")
            }
        }
    }



    //Fetcher data fra location forecast.
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

        val  url = "$basePath/locationforecast/2.0/complete?$cordinates"
        return serverCall(client, url).body()
    }



}