package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.metalerts

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AlertInfo

interface AlertsRepository {
    suspend fun getAlertsInfo(lat: String, long: String): MutableList<AlertInfo>

}