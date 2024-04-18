package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.BottomBar
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.Header
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.SettingsViewModel

/**
 * Screen for the settings
 * @param navController For standard navigation.
 * @param viewModel the viewmodel to save the state of the chosen settings.
 */
@Composable
fun SettingsScreen(navController: NavController, viewModel: SettingsViewModel = viewModel()){
    val settingsState by viewModel.settingsState.collectAsState()
    val scrollState = rememberScrollState()
    
    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) {paddingVal ->

        Column(
            modifier = Modifier
                .padding(paddingVal)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Header(label = "Settings", icon = Icons.Default.Settings)

            SettingItem(
                label = "Dark Mode",
                isEnabled = settingsState.darkModeEnabled,
                onToggle = { viewModel.toggleSetting("dark_mode") }
            )
            
            SettingItem(
                label = "Notifications",
                isEnabled = settingsState.notificationsEnabled,
                onToggle = { viewModel.toggleSetting("notifications") }
            )

        }
    }
}

@Composable
fun SettingItem(label: String, isEnabled: Boolean, onToggle: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onToggle),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.LocationOn, 
            contentDescription = label
        )
        
        Spacer(modifier = Modifier.width(5.dp))
        
        Text(
            text = label,
            textAlign = TextAlign.Left,
            fontSize = 20.sp,
            modifier = Modifier.weight(1f)
        )

        Switch(
            checked = isEnabled,
            onCheckedChange = { onToggle() },
            modifier = Modifier.padding(end = 16.dp)
        )
    }
    HorizontalDivider(
        color = Color.LightGray,
        thickness = 1.dp,
    )
}

@Preview(showSystemUi = true)
@Composable
fun SettingsPreview(){
    SettingsScreen(navController = rememberNavController(), viewModel = SettingsViewModel() )
}