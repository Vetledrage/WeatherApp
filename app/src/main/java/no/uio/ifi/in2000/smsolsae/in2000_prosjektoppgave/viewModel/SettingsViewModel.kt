package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SettingsViewModel : ViewModel() {
    private val _settingsState = MutableStateFlow(SettingsState())
    val settingsState: StateFlow<SettingsState> = _settingsState

    fun toggleSetting(settingId: String) {
        _settingsState.value = when (settingId) {
            "dark_mode" -> _settingsState.value.copy(darkModeEnabled = !_settingsState.value.darkModeEnabled)
            "notifications" -> _settingsState.value.copy(notificationsEnabled = !_settingsState.value.notificationsEnabled)
            "bigger_font" -> _settingsState.value.copy(biggerFontSize = !_settingsState.value.biggerFontSize)
            "text_to_speach" -> _settingsState.value.copy(textToSpeach = !_settingsState.value.textToSpeach)

            // Add more settings here as needed
            else -> _settingsState.value // If settingId doesn't match any known setting, return current state
        }
    }



}


data class SettingsState(
    val darkModeEnabled: Boolean = false,
    val notificationsEnabled: Boolean = false,
    val biggerFontSize: Boolean = false,
    val textToSpeach: Boolean = false
)