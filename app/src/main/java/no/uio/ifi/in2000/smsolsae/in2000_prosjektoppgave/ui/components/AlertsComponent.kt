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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AlertInfo
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.formatAlertsDate

/**
 * Composable function for showing an box with alerts on the screen
 * @param alert A mutable list containting AlertInfo-objects.
 */
@Composable
fun AlertsBox(alert: MutableList<AlertInfo>){
    var expanded by remember { mutableStateOf(false) }
    var selectedLocation by remember { mutableStateOf(alert.first().area) }
    val selectedAlert = alert.firstOrNull {it.area == selectedLocation}

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
                    text = selectedLocation!!,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .clickable { expanded = true }
                        .padding(8.dp)
                )

                Icon(
                    Icons.Filled.ArrowDropDown,
                    "dropdownmenu",
                    Modifier.clickable { expanded = true }
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false},
            ) {
                alert.distinctBy { it.area }.forEach{ alert ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = alert.area!!,
                                fontSize = 18.sp
                            )
                        },
                        onClick = {
                            selectedLocation = alert.area
                            expanded = false
                        },

                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        selectedAlert?.let { alert ->
            val backgroundColor = getBackgroundColorForDangerScale(alert.alertLevel!!.split(";")[1].trim())
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
                        text = "Danger level: ${alert.alertLevel.split(";")[0]}",
                        fontWeight = FontWeight(700),
                        fontSize = 28.sp
                    )
                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Description: ${alert.description}")
                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Location: ${alert.area}")

                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Consequense: ${alert.consequense}")

                    Spacer(modifier = Modifier.height(7.dp))


                    Spacer(modifier = Modifier.height(7.dp))

                    Text("Recomendation: ${alert.recomendation}")

                    Spacer(modifier = Modifier.height(7.dp))
                    val startTime = formatAlertsDate(alert.timeInterval!![0]!!)
                    val endTime = formatAlertsDate(alert.timeInterval[1]!!)

                    Text("Time interval: $startTime - $endTime")
                }
            }
        }
    }
}


/**
 * Function for fetching color based on dangerScale, which is passed into the function as
 * an argument.
 * @param dangerScale a string expressing the grade of danger. Name of a color.
 * @return The correct Color object corresponding to the dangerScale string.
 */
fun getBackgroundColorForDangerScale(dangerScale: String): Color {
    return when (dangerScale) {
        "red" -> Color.Red
        "yellow" -> Color.Yellow
        "orange" -> Color(0xFFFFA500) // RGBA code for orange
        "green" -> Color.Green
        else -> Color.LightGray //Standard color GREY else.
    }
}
