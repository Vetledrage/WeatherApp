//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather](../index.md)/[WeatherRepository](index.md)

# WeatherRepository

interface [WeatherRepository](index.md)

Interface for WeatherRepository, which is a repository for weather data. Implemented in ImplementedWeatherRepository.

#### Inheritors

| |
|---|
| [ImplementedWeatherRepository](../-implemented-weather-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getLocationWeather](get-location-weather.md) | [androidJvm]<br>abstract suspend fun [getLocationWeather](get-location-weather.md)(latitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), longitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), altitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [WeatherLocationInfo](../../no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state/-weather-location-info/index.md)<br>Fetches the weather information for a specific location. |
