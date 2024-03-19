package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data

sealed class Resource(
    val weather: String = ""
) {
    class Success(val info: String) : Resource(weather = info)
    object Loading : Resource()
    data class Error(val err: Throwable) : Resource()
}