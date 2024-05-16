//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel](../index.md)/[SettingsViewModel](index.md)

# SettingsViewModel

[androidJvm]\
class [SettingsViewModel](index.md) : [ViewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/ViewModel.html)

ViewModel for managing settings state.

## Constructors

| | |
|---|---|
| [SettingsViewModel](-settings-view-model.md) | [androidJvm]<br>constructor() |

## Properties

| Name | Summary |
|---|---|
| [settingsState](settings-state.md) | [androidJvm]<br>val [settingsState](settings-state.md): StateFlow&lt;[SettingsState](../-settings-state/index.md)&gt;<br>Publicly exposed StateFlow for observing the settings state. |

## Functions

| Name | Summary |
|---|---|
| [addCloseable](../-weather-view-model/index.md#264516373%2FFunctions%2F-912451524) | [androidJvm]<br>open fun [addCloseable](../-weather-view-model/index.md#264516373%2FFunctions%2F-912451524)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [Closeable](https://developer.android.com/reference/kotlin/java/io/Closeable.html)) |
| [toggleSetting](toggle-setting.md) | [androidJvm]<br>fun [toggleSetting](toggle-setting.md)(settingId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Toggles the setting based on the provided settingId. |
