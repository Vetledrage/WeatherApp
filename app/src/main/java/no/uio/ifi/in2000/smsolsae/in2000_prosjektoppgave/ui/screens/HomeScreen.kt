package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.Screen
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.timeData.getLiveDateTime
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.uiStates.HourlyWeather
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.BottomBar
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel


//Hjemskjermen hittil.
@Composable
fun HomeScreen(navController: NavController, viewModel: WeatherViewModel){
    val hourlyWeatherData by viewModel.hourlyWeather.collectAsState()

    val todaystemp = "14"

    Surface(modifier = Modifier.fillMaxSize()) {
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
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.location_dot),
                                contentDescription = "location",
                                modifier = Modifier
                                    .padding(horizontal = 2.dp)
                                    .size(16.dp)
                            )
                            Text(
                                text = "Oslo",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
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
                            text = "$todaystemp°",
                            fontSize = 70.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Mostly Clear",
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
                            WeatherInfo(R.drawable.ic_sunny, "4 uv")
                            WeatherInfo(R.drawable.ic_drop, "58%")
                            WeatherInfo(R.drawable.ic_wind, "22km/h")
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




                    WeatherScrollableRow(hourlyWeatherData = hourlyWeatherData)
                }
            }
        }
    }
}

//Dummy data class

@Composable
fun WeatherItem(weather: HourlyWeather){
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
            painter = painterResource(id = weather.weatherIconId),
            contentDescription = "icon",
            modifier = Modifier.size(35.dp)
        )
        Text(
            text = "${weather.temperature}°",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun WeatherScrollableRow(hourlyWeatherData: List<HourlyWeather>){
    LazyRow(
        contentPadding = PaddingValues(horizontal = 5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F7F7), shape = RoundedCornerShape(8.dp)),
    ){
        items(hourlyWeatherData) { weather ->
            WeatherItem(weather = weather)
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
