package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.AlertsBox
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.BottomBar
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.ErrorScreen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.Header
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.LoadingAnimation
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.NoDataComponent
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AppUiState
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel


/**
 * Composable function for the alerts screen. Will show colored alert icons based on the grade of danger.
 * @param navController for standard navigation
 * @param viewModel the weather view model
 */
@Composable
fun AlertsScreen(navController: NavController, viewModel: WeatherViewModel = viewModel()){
    val alertsData by viewModel.appUiState.collectAsState()
    val scrollState = rememberScrollState()

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
                ErrorScreen(errorMsg = "Something bad happend here!", onRetry = {viewModel.updateAlerts()})
            }

            is AppUiState.Success -> {
                val alertsList = (alertsData as AppUiState.Success).alerts
                Scaffold(
                    bottomBar = {
                        BottomBar(navController)
                    }
                ) { innerPadding ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .verticalScroll(state = scrollState),
                    ) {
                        Header(label = "Met Alerts", icon = Icons.Filled.Notifications)

                        Spacer(modifier = Modifier.height(20.dp))

                        if (alertsList.isNotEmpty()){
                            AlertsBox(alertsList)
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Card(
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.padding(8.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Info,
                                            contentDescription = "Info",
                                            modifier = Modifier.size(15.dp)
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))

                                        Text(
                                            text = "This page contains information about alerts in Norway.\n" +
                                                    "Currently we only have alerts information for Norway.",
                                            textAlign = TextAlign.Center,

                                        )
                                    }
                                }
                            }
                        }else{
                            NoDataComponent(
                                text = "There are no alerts for now",
                                onRetry = {
                                    viewModel.updateAlerts()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}