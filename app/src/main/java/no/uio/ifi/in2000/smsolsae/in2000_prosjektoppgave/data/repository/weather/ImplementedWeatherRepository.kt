package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.weather.WeatherDataSource
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.WeatherLocationInfo
import java.text.SimpleDateFormat
import java.util.Date


class ImplementedWeatherRepository : WeatherRepository {
    private val datasource = WeatherDataSource(baseUrl = "https://gw-uio.intark.uh-it.no/in2000/weatherapi")


    override suspend fun getLocationWeather(latitude: String, longitude: String, altitude: String?): WeatherLocationInfo {
        val locationForecast = datasource.fetchLocationForecastData(latitude, longitude, altitude)

        val currentTimeMillis = System.currentTimeMillis()
        val date = Date(currentTimeMillis)
        val dateFormat = SimpleDateFormat("HH")
        val tidspunkt = dateFormat.format(date)

        val timeDay1 = 24-tidspunkt.toInt()+12
        val timeDay2 = 24-tidspunkt.toInt()+12+24
        val timeDay3 = 24-tidspunkt.toInt()+12+48

        val temp = locationForecast.properties?.timeseries?.get(0)?.data?.instant?.details?.air_temperature?.toInt()
        val airfog = locationForecast.properties?.timeseries?.get(0)?.data?.instant?.details?.fog_area_fraction
        val rain = locationForecast.properties?.timeseries?.get(0)?.data?.next_1_hours?.details?.precipitation_amount
        val cloudHigh = locationForecast.properties?.timeseries?.get(0)?.data?.instant?.details?.cloud_area_fraction_high
        val cloudMid = locationForecast.properties?.timeseries?.get(0)?.data?.instant?.details?.cloud_area_fraction_medium
        val cloudLow = locationForecast.properties?.timeseries?.get(0)?.data?.instant?.details?.cloud_area_fraction_low
        val cloudiness = locationForecast.properties?.timeseries?.get(0)?.data?.instant?.details?.cloud_area_fraction

        val tempNext1 = locationForecast.properties?.timeseries?.get(1)?.data?.instant?.details?.air_temperature?.toInt()
        val tempNext2 = locationForecast.properties?.timeseries?.get(2)?.data?.instant?.details?.air_temperature?.toInt()
        val tempNext3 = locationForecast.properties?.timeseries?.get(3)?.data?.instant?.details?.air_temperature?.toInt()
        val tempNext4 = locationForecast.properties?.timeseries?.get(4)?.data?.instant?.details?.air_temperature?.toInt()
        val tempNext5 = locationForecast.properties?.timeseries?.get(5)?.data?.instant?.details?.air_temperature?.toInt()
        val tempNext6 = locationForecast.properties?.timeseries?.get(6)?.data?.instant?.details?.air_temperature?.toInt()
        val tempNext7 = locationForecast.properties?.timeseries?.get(7)?.data?.instant?.details?.air_temperature?.toInt()
        val tempNext8 = locationForecast.properties?.timeseries?.get(8)?.data?.instant?.details?.air_temperature?.toInt()
        val tempNext9 = locationForecast.properties?.timeseries?.get(9)?.data?.instant?.details?.air_temperature?.toInt()
        val tempNext10 = locationForecast.properties?.timeseries?.get(10)?.data?.instant?.details?.air_temperature?.toInt()
        val tempNext11 = locationForecast.properties?.timeseries?.get(11)?.data?.instant?.details?.air_temperature?.toInt()
        val tempNext12 = locationForecast.properties?.timeseries?.get(12)?.data?.instant?.details?.air_temperature?.toInt()

        val cloudinessNext1 = locationForecast.properties?.timeseries?.get(1)?.data?.instant?.details?.cloud_area_fraction
        val cloudinessNext2 = locationForecast.properties?.timeseries?.get(2)?.data?.instant?.details?.cloud_area_fraction
        val cloudinessNext3 = locationForecast.properties?.timeseries?.get(3)?.data?.instant?.details?.cloud_area_fraction
        val cloudinessNext4 = locationForecast.properties?.timeseries?.get(4)?.data?.instant?.details?.cloud_area_fraction
        val cloudinessNext5 = locationForecast.properties?.timeseries?.get(5)?.data?.instant?.details?.cloud_area_fraction
        val cloudinessNext6 = locationForecast.properties?.timeseries?.get(6)?.data?.instant?.details?.cloud_area_fraction
        val cloudinessNext7 = locationForecast.properties?.timeseries?.get(7)?.data?.instant?.details?.cloud_area_fraction
        val cloudinessNext8 = locationForecast.properties?.timeseries?.get(8)?.data?.instant?.details?.cloud_area_fraction
        val cloudinessNext9 = locationForecast.properties?.timeseries?.get(9)?.data?.instant?.details?.cloud_area_fraction
        val cloudinessNext10 = locationForecast.properties?.timeseries?.get(10)?.data?.instant?.details?.cloud_area_fraction
        val cloudinessNext11 = locationForecast.properties?.timeseries?.get(11)?.data?.instant?.details?.cloud_area_fraction
        val cloudinessNext12 = locationForecast.properties?.timeseries?.get(12)?.data?.instant?.details?.cloud_area_fraction

        val tempDay1 = locationForecast.properties?.timeseries?.get(timeDay1)?.data?.instant?.details?.air_temperature?.toInt()
        val tempDay2 = locationForecast.properties?.timeseries?.get(timeDay2)?.data?.instant?.details?.air_temperature?.toInt()
        val tempDay3 = locationForecast.properties?.timeseries?.get(timeDay3)?.data?.instant?.details?.air_temperature?.toInt()
        val tempDay4 = locationForecast.properties?.timeseries?.get(timeDay3)?.data?.instant?.details?.air_temperature?.toInt()

        val cloudDay1 = locationForecast.properties?.timeseries?.get(timeDay1)?.data?.instant?.details?.cloud_area_fraction
        val cloudDay2 = locationForecast.properties?.timeseries?.get(timeDay2)?.data?.instant?.details?.cloud_area_fraction
        val cloudDay3 = locationForecast.properties?.timeseries?.get(timeDay3)?.data?.instant?.details?.cloud_area_fraction
        val cloudDay4 = locationForecast.properties?.timeseries?.get(timeDay3)?.data?.instant?.details?.cloud_area_fraction

        return WeatherLocationInfo(
            temperatureL = temp!!,
            fog_area_fractionL = airfog!!,
            rainL = rain!!,
            cloud_area_fraction_high = cloudHigh!!,
            cloud_area_fraction_medium = cloudMid!!,
            cloud_area_fraction_low = cloudLow!!,
            cloud_area_fraction = cloudiness!!,

            tempNext1 = tempNext1!!,
            tempNext2 = tempNext2!!,
            tempNext3 = tempNext3!!,
            tempNext4 = tempNext4!!,
            tempNext5 = tempNext5!!,
            tempNext6 = tempNext6!!,
            tempNext7 = tempNext7!!,
            tempNext8 = tempNext8!!,
            tempNext9 = tempNext9!!,
            tempNext10 = tempNext10!!,
            tempNext11 = tempNext11!!,
            tempNext12 = tempNext12!!,


            temp_day1 = tempDay1!!,
            temp_day2 = tempDay2!!,
            temp_day3 = tempDay3!!,
            temp_day4 = tempDay4!!,
            cloud_day1 = cloudDay1!!,
            cloud_day2 = cloudDay2!!,
            cloud_day3 = cloudDay3!!,
            cloud_day4 = cloudDay4!!,
        )
    }
}