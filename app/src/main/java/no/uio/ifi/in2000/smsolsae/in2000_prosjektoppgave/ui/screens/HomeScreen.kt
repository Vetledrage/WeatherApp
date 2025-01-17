package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import android.content.Context
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.Screen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.BottomBar
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.CustomBox
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.ErrorScreen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.LoadingAnimation
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.SearchLocationDialog
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AppUiState
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.TemperatureNext12Hours
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.WeatherAnimation
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.getBearImageResource
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.getLiveDateTime
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.getWeatherIcon
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.pickBear
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.weatherCodeBetterNames
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel


/**
 *
 * Function for the homescreen
 * @param navController for standard navigation
 * @param viewModel Weather view model that displayed data depends on.
 *
 */
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: WeatherViewModel = viewModel(),
    context: Context
) {
    val weatherData by viewModel.appUiState.collectAsState()
    var showSearchBox by remember { mutableStateOf(false) }
    val locationName by viewModel.locationName.collectAsState()
    val scrollState = rememberScrollState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                when (weatherData) {
                    is AppUiState.Error -> {
                        ErrorScreen(errorMsg = "Something bad happend here!", onRetry = {viewModel.updateWeatherInfo("59.11", "10.112")})
                    }

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

                        //choose beartype background
                        val bearType = pickBear(data.temperature, data.humidity, data.weatherCode)
                        val bearImageId = getBearImageResource(bearType)

                        val betterFormatNameWeatherCode = weatherCodeBetterNames(weatherName = data.weatherCode)
                        Scaffold(
                            bottomBar = {
                                BottomBar(navController)
                            },

                        ) { innerPadding ->

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(innerPadding)
                                    .verticalScroll(state = scrollState),
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                        .height(550.dp),
                                    contentAlignment = Alignment.TopCenter
                                ) {
                                    Image(
                                        painter = painterResource(id = bearImageId),
                                        contentDescription = "Dynamic bear imagebackground based on weather conditions",
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
                                                text = locationName,
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        }

                                        fun onSearch(query: String){
                                            val loc = query.replaceFirstChar { it.uppercase() }

                                            if (errorMessage == null){
                                                viewModel.getCoordinates(city = loc)
                                                if (query.split(",")[0].isEmpty()){
                                                    viewModel.setLocationName(loc.split(",")[1])
                                                }else{
                                                    viewModel.setLocationName(loc.split(",")[0])
                                                }
                                                showSearchBox = false
                                            }
                                        }

                                        if(showSearchBox){
                                            SearchLocationDialog(
                                                onDismiss = { showSearchBox = false },
                                                onSearch = {query ->
                                                    onSearch(query)
                                                },
                                                viewModel = viewModel,
                                                context = context,
                                            )
                                        }

                                        if(errorMessage != null){
                                            viewModel.setLocationName("Oslo")
                                            Dialog(onDismissRequest = { viewModel.setErrorMesageNull() }) {
                                                Surface(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    color = Color.White,
                                                    shape = RoundedCornerShape(8.dp)
                                                ) {
                                                    Column(
                                                        modifier = Modifier.padding(16.dp)
                                                    ) {
                                                        Text(
                                                            text = errorMessage!! + "\nPlease Try Again!",
                                                            textAlign = TextAlign.Center,
                                                            style = TextStyle(color = Color.Red),
                                                            modifier = Modifier.fillMaxWidth()
                                                        )
                                                        Spacer(modifier = Modifier.height(16.dp))

                                                        Button(
                                                            onClick = {
                                                                viewModel.setErrorMesageNull()
                                                                showSearchBox = true },
                                                            modifier = Modifier.align(Alignment.CenterHorizontally)
                                                        ) {
                                                            Text(text = "Try Again")
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        Text(
                                            text = getLiveDateTime(),
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.SemiBold
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
                                        Text( //BetterFormatNameWeatherCode Removes the underscores and makes it better formated
                                            text = betterFormatNameWeatherCode,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Light
                                        )

                                        Spacer(
                                            modifier = Modifier.height(30.dp)
                                        )
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = 10.dp)
                                                .offset(y = (250).dp),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {//icons changed -
                                            WeatherInfo(R.drawable.ic_sunny, "${data.uvIndex}")
                                            WeatherInfo(R.drawable.raindrop, "${data.humidity}%")
                                            WeatherInfo(R.drawable.windy, "${data.windSpeed}m/s")
                                        }

                                        Column(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .offset(y = (-260).dp),
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Row(
                                                modifier = Modifier.size(150.dp).offset(y = (-20).dp)
                                            ){
                                                WeatherAnimation(weather = data.weatherCode)
                                            }
                                        }
                                    }
                                }

                                val annotedstring = buildAnnotatedString {
                                    val text = "Next 7 days"
                                    append(text)
                                }
                                Column(
                                    modifier = Modifier
                                        .padding(horizontal = 16.dp)
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

                                    WeatherScrollableRow(context, hourlyWeatherData = hourlyWeatherData)

                                    Spacer(modifier = Modifier.height(2.dp))

                                    CustomBox(
                                        context = context
                                    )

                                }
                            }
                        }
                    }


                }
            }
        }

    }


@Composable
fun WeatherItem(context: Context, weather: TemperatureNext12Hours){
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
            painter = painterResource(id = getWeatherIcon(context, weather.iconId)),
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
fun WeatherScrollableRow(context: Context, hourlyWeatherData: List<TemperatureNext12Hours>){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F7F7), shape = RoundedCornerShape(8.dp)),
    ){
        items(hourlyWeatherData) { weather ->
            WeatherItem(context, weather)
        }
    }
}

@Composable
fun WeatherInfo(icon : Int, value: String) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = icon), contentDescription = value, modifier = Modifier.size(28.dp))
        Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
}



