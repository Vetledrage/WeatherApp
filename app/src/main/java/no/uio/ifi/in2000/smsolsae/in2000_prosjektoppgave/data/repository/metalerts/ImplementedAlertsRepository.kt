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
        var cons : String?
        var rec : String?
        var desc: String?
        var alertType: String?
        var alertLevel: String?
        var timeIntervalA: List<String?>?

        alert.features?.forEach{
            val prop = it.properties

            area = prop?.area
            type = prop?.eventAwarenessName
            cons = prop?.consequences
            rec = prop?.instruction
            desc = prop?.description
            alertType = prop?.awareness_type
            alertLevel = prop?.awareness_level
            timeIntervalA = it.tid?.interval

            val alertF = AlertInfo(
                areaA = area!!,
                typeA = type!!,
                consequenseA = cons!!,
                recomendationA = rec!!,
                descriptionA = desc!!,
                alertTypeA = alertType!!,
                alertLevelA = alertLevel!!,
                timeIntervalA = timeIntervalA!!
            )

            alertList.add(alertF)
        }
        return alertList
    }
}

