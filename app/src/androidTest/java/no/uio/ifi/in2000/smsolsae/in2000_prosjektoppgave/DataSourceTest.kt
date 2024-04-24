package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave

import kotlinx.coroutines.runBlocking
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource.MapSearchDataSource
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource.MetAlertsDataSource
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource.WeatherDataSource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class DataSourceTest {

    private val metAlertApi: MetAlertsDataSource = MetAlertsDataSource(baseUrl = "https://gw-uio.intark.uh-it.no/in2000/weatherapi")
    private val weatherApi: WeatherDataSource = WeatherDataSource(baseUrl = "https://gw-uio.intark.uh-it.no/in2000/weatherapi")
    private val searchApi: MapSearchDataSource = MapSearchDataSource()

    @Test
    fun testMetAlerts() = runBlocking{

        val res = metAlertApi.fetchMetAlerts()
        //Assert
        assertEquals("FeatureCollection", res.type)
        assertEquals("en", res.lang)
        assertNotNull(res.lastChange)
        assertNotNull(res.features)
    }

    @Test
    fun testWeatherApi() = runBlocking {
        val res = weatherApi.fetchLocationForecastData("59.9139", "10.7522")

        assertEquals("[10.7522, 59.9139, 5.0]", res.geometry?.coordinates.toString())
        assertNotNull(res.type)
        assertNotNull(res.geometry)
        assertNotNull(res.properties)
    }

    @Test
    fun testSearchApi() = runBlocking {
        val res = searchApi.fetchMapSearch("Oslo, Norway")

        assertEquals("[10.7389701, 59.9133301]", res.features.get(0).geometry?.coordinates.toString())
        assertEquals("Point", res.features.get(0).geometry?.type.toString())
        assertEquals("Feature", res.features.get(0).type.toString())
        assertNotNull(res.features)
        assertNotNull(res.query)
    }
}