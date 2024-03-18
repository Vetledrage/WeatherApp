package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.weatherData

data class WeeklyWeather(
    val weekDay: String,
    val date: String,
    val temperature: Int,
    val weatherIconId: Int
)


data class HourlyWeather(
    val time: String,
    val temperature: Int,
    val weatherIconId: Int
)