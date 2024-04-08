package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.Screen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.BottomBar
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.LoadingAnimation
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.SearchLocationDialog
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AppUiState
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.TemperatureNext12Hours
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.DisplayImage
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.getLiveDateTime
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.getWeatherIcon
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.pickBear
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel



@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: WeatherViewModel = viewModel()
) {
    val weatherData by viewModel.appUiState.collectAsState()
    var showSearchBox by remember { mutableStateOf(false) }
    var location by remember { mutableStateOf("Oslo") } //Default er satt til Oslo (Dummy data til nå)

    Surface(modifier = Modifier.fillMaxSize()) {
        when (weatherData) {
            is AppUiState.Loading -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    LoadingAnimation(text = "Loading Data...")
                }
            }
            is AppUiState.Success -> {
                val data = (weatherData as AppUiState.Success).weather

                Scaffold(
                    bottomBar = {
                        BottomBar(navController)
                    }
                ) { innerPadding ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .weight(0.7f),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_weather_background),
                                contentDescription = "background",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(shape = RoundedCornerShape(5)),
                                contentScale = ContentScale.Crop,
                            )

                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .padding(15.dp)
                                    .fillMaxWidth()
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .clickable { showSearchBox = true }
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.location_dot),
                                        contentDescription = "location",
                                        modifier = Modifier
                                            .padding(horizontal = 2.dp)
                                            .size(16.dp)
                                    )
                                    Text(
                                        text = location,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }

                                if(showSearchBox){
                                    SearchLocationDialog(
                                        onDismiss = { showSearchBox = false },
                                        onSearch = {query ->
                                            location = query.replaceFirstChar { it.uppercase() }
                                            showSearchBox = false
                                        }
                                    )
                                }

                                Text(
                                    text = getLiveDateTime(),
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Light
                                )
                            }

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Spacer(modifier = Modifier.height(60.dp))

                                Text(
                                    text = "${data.temperature}°",
                                    fontSize = 70.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = data.weatherCode,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Light
                                )

                                Spacer(
                                    modifier = Modifier.height(30.dp)
                                )

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    WeatherInfo(R.drawable.ic_sunny, "${data.uvIndex}")
                                    WeatherInfo(R.drawable.ic_drop, "${data.humidity}%")
                                    WeatherInfo(R.drawable.ic_wind, "${data.windSpeed}m/s")
                                }

                                Spacer(modifier = Modifier.height(50.dp))
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Button(
                                        onClick = { navController.navigate(Screen.Alerts.route)}
                                    ) {
                                        Text(text = "See weather warnings")
                                        Icon(
                                            painter = painterResource(id = R.drawable.triangle_exclamation_solid),
                                            contentDescription = "Warining",
                                            modifier = Modifier
                                                .size(20.dp)
                                        )
                                    }
                                    
                                    Spacer(modifier = Modifier.height(20.dp))
                                    
                                    Row{
                                        DisplayImage(bear = pickBear(data.temperature))
                                    }
                                    

                                }
                            }
                        }

                        val annotedstring = buildAnnotatedString {
                            val text = "Next 7 days"
                            append(text)
                        }
                        //Nedre delen av skjermen. Tar 40% av skjermen.
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .weight(0.3f)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "Today",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight(600)
                                )

                                ClickableText(
                                    text = annotedstring,
                                    style = TextStyle(
                                        fontWeight = FontWeight(400),
                                        fontSize = 15.sp,
                                        color = Color.Blue
                                    ),
                                    modifier = Modifier
                                        .drawBehind {
                                            val strokeWidth = 1.dp.toPx()
                                            val y = size.height - strokeWidth / 2
                                            drawLine(
                                                color = Color.Blue,
                                                start = Offset(0f, y),
                                                end = Offset(size.width, y),
                                                strokeWidth = strokeWidth
                                            )
                                        },
                                    onClick = {
                                        navController.navigate(Screen.Weather.route)
                                    }
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))

                            val hourlyWeatherData = data.tempNext12hrs

                            WeatherScrollableRow(hourlyWeatherData = hourlyWeatherData)
                        }
                    }
                }
            }

            is AppUiState.Error -> {
                Text(text = "Error in getting data")
            }
        }

    }
}

@Composable
fun WeatherItem(weather: TemperatureNext12Hours){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(80.dp)
            .padding(vertical = 5.dp)

    ) {
        Text(
            text = weather.time,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light
        )
        Image(
            painter = painterResource(id = getWeatherIcon(weather.iconId)),
            contentDescription = "icon",
            modifier = Modifier.size(35.dp)
        )
        Text(
            text = "${weather.temp}°",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun WeatherScrollableRow(hourlyWeatherData: List<TemperatureNext12Hours>){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F7F7), shape = RoundedCornerShape(8.dp)),
    ){
        items(hourlyWeatherData) { weather ->
            WeatherItem(weather)
        }
    }
}

@Composable
fun WeatherInfo(icon : Int, value: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = icon), contentDescription = value, modifier = Modifier.size(18.dp))
        Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Normal)
    }
}


@Preview(showSystemUi = true)
@Composable
fun ShowHomeScreen(){
    HomeScreen(navController = rememberNavController(), viewModel = WeatherViewModel())
}
