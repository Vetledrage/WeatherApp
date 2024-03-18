package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave


//Klasse med routes til de forksjellige skjermene.
private object Route{
    const val WEATHER = "weather"
    const val HOME = "home"
}

sealed class Screen(val route: String){
    object Weather: Screen(Route.WEATHER)
    object Home: Screen(Route.HOME)
}