package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AlertInfo

@Composable
fun AlertsBox(alert: MutableList<AlertInfo>){
    var expanded by remember { mutableStateOf(false) }
    var selectedLocation by remember { mutableStateOf(alert.first().areaA) }
    val selectedAlert = alert.firstOrNull {it.areaA == selectedLocation}
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.wrapContentSize(Alignment.TopStart)
        ){
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = selectedLocation,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .clickable { expanded = true }
                        .padding(4.dp)
                )

                Icon(
                    Icons.Filled.ArrowDropDown,
                    "dropdownmenu",
                    Modifier.clickable { expanded = true }
                )
            }

            DropdownMenu(expanded = expanded,
                onDismissRequest = { expanded = false},
                properties = PopupProperties(focusable = false)
            ) {
                alert.distinctBy { it.areaA }.forEach{ alert ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = alert.areaA,
                                fontSize = 22.sp
                            )
                        },
                        onClick = {
                            selectedLocation = alert.areaA
                            expanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))

        selectedAlert?.let { alert ->
            val backgroundColor = getBackgroundColorForDangerScale(alert.alertLevelA.split(";")[1].trim())
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .background(backgroundColor)
            ) {
                Column(
                    modifier = Modifier
                        .background(backgroundColor)
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Danger level: ${alert.alertLevelA.split(";")[0]}",
                        fontWeight = FontWeight(700),
                        fontSize = 28.sp
                    )
                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Description: ${alert.descriptionA}")
                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Location: ${alert.areaA}")

                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Consequense: ${alert.consequenseA}")

                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Alert Type: ${alert.alertTypeA}")

                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Recomendation: ${alert.recomendationA}")

                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Time interval: ${alert.timeIntervalA}")
                }
            }
        }
    }
}

// Funksjon for å hente farge basert på dangerScale
fun getBackgroundColorForDangerScale(dangerScale: String): Color {
    return when (dangerScale) {
        "red" -> Color.Red
        "yellow" -> Color.Yellow
        "orange" -> Color(0xFFFFA500) // RGBA verdi for oransje
        else -> Color.LightGray // Standardfarge hvis ingen kriterier møtes
    }
}

@Preview
@Composable
fun AlertBoxPreview(){

}