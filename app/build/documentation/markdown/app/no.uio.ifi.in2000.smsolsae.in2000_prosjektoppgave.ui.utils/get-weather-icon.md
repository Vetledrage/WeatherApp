//[app](../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils](index.md)/[getWeatherIcon](get-weather-icon.md)

# getWeatherIcon

[androidJvm]\
fun [getWeatherIcon](get-weather-icon.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), symbolCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Gets a weather icon based on string input

#### Return

The weather icon corresponding to the string. If none of the symbol names match, a default value, sunny, is returned.

#### Parameters

androidJvm

| | |
|---|---|
| symbolCode | The weather id we get |
| context | The Context of the app. |
