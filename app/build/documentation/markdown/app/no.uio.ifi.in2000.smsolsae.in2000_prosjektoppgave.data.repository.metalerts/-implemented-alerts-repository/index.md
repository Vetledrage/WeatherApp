//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.metalerts](../index.md)/[ImplementedAlertsRepository](index.md)

# ImplementedAlertsRepository

[androidJvm]\
class [ImplementedAlertsRepository](index.md) : [AlertsRepository](../-alerts-repository/index.md)

Implementation of the AlertsRepository interface.

## Constructors

| | |
|---|---|
| [ImplementedAlertsRepository](-implemented-alerts-repository.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [getAlertsInfo](get-alerts-info.md) | [androidJvm]<br>open suspend override fun [getAlertsInfo](get-alerts-info.md)(): [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[AlertInfo](../../no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state/-alert-info/index.md)&gt;<br>Fetches the alert information from the data source and returns a list of AlertInfo objects. |
