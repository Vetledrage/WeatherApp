package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens.AlertsScreen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens.HomeScreen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens.WeatherScreen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel


//Klasse som tar hånd om navigasjon mellom forskjellige sidene.
@Composable
fun RootNavHost(navController: NavHostController){
    val viewModel: WeatherViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(Screen.Home.route){
            HomeScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screen.Weather.route){
            WeatherScreen(navController = navController, viewModel = viewModel)
        }
        
        composable(route = Screen.Alerts.route){
            AlertsScreen(navController = navController, viewModel = viewModel)
        }
    }
}