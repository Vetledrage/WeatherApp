package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchLocationDialog(onDismiss : () -> Unit, onSearch: (String) -> Unit){
    var searchText by remember { mutableStateOf("") }
    val filteredCities = remember(searchText){
        citites.filter { it.lowercase().startsWith(searchText.lowercase()) }
    }
    val keyboardController = LocalSoftwareKeyboardController.current

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
                        Divider()
                    }
                }
            }
        }
    }
}