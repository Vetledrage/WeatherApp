package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens.HomeScreen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens.WeatherScreen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel


//Klasse som tar hånd om navigasjon mellom forskjellige sidene.
@Composable
fun RootNavHost(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(Screen.Home.route){
            HomeScreen(navController = navController, viewModel = WeatherViewModel())
        }

        composable(route = Screen.Weather.route){
            WeatherScreen(navController = navController, viewModel = WeatherViewModel())
        }
    }
}