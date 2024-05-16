//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather](../index.md)/[ImplementedWeatherRepository](index.md)/[getLocationWeather](get-location-weather.md)

# getLocationWeather

[androidJvm]\
open suspend override fun [getLocationWeather](get-location-weather.md)(latitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), longitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), altitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [WeatherLocationInfo](../../no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state/-weather-location-info/index.md)

Fetches the weather information for a specific location.

#### Return

WeatherLocationInfo object containing detailed weather information for the location.

#### Parameters

androidJvm

| | |
|---|---|
| latitude | Latitude of the location. |
| longitude | Longitude of the location. |
| altitude | Altitude of the location. (This variable is ooptional). |
