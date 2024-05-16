//[app](../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [SettingsState](-settings-state/index.md) | [androidJvm]<br>data class [SettingsState](-settings-state/index.md)(val darkModeEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val notificationsEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val biggerFontSize: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val textToSpeach: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>Data class representing the state of settings. |
| [SettingsViewModel](-settings-view-model/index.md) | [androidJvm]<br>class [SettingsViewModel](-settings-view-model/index.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>ViewModel for managing settings state. |
| [WeatherViewModel](-weather-view-model/index.md) | [androidJvm]<br>class [WeatherViewModel](-weather-view-model/index.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)<br>Weather view model. This class fetches weather data based on the user's location. It extends the ViewModel class. |
