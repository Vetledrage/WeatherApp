package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.WeatherLocationUiState

interface WeatherRepository{
    suspend fun getLocation(latitude: String, longitude: String, altitude: String) : WeatherLocationUiState
}
