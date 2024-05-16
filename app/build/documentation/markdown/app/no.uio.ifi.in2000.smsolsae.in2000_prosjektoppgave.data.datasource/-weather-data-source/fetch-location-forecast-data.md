//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource](../index.md)/[WeatherDataSource](index.md)/[fetchLocationForecastData](fetch-location-forecast-data.md)

# fetchLocationForecastData

[androidJvm]\
suspend fun [fetchLocationForecastData](fetch-location-forecast-data.md)(lat: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), long: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), altitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [Model](../../no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data/-model/index.md)

Fetches location forecast based on the coordinates provided to the function

#### Return

Model object containing the result of requesting weather data request

#### Parameters

androidJvm

| | |
|---|---|
| lat | Latitude of the location |
| long | Longitude of the location |
| altitude | Altitude of the location (this parameter is optional) |
