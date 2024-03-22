package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.Alert
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.AlertsBox
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.BottomBar
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.CustomBox
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel

@Composable
fun AlertsScreen(navController: NavController, viewModel: WeatherViewModel = viewModel()){
    val redAlert = Alert(
        description = "Ekstremt høy vannstand forventet. Evakuer lavtliggende områder umiddelbart.",
        dangerScale = "Rød",
        icon = R.drawable.triangle_exclamation_solid,
        location = "Bergen"
    )

    val yellowAlert = Alert(
        description = "Moderate vindkast ventes. Vær oppmerksom på løse gjenstander utendørs.",
        dangerScale = "Gul",
        icon = R.drawable.triangle_exclamation_solid,
        location = "Oslo"
    )

    val orangeAlert = Alert(
        description = "Sterk snøstorm forventet. Unngå unødvendig reise.",
        dangerScale = "Oransje",
        icon = R.drawable.triangle_exclamation_solid,
        location = "Tromsø"
    )

    val alertList = listOf<Alert>(orangeAlert, yellowAlert, redAlert)

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            bottomBar = {
                BottomBar(navController)
            }
        ) { innerPadding ->

            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                AlertsBox(alertList)
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



@Preview
@Composable
fun AlertsScreenPreview(){
    AlertsScreen(navController = rememberNavController(), viewModel = WeatherViewModel())
}