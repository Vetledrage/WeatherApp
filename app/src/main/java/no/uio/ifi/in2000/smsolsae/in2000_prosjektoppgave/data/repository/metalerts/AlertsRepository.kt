package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.metalerts

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AlertInfo

/**
 * Interface for the AlertsRepository. Implemented in the class ImplementedAlertsRepository.
 */
interface AlertsRepository {
    /**
     * Fetches the alert information from the data source and returns a list of AlertInfo objects.
     * @return A mutable list of AlertInfo objects containing detailed information about alerts.
     */
    suspend fun getAlertsInfo(): MutableList<AlertInfo>

}