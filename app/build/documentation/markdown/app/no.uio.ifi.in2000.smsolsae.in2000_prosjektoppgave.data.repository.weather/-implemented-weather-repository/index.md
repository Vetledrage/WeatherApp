//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather](../index.md)/[ImplementedWeatherRepository](index.md)

# ImplementedWeatherRepository

[androidJvm]\
class [ImplementedWeatherRepository](index.md) : [WeatherRepository](../-weather-repository/index.md)

Repository for weather data. This class implements the WeatherRepository interface and provides methods to fetch and process weather data.

## Constructors

| | |
|---|---|
| [ImplementedWeatherRepository](-implemented-weather-repository.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [getLocationWeather](get-location-weather.md) | [androidJvm]<br>open suspend override fun [getLocationWeather](get-location-weather.md)(latitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), longitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), altitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [WeatherLocationInfo](../../no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state/-weather-location-info/index.md)<br>Fetches the weather information for a specific location. |
