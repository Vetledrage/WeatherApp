package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.LoadingAnimation
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AppUiState
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WeatherFromApiScreen(navController: NavController, viewModel: WeatherViewModel = viewModel()){
    viewModel.getWeatherInfo("59", "10")
    val weatherData by viewModel.appUiState.collectAsState()


    Scaffold {
        Column {
            when(weatherData){
                is AppUiState.Loading -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        LoadingAnimation(text = "Loading Weather data")
                    }
                }
                is AppUiState.Success -> {
                    val a = (weatherData as AppUiState.Success).locationF //Kaller den sånn så får man aksessere dataen vi trenger
                    Text(text = "Success")
                    Text(text = "${a}")
                }
                is AppUiState.Error ->{
                    Text(text = "Error")
                }
            }

        }
    }

}