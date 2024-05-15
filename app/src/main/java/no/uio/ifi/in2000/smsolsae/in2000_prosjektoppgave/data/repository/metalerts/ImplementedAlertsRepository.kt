package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.metalerts

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource.MetAlertsDataSource
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AlertInfo

/**
 * Implementation of the AlertsRepository interface.
 */
class ImplementedAlertsRepository : AlertsRepository {
    private val dataSource = MetAlertsDataSource(baseUrl = "https://gw-uio.intark.uh-it.no/in2000/weatherapi")

    /**
     * Fetches the alert information from the data source and returns a list of AlertInfo objects.
     * @return A mutable list of AlertInfo objects containing detailed information about alerts.
     */
    override suspend fun getAlertsInfo(): MutableList<AlertInfo> {
        //Fetch alert data from the data source
        val alert = dataSource.fetchMetAlerts()

        //Initialize an empty list to store alert information
        val alertList : MutableList<AlertInfo> = mutableListOf()

        //Temporary variables to hold alert properties
        var area : String?
        var type : String?
        var consequence : String?
        var recomendation : String?
        var description: String?
        var alertType: String?
        var alertLevel: String?
        var timeInterval: List<String?>?

        //Iterate over each feature in the alert data
        alert.features?.forEach{
            val prop = it.properties

            //Extracting the properties from the feature
            area = prop?.area
            type = prop?.eventAwarenessName
            consequence = prop?.consequences
            recomendation = prop?.instruction
            description = prop?.description
            alertType = prop?.awareness_type
            alertLevel = prop?.awareness_level
            timeInterval = it.time?.interval

            //Create an AlertInfo object with the extracted properties
            val alertF = AlertInfo(
                area = area,
                type = type,
                consequense = consequence,
                recomendation = recomendation,
                description = description,
                alertType = alertType,
                alertLevel = alertLevel,
                timeInterval = timeInterval
            )

            //Add the AlertInfo object to the list
            alertList.add(alertF)
        }
        //Returning the list of alert information
        return alertList
    }
}

