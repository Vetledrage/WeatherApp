package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.metalerts

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource.MetAlertsDataSource
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AlertInfo

class ImplementedAlertsRepository : AlertsRepository {
    private val dataSource = MetAlertsDataSource(baseUrl = "https://gw-uio.intark.uh-it.no/in2000/weatherapi")
    override suspend fun getAlertsInfo(): MutableList<AlertInfo> {
        val alert = dataSource.fetchMetAlerts()

        val alertList : MutableList<AlertInfo> = mutableListOf()
        var area : String?
        var type : String?
        var consequence : String?
        var recomendation : String?
        var description: String?
        var alertType: String?
        var alertLevel: String?
        var timeIntervalA: List<String?>?

        alert.features?.forEach{
            val prop = it.properties

            area = prop?.area
            type = prop?.eventAwarenessName
            consequence = prop?.consequences
            recomendation = prop?.instruction
            description = prop?.description
            alertType = prop?.awareness_type
            alertLevel = prop?.awareness_level
            timeIntervalA = it.tid?.interval

            val alertF = AlertInfo(
                area = area,
                type = type,
                consequense = consequence,
                recomendation = recomendation,
                description = description,
                alertType = alertType,
                alertLevel = alertLevel,
                timeInterval = timeIntervalA
            )

            alertList.add(alertF)
        }
        return alertList
    }
}

