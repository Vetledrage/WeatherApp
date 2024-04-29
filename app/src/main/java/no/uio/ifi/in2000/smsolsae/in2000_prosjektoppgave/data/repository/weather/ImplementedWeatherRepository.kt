package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.Timeseries
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource.WeatherDataSource
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.TemperatureNext12Hours
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.TemperatureNext7Days
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.WeatherLocationInfo
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.formatTime
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


/**
 * Repository for weather data (More information to be added)
 */
class ImplementedWeatherRepository : WeatherRepository {
    private val datasource = WeatherDataSource(baseUrl = "https://gw-uio.intark.uh-it.no/in2000/weatherapi")


    //Private function to get the Timeseries for only the next 7 days, and to remove the hourly data from each date.
    //Easier to work with like this.
    private fun getNext7DaysTimeseries(timeseriesList: List<Timeseries>): List<Timeseries> {
        // Opprett en Calendar-instans for dagens dato
        val currentDate = Calendar.getInstance()

        // Opprett en SimpleDateFormat for å konvertere tidsserienes strengrepresentasjon av tid til Calendar-objekter
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        // Finn datoen 7 dager frem i tid
        val next7DaysDate = Calendar.getInstance()
        next7DaysDate.add(Calendar.DAY_OF_YEAR, 7)

        // Opprett en liste for å lagre resultatene
        val next7DaysTimeseries = mutableListOf<Timeseries>()

        // Iterer gjennom tidsseriene
        for (timeseries in timeseriesList) {
            // Konverter tidsseriens strengrepresentasjon av tid til en Calendar-objekt
            val time = Calendar.getInstance().apply {
                timeInMillis = dateFormat.parse(timeseries.time)?.time ?: 0
            }

            // Sjekk om tidspunktet er innenfor de neste 7 dagene
            if (time.after(currentDate) && time.before(next7DaysDate)) {
                // Legg til tidsserien i listen hvis datoen ikke allerede er lagt til
                if (!next7DaysTimeseries.any { it.time.substring(0, 10) == timeseries.time.substring(0, 10) }) {
                    next7DaysTimeseries.add(timeseries)
                }
            }
        }

        // Returner resultatet
        return next7DaysTimeseries
    }


    override suspend fun getLocationWeather(latitude: String, longitude: String, altitude: String?): WeatherLocationInfo {
        val locationForecast = datasource.fetchLocationForecastData(latitude, longitude, altitude)


        val temp = locationForecast.properties.timeseries[0].data.instant.details.air_temperature.toInt()
        val weatherCode = locationForecast.properties.timeseries[0].data.next_6_hours.summary.get("symbol_code")
        val windspeed = locationForecast.properties.timeseries[0].data.instant.details.wind_speed
        val humidity = locationForecast.properties.timeseries[0].data.instant.details.relative_humidity.toInt()
        val rain = locationForecast.properties.timeseries[0].data.next_1_hours.details.precipitation_amount
        val uvIndex = locationForecast.properties.timeseries[0].data.instant.details.ultraviolet_index_clear_sky





        val tempNext12h = mutableListOf<TemperatureNext12Hours>()
        for (i in 0 until 12){
            val nextTemp = locationForecast.properties.timeseries[i].data.instant.details.air_temperature.toInt()
            val time = locationForecast.properties.timeseries[i].time
            val timeFormatted = formatTime(time)
            val iconId = locationForecast.properties.timeseries[i].data.next_1_hours.summary.get("symbol_code")
            tempNext12h.add(TemperatureNext12Hours(timeFormatted,nextTemp,iconId))
        }

        val tempNext7Days = mutableListOf<TemperatureNext7Days>()

        val liste = getNext7DaysTimeseries(locationForecast.properties.timeseries)

        val tempDay1: Int = liste[0].data.instant.details.air_temperature.toInt()
        val tempDay2: Int = liste[1].data.instant.details.air_temperature.toInt()
        val tempDay3: Int = liste[2].data.instant.details.air_temperature.toInt()
        val tempDay4: Int = liste[3].data.instant.details.air_temperature.toInt()
        val tempDay5: Int = liste[4].data.instant.details.air_temperature.toInt()
        val tempDay6: Int = liste[5].data.instant.details.air_temperature.toInt()
        val tempDay7: Int = liste[6].data.instant.details.air_temperature.toInt()

        val time1 = liste[0].time
        val time2 = liste[1].time
        val time3 = liste[2].time
        val time4 = liste[3].time
        val time5 = liste[4].time
        val time6 = liste[5].time
        val time7 = liste[6].time



        val symbolCodeWeather = liste[0].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather2 = liste[1].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather3 = liste[2].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather4 = liste[3].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather5 = liste[4].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather6 = liste[5].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather7 = liste[6].data?.next_12_hours?.summary?.get("symbol_code")

        tempNext7Days.addAll(listOf(
            TemperatureNext7Days(time1,tempDay1, symbolCodeWeather),
            TemperatureNext7Days(time2,tempDay2,symbolCodeWeather2),
            TemperatureNext7Days(time3,tempDay3,symbolCodeWeather3),
            TemperatureNext7Days(time4,tempDay4,symbolCodeWeather4),
            TemperatureNext7Days(time5,tempDay5,symbolCodeWeather5),
            TemperatureNext7Days(time6,tempDay6,symbolCodeWeather6),
            TemperatureNext7Days(time7,tempDay7,symbolCodeWeather7),
            )
        )

        return WeatherLocationInfo(
            temperature = temp,
            windSpeed = windspeed,
            rain = rain,
            weatherCode = weatherCode!!,
            tempNext12hrs = tempNext12h,
            tempNext7Days = tempNext7Days ,
            uvIndex = uvIndex,
            humidity = humidity,
        )
    }
}