package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


/**
 * Screen for the settings
 * @param navController For standard navigation.
 */
@Composable
fun SettingsScreen(navController: NavController){

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Settings")
    }
}