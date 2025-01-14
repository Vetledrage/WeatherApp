package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.BottomBar
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.Header

/**
 * Composable function to display the Information screen.
 * @param navController Controller to handle navigation actions.
 */
@Composable
fun InformationScreen(navController: NavController){
    //List of information terms and their descriptions
    val informationList = listOf(
        "Humidity" to "Humidity refers to how much moisture or water vapor is in the air. When humidity is high, the air feels damp. When it's low, the air feels dry. \n\nHumidity is often measured with percentages. These percentage values refer to how much water vapor is in the air relative to the maximum capacity at a given temperature. This is called relative humidity.",
        "Temperature" to "Temperature measures how hot or cold something is. It's what you feel when you step outside. The higher the temperature the hotter it is. A low temperature, especially below 0, means it's cold.",
        "Wind Speed" to "Wind speed tells us how fast the air is moving. The higher the wind speed, the stronger the wind feels.",
        "Rainfall" to "Rainfall is when water falls from the sky in the form of raindrops. Heavy rainfall means a lot of rain is falling, while light rainfall means just a little.",
        "Cloud Cover" to "Cloud cover refers to how much of the sky is covered by clouds. When there are a lot of clouds, the sky looks gray and you might not see the sun. When there are few clouds, the sky looks clear and the sun shines through.",
        "Pressure" to "Pressure, or atmospheric pressure, is the force of the air pushing down on the Earth's surface. High pressure usually means there will be fair weather, while low pressure can bring storms and rain.",
        "Sunshine" to "Sunshine refers to how much sunlight is reaching the ground down on earth. When it's sunny, the sky is bright and you feel warm. When it's cloudy, there's less sunshine.",
        "Visibility" to "Visibility tells us how far we can see clearly. Good visibility means you can see far ahead, while poor visibility means things are blurry or hard to see because of things like fog, rain, or snow.",
        "UV radiation" to "UV radiation is a type of sunlight that human eyes can't see. It can be good for us because it helps our bodies make vitamin D, but too much UV radiation can hurt our skin and eyes. It is very important that we protect ourselves by wearing sunscreen, hats, and sunglasses when we're outside in the sun. That way, we stay safe and healthy!",
        "UV index" to "The UV index is a scale that measures the intensity of UV radiation. The scale is measured from 0 and upwards, where higher values indicate larger risks of skin and eye damage or irritation. \n\n" +
                "Here are the World Health Organization’s UV index recommendations: \n" +
                "0 to 2: You can safely enjoy being outside!\n" +
                "3 to 7: Seek shade during midday hours! Slip on a shirt, slop on sunscreen and slap on hat!\n" +
                "8+: Avoid being outside during midday hours! Make sure you seek shade! Shirt, sunscreen and hat are a must!\n"
    )

    //State to keep track of the expanded index
    var expandedIndex by remember { mutableIntStateOf(-1) }

    Scaffold(
        bottomBar = {
            //Bottom bar with navigation controls
            BottomBar(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)

        ) {
            //Header of the Information screen
            Header(label = "Information", icon = Icons.Default.Info)

            LazyColumn {
                itemsIndexed(informationList){index, (term, description) ->
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = term,
                                style = MaterialTheme.typography.titleLarge,
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable {
                                        expandedIndex =
                                            if (expandedIndex == index) -1 else index
                                    }
                            )

                            Icon(
                                imageVector = if(expandedIndex == index) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                                contentDescription = "Expanded/Collapse",
                                modifier = Modifier
                                    .clickable {
                                        expandedIndex = if (expandedIndex == index) -1 else index
                                    }
                            )
                        }

                        if (expandedIndex == index){
                            Text(
                                text = description,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}