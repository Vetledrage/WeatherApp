package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.weather

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import io.ktor.util.appendIfNameAbsent
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.Resource

class WeatherDataSource(){

    private val client = HttpClient() {
        defaultRequest {
            url("https://gw-uio.intark.uh-it.no/in2000/")
            headers.appendIfNameAbsent("" +
                    "X-Gravitee-API-Key", "1c203c70-6b10-467d-9150-986d844c082b"
            )
        }
    }

    suspend fun getPartyInfo(): Resource {
        return try {
            val response = client.get("weatherapi/")
            if(response.status == HttpStatusCode.OK){
                val data: WeatherData = response.body()
                Resource.Success(data.temperature)
            } else {
                Resource.Error(Exception("Could not load data"))
            }
        }catch(e: Exception){
            Resource.Error(e)
        }
    }

}