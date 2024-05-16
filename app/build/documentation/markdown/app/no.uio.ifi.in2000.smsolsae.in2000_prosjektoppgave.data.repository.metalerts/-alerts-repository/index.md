//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.metalerts](../index.md)/[AlertsRepository](index.md)

# AlertsRepository

interface [AlertsRepository](index.md)

Interface for the AlertsRepository. Implemented in the class ImplementedAlertsRepository.

#### Inheritors

| |
|---|
| [ImplementedAlertsRepository](../-implemented-alerts-repository/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getAlertsInfo](get-alerts-info.md) | [androidJvm]<br>abstract suspend fun [getAlertsInfo](get-alerts-info.md)(): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[AlertInfo](../../no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state/-alert-info/index.md)&gt;<br>Fetches the alert information from the data source and returns a list of AlertInfo objects. |
