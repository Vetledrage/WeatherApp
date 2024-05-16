//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel](../index.md)/[WeatherViewModel](index.md)

# WeatherViewModel

[androidJvm]\
class [WeatherViewModel](index.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

Weather view model. This class fetches weather data based on the user's location. It extends the ViewModel class.

## Constructors

| | |
|---|---|
| [WeatherViewModel](-weather-view-model.md) | [androidJvm]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [appUiState](app-ui-state.md) | [androidJvm]<br>val [appUiState](app-ui-state.md): StateFlow&lt;[AppUiState](../../no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state/-app-ui-state/index.md)&gt; |
| [errorMessage](error-message.md) | [androidJvm]<br>val [errorMessage](error-message.md): StateFlow&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?&gt; |
| [locationName](location-name.md) | [androidJvm]<br>val [locationName](location-name.md): StateFlow&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [getCoordinates](get-coordinates.md) | [androidJvm]<br>fun [getCoordinates](get-coordinates.md)(city: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Fetches coordinates for a given city and updates the state. |
| [getCurrentLocation](get-current-location.md) | [androidJvm]<br>fun [getCurrentLocation](get-current-location.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html))<br>Gets the user's current location and updates the location in the app. |
| [getWeatherInfo](get-weather-info.md) | [androidJvm]<br>fun [getWeatherInfo](get-weather-info.md)(lat: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), long: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), altitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null)<br>Updates the UI state with new weather info. |
| [hasLocationPermission](has-location-permission.md) | [androidJvm]<br>fun [hasLocationPermission](has-location-permission.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Checks if the app has location permission. |
| [setErrorMesageNull](set-error-mesage-null.md) | [androidJvm]<br>fun [setErrorMesageNull](set-error-mesage-null.md)()<br>Resets the error message to null. |
| [setLocationName](set-location-name.md) | [androidJvm]<br>fun [setLocationName](set-location-name.md)(newLocation: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Sets the location name. |
| [updateAlerts](update-alerts.md) | [androidJvm]<br>fun [updateAlerts](update-alerts.md)()<br>Fetches the latest alerts information and updates the UI state. |
| [updateWeatherInfo](update-weather-info.md) | [androidJvm]<br>fun [updateWeatherInfo](update-weather-info.md)(lat: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), long: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), altitude: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null)<br>Updates the existing UI state with new weather info. |
