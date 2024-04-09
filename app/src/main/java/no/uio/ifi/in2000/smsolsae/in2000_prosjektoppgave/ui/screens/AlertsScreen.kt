package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.AlertsBox
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.BottomBar
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.CustomBox
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.LoadingAnimation
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AppUiState
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel

@Composable
fun AlertsScreen(navController: NavController, viewModel: WeatherViewModel = viewModel()){
    val alertsData by viewModel.appUiState.collectAsState()



    Surface(modifier = Modifier.fillMaxSize()) {
        when (alertsData){
            is AppUiState.Loading -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    LoadingAnimation(text = "Loading Data...")
                }
            }
            is AppUiState.Error -> {
                Text(text = "Error in getting alerts info")
            }

            is AppUiState.Success -> {
                val alertsList = (alertsData as AppUiState.Success).alerts
                Scaffold(
                    bottomBar = {
                        BottomBar(navController)
                    }
                ) { innerPadding ->

                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        if (alertsList.isNotEmpty()){
                            AlertsBox(alertsList)
                        }
                        val backgroundImage = painterResource(id = R.drawable.ic_icebear_background)

                        CustomBox(
                            modifier = Modifier.padding(16.dp),
                            backgroundImage = backgroundImage,
                            text = "The Fact of the day is that its raining so much, we will all drown",
                            textSize = 20.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(60.dp))



                }
            }
        }
    }
}


@Preview
@Composable
fun AlertsScreenPreview(){
    AlertsScreen(navController = rememberNavController(), viewModel = WeatherViewModel())
}