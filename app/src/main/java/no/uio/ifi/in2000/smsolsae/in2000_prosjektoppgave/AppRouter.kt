package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave



/**
 * Class with routes to the different screens. It is an object because we are only making one
 * for the whole application. (More information to be added).
 *
 * @property WEATHER Weather Screen string
 * @property HOME Home Screen string
 * @property SETTINGS Settings Screen string
 * @property ALERTS Alerts Screen string
 * @constructor
 */
private object Route{
    const val WEATHER = "weather"
    const val HOME = "home"
    const val SETTINGS = "settings"
    const val ALERTS = "alerts"
    const val INFO = "info"
}

/**
 * Class which contains the screens. (More information to be added)
 *
 * @param route: The screen object receives the name of the route as a String.
 */

sealed class Screen(val route: String){
    object Weather: Screen(Route.WEATHER)
    object Home: Screen(Route.HOME)
    object Settings: Screen(Route.SETTINGS)
    object Alerts: Screen(Route.ALERTS)
    object Info: Screen(Route.INFO)

}