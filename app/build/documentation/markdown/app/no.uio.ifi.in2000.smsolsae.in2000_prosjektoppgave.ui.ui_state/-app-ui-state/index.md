//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state](../index.md)/[AppUiState](index.md)

# AppUiState

sealed interface [AppUiState](index.md)

Represents the possible states of the ui related to fetching and display of weather information. Three states that express the states the UI can be in

#### Inheritors

| |
|---|
| [Success](-success/index.md) |
| [Error](-error/index.md) |
| [Loading](-loading/index.md) |

## Types

| Name | Summary |
|---|---|
| [Error](-error/index.md) | [androidJvm]<br>data object [Error](-error/index.md) : [AppUiState](index.md) |
| [Loading](-loading/index.md) | [androidJvm]<br>data object [Loading](-loading/index.md) : [AppUiState](index.md) |
| [Success](-success/index.md) | [androidJvm]<br>data class [Success](-success/index.md)(val weather: [WeatherLocationInfo](../-weather-location-info/index.md), val alerts: [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[AlertInfo](../-alert-info/index.md)&gt;) : [AppUiState](index.md) |
