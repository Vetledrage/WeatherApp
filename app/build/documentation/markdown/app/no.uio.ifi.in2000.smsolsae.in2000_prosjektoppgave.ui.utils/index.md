//[app](../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [DailyFactManager](-daily-fact-manager/index.md) | [androidJvm]<br>class [DailyFactManager](-daily-fact-manager/index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))<br>Class to manage the daily facts. Will ensure that a new fact is generated each day. |

## Functions

| Name | Summary |
|---|---|
| [formatAlertsDate](format-alerts-date.md) | [androidJvm]<br>fun [formatAlertsDate](format-alerts-date.md)(date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Function for formatting data from metalerts API to be shorter and more readable |
| [formatDate](format-date.md) | [androidJvm]<br>fun [formatDate](format-date.md)(date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Function for formatting data from API to be shorter and more readable |
| [formatTime](format-time.md) | [androidJvm]<br>fun [formatTime](format-time.md)(time: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Function for formatting the time we get from the API to show only hours and minutes. |
| [getBearImageResource](get-bear-image-resource.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [getBearImageResource](get-bear-image-resource.md)(bear: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Composable function for displaying the bear image. |
| [getDay](get-day.md) | [androidJvm]<br>fun [getDay](get-day.md)(date: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Fetches the day based on input date |
| [getLiveDateTime](get-live-date-time.md) | [androidJvm]<br>fun [getLiveDateTime](get-live-date-time.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns current time an date |
| [getWeatherIcon](get-weather-icon.md) | [androidJvm]<br>fun [getWeatherIcon](get-weather-icon.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), symbolCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Gets a weather icon based on string input |
| [pickBear](pick-bear.md) | [androidJvm]<br>fun [pickBear](pick-bear.md)(temperature: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 15, humidity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 70, weatherCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;clearsky_day&quot;, error: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Function for returning a string with bear-type based on temperature, humidity, and weather tags. |
| [WeatherAnimation](-weather-animation.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [WeatherAnimation](-weather-animation.md)(weather: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Function to display weather animations based on the provided weather condition. |
| [weatherCodeBetterNames](weather-code-better-names.md) | [androidJvm]<br>@[Composable](https://developer.android.com/reference/kotlin/androidx/compose/runtime/Composable.html)<br>fun [weatherCodeBetterNames](weather-code-better-names.md)(weatherName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This function gives a written summary of the forecast based on the weather code |
| [weatherType](weather-type.md) | [androidJvm]<br>fun [weatherType](weather-type.md)(weatherCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Helper function for returning a string with weather type based on weather tags. |
