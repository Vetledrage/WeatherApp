//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource](../index.md)/[MetAlertsDataSource](index.md)

# MetAlertsDataSource

class [MetAlertsDataSource](index.md)(val baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Data source for the MetAlerts API.

#### Parameters

androidJvm

| | |
|---|---|
| baseUrl | The base url for the MetAlerts API |

## Constructors

| | |
|---|---|
| [MetAlertsDataSource](-met-alerts-data-source.md) | [androidJvm]<br>constructor(baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [baseUrl](base-url.md) | [androidJvm]<br>val [baseUrl](base-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Functions

| Name | Summary |
|---|---|
| [fetchMetAlerts](fetch-met-alerts.md) | [androidJvm]<br>suspend fun [fetchMetAlerts](fetch-met-alerts.md)(): [Build](../../no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data/-build/index.md)<br>Fetches the MetAlerts data. |
