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

        val currentDate = Calendar.getInstance()

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        val next7DaysDate = Calendar.getInstance()
        next7DaysDate.add(Calendar.DAY_OF_YEAR, 8)


        val next7DaysTimeseries = mutableListOf<Timeseries>()


        for (timeseries in timeseriesList) {

            val time = Calendar.getInstance().apply {
                timeInMillis = dateFormat.parse(timeseries.time)?.time ?: 0
            }
            
            if (time.after(currentDate) && time.before(next7DaysDate)) {

                if (!next7DaysTimeseries.any { it.time.substring(0, 10) == timeseries.time.substring(0, 10) }) {
                    next7DaysTimeseries.add(timeseries)
                }
            }
        }

        return next7DaysTimeseries
    }


    override suspend fun getLocationWeather(latitude: String, longitude: String, altitude: String?): WeatherLocationInfo {
        val locationForecast = datasource.fetchLocationForecastData(latitude, longitude, altitude)


        //Todays weather information
        val temp = locationForecast.properties.timeseries[0].data.instant.details.air_temperature.toInt()
        val weatherCode = locationForecast.properties.timeseries[0].data.next_6_hours.summary["symbol_code"]
        val windspeed = locationForecast.properties.timeseries[0].data.instant.details.wind_speed
        val humidity = locationForecast.properties.timeseries[0].data.instant.details.relative_humidity.toInt()
        val rain = locationForecast.properties.timeseries[0].data.next_1_hours.details.precipitation_amount
        val uvIndex = locationForecast.properties.timeseries[0].data.instant.details.ultraviolet_index_clear_sky


        val tempNext12h = mutableListOf<TemperatureNext12Hours>()
        for (i in 0 until 12){
            val nextTemp = locationForecast.properties.timeseries[i].data.instant.details.air_temperature.toInt()
            val time = locationForecast.properties.timeseries[i].time
            val timeFormatted = formatTime(time)
            val iconId = locationForecast.properties.timeseries[i].data.next_1_hours.summary["symbol_code"]
            tempNext12h.add(TemperatureNext12Hours(timeFormatted,nextTemp,iconId))
        }

        val weekList = getNext7DaysTimeseries(locationForecast.properties.timeseries)

        val tempNext7Days = mutableListOf<TemperatureNext7Days>()
        for (i in weekList.indices){
            val nextTemp: Int = weekList[i].data.instant.details.air_temperature.toInt()
            val time = weekList[i].time
            val symbolCodeWeather = weekList[i].data.next_12_hours.summary["symbol_code"]
            tempNext7Days.add(TemperatureNext7Days(time, nextTemp, symbolCodeWeather))
        }


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