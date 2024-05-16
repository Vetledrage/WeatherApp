//[app](../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils](index.md)/[pickBear](pick-bear.md)

# pickBear

[androidJvm]\
fun [pickBear](pick-bear.md)(temperature: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 15, humidity: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 70, weatherCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;clearsky_day&quot;, error: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Function for returning a string with bear-type based on temperature, humidity, and weather tags.

#### Return

one of eight bear types (polar, brown, panda, am-black, as-black, spectacled, sun, sloth)

#### Parameters

androidJvm

| | |
|---|---|
| temperature | representation of the temperature |
| humidity | representation of relative air humidity |
| weatherCode | represantation of weather which is translated to sunny, cloudy, rainy, or other |
