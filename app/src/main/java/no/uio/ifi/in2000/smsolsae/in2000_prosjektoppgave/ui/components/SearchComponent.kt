package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components

import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel


val citites = listOf(
    "Oslo, Norway",
    "Bergen, Norway",
    "Trondheim, Norway",
    "Stavanger, Norway",
    "Drammen, Norway",
    "Fredrikstad, Norway",
    "Kristiansand, Norway",
    "Sandnes, Norway",
    "Tromsø, Norway",
    "Sarpsborg, Norway",
    "Berlin, Germany",
    "Beijing, China",
    "Boston, USA",
    "Ottawa, Canada",
    "Paris, France",
    "Prague, Czech Republic",
    "Perth, Australia",
    "Porto, Portugal",
    "Pune, India",
    "Quito, Ecuador",
    "Quebec City, Canada",
    "Quanzhou, China",
    "Rome, Italy",
    "Rio de Janeiro, Brazil",
    "Riyadh, Saudi Arabia",
    "Reykjavik, Iceland",
    "Santiago, Chile",
    "Seoul, South Korea",
    "Stockholm, Sweden"
)

/**
 * Function for searching for a location. (More information to be added)
 *
 */

@Composable
fun SearchLocationDialog(
    viewModel: WeatherViewModel = viewModel(),
    onDismiss : () -> Unit,
    onSearch: (String) -> Unit,
    context: Context
){
    var searchText by remember { mutableStateOf("") }
    val filteredCities = remember(searchText){
        citites.filter { it.lowercase().contains(searchText.lowercase()) }
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    // Create a permission launcher for requesting current location
    val requestPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = { isGranted: Boolean ->
                if (isGranted) {
                    // Permission granted, update the location
                    viewModel.getCurrentLocation(context)
                }
            }
        )

    var showCitiesList by remember { mutableStateOf(true) }

    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }


    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            color = MaterialTheme.colorScheme.surface,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                if (showCitiesList){
                    Text(
                        text = "Search for location",
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    BasicTextField(
                        value = searchText,
                        onValueChange = {searchText = it},
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions (
                            onDone = {
                                keyboardController?.hide()
                            }
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray, RoundedCornerShape(4.dp))
                            .padding(8.dp)
                    )


                    LazyColumn(
                        modifier = Modifier.heightIn(max = 200.dp)
                    ) {
                        items(filteredCities) {city ->
                            val searchCity = city.split(",")[0]
                            TextButton(onClick = { onSearch(searchCity)}) {
                                Text(
                                    city,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                    }

                    HorizontalDivider(
                        color = Color.Black,
                        thickness = 0.5.dp,
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(onClick = { showCitiesList = !showCitiesList }) {
                            Text(text = "Search Address", fontSize = 14.sp)
                        }

                        TextButton(onClick = {
                            if (viewModel.hasLocationPermission(context)) {
                                viewModel.getCurrentLocation(context)
                                onDismiss()
                            } else {
                                requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
                            }
                        }) {
                            Text(text = "Use my location", fontSize = 14.sp)
                        }

                    }
                } else{
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Header(label = "Search by Address", icon = Icons.Default.Search)

                        Spacer(modifier = Modifier.height(20.dp))

                        TextField(
                            value = country,
                            onValueChange = { country = it },
                            label = { Text("Country", fontSize = 14.sp) },
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        TextField(
                            value = address,
                            onValueChange = { address = it },
                            label = { Text("Address", fontSize = 14.sp) },
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        TextField(
                            value = city,
                            onValueChange = { city = it },
                            label = { Text("City", fontSize = 14.sp) },
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Button(onClick = { showCitiesList = !showCitiesList}) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                    contentDescription = "arrow-back",
                                    modifier = Modifier.size(16.dp)
                                )

                                Text(text = "Go Back")
                            }

                            Button(
                                onClick = { onSearch("$address, $city, $country") }
                                ) {
                                Text(text = "Search")
                                Spacer(modifier = Modifier.width(5.dp))
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "arrow",
                                    modifier = Modifier.size(16.dp)
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}