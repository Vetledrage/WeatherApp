package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * ViewModel for managing settings state.
 */
class SettingsViewModel : ViewModel() {
    // Backing property for the settings state using MutableStateFlow
    private val _settingsState = MutableStateFlow(SettingsState())

    /**
     * Publicly exposed StateFlow for observing the settings state.
     */
    val settingsState: StateFlow<SettingsState> = _settingsState

    /**
     * Toggles the setting based on the provided settingId.
     * @param settingId The ID of the setting to be toggled.
     */
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

/**
 * Data class representing the state of settings.
 * @property darkModeEnabled Indicates if dark mode is enabled.
 * @property notificationsEnabled Indicates if notifications are enabled.
 * @property biggerFontSize Indicates if the bigger font size is enabled.
 * @property textToSpeach Indicates if text-to-speech is enabled.
 */
data class SettingsState(
    val darkModeEnabled: Boolean = false,
    val notificationsEnabled: Boolean = false,
    val biggerFontSize: Boolean = false,
    val textToSpeach: Boolean = false
)