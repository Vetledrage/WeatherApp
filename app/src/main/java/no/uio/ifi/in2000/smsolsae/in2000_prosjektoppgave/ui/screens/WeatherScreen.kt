package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.weatherData.HourlyWeather
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.weatherData.WeeklyWeather



//Skjerm som skal vise været de neste 7 dagene.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(navController: NavController){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        text = "Oslo",
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
    ) {innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Today",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))

            val hourlyWeatherData = listOf(
                HourlyWeather("00 PM", 24, R.drawable.ic_sunny),
                HourlyWeather("01 PM", 26, R.drawable.ic_sunny),
                HourlyWeather("02 PM", 27, R.drawable.ic_sunny),
                HourlyWeather("03 PM", 25, R.drawable.ic_sunnycloudy),
                HourlyWeather("04 PM", 24, R.drawable.ic_cloudy),
                HourlyWeather("05 PM", 24, R.drawable.ic_cloudy),
                HourlyWeather("06 PM", 24, R.drawable.ic_cloudy),
                HourlyWeather("07 PM", 24, R.drawable.ic_cloudy),
                HourlyWeather("08 PM", 24, R.drawable.ic_sunny),
            )

            TodaysWeatherRow(hourlyWeatherData = hourlyWeatherData)

            Spacer(modifier = Modifier.height(20.dp))
            val weeklyWeather = listOf(
                WeeklyWeather("Tomorow", "17.08", 16, R.drawable.ic_sunnycloudy),
                WeeklyWeather("Tuesday", "18.08", 18, R.drawable.ic_sunnycloudy),
                WeeklyWeather("Wednsday", "19.08", 12, R.drawable.ic_sunnyrainy),
                WeeklyWeather("Thursday", "20.08", -2, R.drawable.ic_heavysnow),
                WeeklyWeather("Friday", "21.08", 8, R.drawable.ic_rainythunder),
                WeeklyWeather("Saturday", "22.08", 24, R.drawable.ic_sunny),
                WeeklyWeather("Sunday", "23.08", 16, R.drawable.ic_cloudy),

                // Fortsett med resten av uken
            )
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                WeatherNextWeek(weeklyWeatherData = weeklyWeather)
            }
        }
    }
}


@Composable
fun TodaysWeatherRow(hourlyWeatherData: List<HourlyWeather>){
    var selectedIndex by remember { mutableIntStateOf(0) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ){
        itemsIndexed(hourlyWeatherData) {index, weather ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(80.dp)
                    .height(120.dp)
                    .clip(RoundedCornerShape(20))
                    .clickable(onClick = { selectedIndex = index })
                    .background(
                        if (index == selectedIndex) Color.Blue else Color.Transparent
                    )
                    .padding(8.dp),
            ) {
                Card(
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,

                        ) {
                        Text(
                            text = weather.time,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400,

                            )
                        Image(
                            painter = painterResource(id = weather.weatherIconId),
                            contentDescription = "icon",
                            modifier = Modifier
                                .padding(10.dp)
                                .size(35.dp)
                        )
                        Text(
                            text = "${weather.temperature}°",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun WeatherNextWeek(weeklyWeatherData: List<WeeklyWeather>){
    LazyColumn{
        items(weeklyWeatherData){weather ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(0.5f)
                ) {
                    Text(
                        text = weather.weekDay,
                        fontSize = 15.sp,
                        fontWeight = FontWeight(700)
                    )

                    Text(
                        text = weather.date,
                        fontWeight = FontWeight(300)
                    )
                }

                Row(
                    modifier = Modifier.weight(0.5f)
                ) {
                    Text(
                        text = "${weather.temperature}°",
                        fontSize = 24.sp,
                        fontWeight = FontWeight(600)
                    )
                }
                Image(
                    painter = painterResource(id = weather.weatherIconId),
                    contentDescription = "weather icon",
                    modifier = Modifier.size(38.dp)
                )
            }

        }
    }
}


@Preview
@Composable
fun WeatherScreenPreview(){
    WeatherScreen(navController = rememberNavController())
}