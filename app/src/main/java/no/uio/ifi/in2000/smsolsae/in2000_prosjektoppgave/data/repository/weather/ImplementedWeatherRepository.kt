package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather

import android.util.Log
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource.WeatherDataSource
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.TemperatureNext12Hours
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.TemperatureNext9Days
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.WeatherLocationInfo
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.formatTime
import java.util.Calendar


class ImplementedWeatherRepository : WeatherRepository {
    private val datasource = WeatherDataSource(baseUrl = "https://gw-uio.intark.uh-it.no/in2000/weatherapi")


    override suspend fun getLocationWeather(latitude: String, longitude: String, altitude: String?): WeatherLocationInfo {
        val locationForecast = datasource.fetchLocationForecastData(latitude, longitude, altitude)

        val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)

        //Log.d("IMPLEMENTED REPOSITORY", "getLocationWeather Tidspunkt: ${currentHour}")


        val timeDay1 = 24 - currentHour
        val timeDay2 = timeDay1 + 24
        val timeDay3 = timeDay2 + 19 // Dag to har bare frem til 18:00 derfor ta + 19 timer til 3 dagen kl 00:00
        val timeDay4 = timeDay3 + 4 //Etter dag 3 så er det kun 4 målinger på dagen så for å få neste dag ta + 4 for hver gang.
        val timeDay5 = timeDay4 + 4
        val timeDay6 = timeDay5 + 4
        val timeDay7 = timeDay6 + 4
        val timeDay8 = timeDay7 + 4




        val temp = locationForecast.properties.timeseries[0].data.instant.details.air_temperature.toInt()
        val weatherCode = locationForecast.properties.timeseries[0].data.next_6_hours.summary.get("symbol_code")
        val windspeed = locationForecast.properties.timeseries[0].data.instant.details.wind_speed
        val humidity = locationForecast.properties.timeseries[0].data.instant.details.relative_humidity.toInt()
        val rain = locationForecast.properties.timeseries[0].data.next_1_hours.details.precipitation_amount
        val uvIndex = locationForecast.properties.timeseries[0].data.instant.details.ultraviolet_index_clear_sky



        //Tror ikke vi trenger disse her
        /*val airfog = locationForecast.properties.timeseries.get(0)?.data?.instant?.details?.fog_area_fraction
        val cloudHigh = locationForecast.properties.timeseries?.get(0)?.data?.instant?.details?.cloud_area_fraction_high
        val cloudMid = locationForecast.properties?.timeseries?.get(0)?.data?.instant?.details?.cloud_area_fraction_medium
        val cloudLow = locationForecast.properties.timeseries.get(0)?.data?.instant?.details?.cloud_area_fraction_low
        val cloudiness = locationForecast.properties.timeseries?.get(0)?.data?.instant?.details?.cloud_area_fraction*/

        val tempNext12h = mutableListOf<TemperatureNext12Hours>()
        for (i in 0 until 12){
            val nextTemp = locationForecast.properties.timeseries[i].data.instant.details.air_temperature.toInt()
            val time = locationForecast.properties.timeseries[i].time
            val timeFormatted = formatTime(time)
            val iconId = locationForecast.properties.timeseries[i].data.next_1_hours.summary.get("symbol_code")
            Log.d("WEATHERCODE", "getLocationWeather: $iconId")
            tempNext12h.add(TemperatureNext12Hours(timeFormatted,nextTemp,iconId))
        }

        val tempNext9Days = mutableListOf<TemperatureNext9Days>()

        val tempDay1: Int = locationForecast.properties.timeseries[timeDay1].data.instant.details.air_temperature.toInt()
        val tempDay2: Int = locationForecast.properties.timeseries[timeDay2].data.instant.details.air_temperature.toInt()
        val tempDay3: Int = locationForecast.properties.timeseries[timeDay3].data.instant.details.air_temperature.toInt()
        val tempDay4: Int = locationForecast.properties.timeseries[timeDay4].data.instant.details.air_temperature.toInt()
        val tempDay5: Int = locationForecast.properties.timeseries[timeDay5].data.instant.details.air_temperature.toInt()
        val tempDay6: Int = locationForecast.properties.timeseries[timeDay6].data.instant.details.air_temperature.toInt()
        val tempDay7: Int = locationForecast.properties.timeseries[timeDay7].data.instant.details.air_temperature.toInt()
        val tempDay8: Int = locationForecast.properties.timeseries[timeDay8].data.instant.details.air_temperature.toInt()

        val time1 = locationForecast.properties.timeseries[timeDay1].time
        val time2 = locationForecast.properties.timeseries[timeDay2].time
        val time3 = locationForecast.properties.timeseries[timeDay3].time
        val time4 = locationForecast.properties.timeseries[timeDay4].time
        val time5 = locationForecast.properties.timeseries[timeDay5].time
        val time6 = locationForecast.properties.timeseries[timeDay6].time
        val time7 = locationForecast.properties.timeseries[timeDay7].time
        val time8 = locationForecast.properties.timeseries[timeDay8].time

        //Log.d("TAG", "getLocationWeather: $time1 $time2 $time3 $time5")

        val symbolCodeWeather = locationForecast.properties.timeseries[timeDay1].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather2 = locationForecast.properties.timeseries[timeDay2].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather3 = locationForecast.properties.timeseries[timeDay3].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather4 = locationForecast.properties.timeseries[timeDay4].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather5 = locationForecast.properties.timeseries[timeDay5].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather6 = locationForecast.properties.timeseries[timeDay6].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather7 = locationForecast.properties.timeseries[timeDay7].data?.next_12_hours?.summary?.get("symbol_code")
        val symbolCodeWeather8 = locationForecast.properties.timeseries[timeDay8].data?.next_12_hours?.summary?.get("symbol_code")

        tempNext9Days.addAll(listOf(
            TemperatureNext9Days(time1,tempDay1, symbolCodeWeather),
            TemperatureNext9Days(time2,tempDay2,symbolCodeWeather2),
            TemperatureNext9Days(time3,tempDay3,symbolCodeWeather3),
            TemperatureNext9Days(time4,tempDay4,symbolCodeWeather4),
            TemperatureNext9Days(time5,tempDay5,symbolCodeWeather5),
            TemperatureNext9Days(time6,tempDay6,symbolCodeWeather6),
            TemperatureNext9Days(time7,tempDay7,symbolCodeWeather7),
            TemperatureNext9Days(time8,tempDay8,symbolCodeWeather8),
            )
        )

        return WeatherLocationInfo(
            temperature = temp,
            windSpeed = windspeed,
            rain = rain,
            weatherCode = weatherCode!!,
            tempNext12hrs = tempNext12h,
            tempNext9Days = tempNext9Days ,
            uvIndex = uvIndex,
            humidity = humidity,


            /*
            fog_area_fractionL = airfog!!,
            cloud_area_fraction_high = cloudHigh!!,
            cloud_area_fraction_medium = cloudMid!!,
            cloud_area_fraction_low = cloudLow!!,
            cloud_area_fraction = cloudiness!!,*/

        )
    }
}