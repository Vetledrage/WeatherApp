//[app](../../../index.md)/[no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.datasource](../index.md)/[MapSearchDataSource](index.md)/[fetchMapSearch](fetch-map-search.md)

# fetchMapSearch

[androidJvm]\
suspend fun [fetchMapSearch](fetch-map-search.md)(city: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MapModel](../../no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data/-map-model/index.md)?

Fetches the map search results for a given city.

#### Return

A [MapModel](../../no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data/-map-model/index.md) object containing the search results. Null if an error occurs.

#### Parameters

androidJvm

| | |
|---|---|
| city | The name of the city to search for. |
