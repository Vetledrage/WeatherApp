package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AppUiState
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WeatherFromApiScreen(navController: NavController, viewModel: WeatherViewModel = viewModel()){
    viewModel.getWeatherInfo("59", "10")
    val weatherData by viewModel.appUiState.collectAsState()
    //val a = (weatherData as AppUiState.Success).locationF //Kaller den sånn så får man aksessere dataen vi trenger

    //Log.d("LocationF", "WeatherFromApiScreen: ${a.temperatureL}")

    Scaffold {
        Column {
            when(weatherData){
                is AppUiState.Loading -> {
                    Text(text = "Loading")
                }
                is AppUiState.Success -> {
                    val a = (weatherData as AppUiState.Success).locationF
                    Text(text = "Success")
                    Text(text = "${a.temperatureL}")
                }
                is AppUiState.Error ->{
                    Text(text = "Error")
                }
            }

        }
    }

}