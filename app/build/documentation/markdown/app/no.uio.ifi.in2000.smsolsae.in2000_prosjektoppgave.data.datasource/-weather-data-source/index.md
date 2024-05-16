//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource](../index.md)/[WeatherDataSource](index.md)

# WeatherDataSource

class [WeatherDataSource](index.md)(val baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Data source for Weather data

#### Parameters

androidJvm

| | |
|---|---|
| baseUrl | url to fetch weather data from |

## Constructors

| | |
|---|---|
| [WeatherDataSource](-weather-data-source.md) | [androidJvm]<br>constructor(baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [baseUrl](base-url.md) | [androidJvm]<br>val [baseUrl](base-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Functions

| Name | Summary |
|---|---|
| [fetchLocationForecastData](fetch-location-forecast-data.md) | [androidJvm]<br>suspend fun [fetchLocationForecastData](fetch-location-forecast-data.md)(lat: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), long: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), altitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [Model](../../no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data/-model/index.md)<br>Fetches location forecast based on the coordinates provided to the function |
