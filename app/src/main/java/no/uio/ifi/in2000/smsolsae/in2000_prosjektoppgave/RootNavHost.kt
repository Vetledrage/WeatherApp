package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens.AlertsScreen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens.HomeScreen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens.InformationScreen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens.SettingsScreen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens.WeatherScreen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.SettingsViewModel
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel


/**
 * Manages the navigation between the different screens.
 * @param navController: The navhostcontroller. (For more information on navigation: please see the Android documentation)
 * @param context: The context is used to send to the Screens that needs the activity context.
 */
@Composable
fun RootNavHost(navController: NavHostController, context: Context){
    val viewModel: WeatherViewModel = viewModel()
    val settingsViewmodel: SettingsViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(Screen.Home.route){
            HomeScreen(navController = navController, viewModel = viewModel, context)
        }

        composable(route = Screen.Weather.route){
            WeatherScreen(navController = navController, viewModel = viewModel)
        }
        
        composable(route = Screen.Alerts.route){
            AlertsScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screen.Settings.route){
            SettingsScreen(navController = navController, viewModel = settingsViewmodel)
        }

        composable(route = Screen.Info.route){
            InformationScreen(navController = navController)
        }
    }
}