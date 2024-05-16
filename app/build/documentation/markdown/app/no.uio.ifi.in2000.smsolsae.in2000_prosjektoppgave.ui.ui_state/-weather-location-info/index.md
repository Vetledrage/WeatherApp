//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state](../index.md)/[WeatherLocationInfo](index.md)

# WeatherLocationInfo

[androidJvm]\
data class [WeatherLocationInfo](index.md)(val temperature: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val weatherCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val rain: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), val tempNext12hrs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TemperatureNext12Hours](../-temperature-next12-hours/index.md)&gt;, val tempNext7Days: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TemperatureNext7Days](../-temperature-next7-days/index.md)&gt;, val uvIndex: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), val windSpeed: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), val humidity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))

Represents weather info for a specific location

## Constructors

| | |
|---|---|
| [WeatherLocationInfo](-weather-location-info.md) | [androidJvm]<br>constructor(temperature: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), weatherCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), rain: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), tempNext12hrs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TemperatureNext12Hours](../-temperature-next12-hours/index.md)&gt;, tempNext7Days: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TemperatureNext7Days](../-temperature-next7-days/index.md)&gt;, uvIndex: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), windSpeed: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), humidity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [humidity](humidity.md) | [androidJvm]<br>val [humidity](humidity.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>the humidity in percentage |
| [rain](rain.md) | [androidJvm]<br>val [rain](rain.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>current rain level in millimeters |
| [temperature](temperature.md) | [androidJvm]<br>val [temperature](temperature.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>temperature in celcius |
| [tempNext12hrs](temp-next12hrs.md) | [androidJvm]<br>val [tempNext12hrs](temp-next12hrs.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TemperatureNext12Hours](../-temperature-next12-hours/index.md)&gt;<br>a list of temperatureNext12Hours-objects representing the temperature the next 12 hours |
| [tempNext7Days](temp-next7-days.md) | [androidJvm]<br>val [tempNext7Days](temp-next7-days.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TemperatureNext7Days](../-temperature-next7-days/index.md)&gt;<br>a list of temperatureNext9Days-objects representing the temperature the next 9 days |
| [uvIndex](uv-index.md) | [androidJvm]<br>val [uvIndex](uv-index.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>the uvindex |
| [weatherCode](weather-code.md) | [androidJvm]<br>val [weatherCode](weather-code.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>string representing the current weather condition |
| [windSpeed](wind-speed.md) | [androidJvm]<br>val [windSpeed](wind-speed.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>the wind speed in meters per second |
