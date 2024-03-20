package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.LoadingAnimation
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.AppUiState
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.TemperatureNext12Hours
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WeatherFromApiScreen(navController: NavController, viewModel: WeatherViewModel = viewModel()){
    viewModel.getWeatherInfo("59", "10")
    val weatherData by viewModel.appUiState.collectAsState()


    Scaffold {
        Column {
            when(weatherData){
                is AppUiState.Loading -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        LoadingAnimation(text = "Loading Weather data")
                    }
                }
                is AppUiState.Success -> {
                    val a = (weatherData as AppUiState.Success).weather //Kaller den sånn så får man aksessere dataen vi trenger
                    val timeList = (weatherData as AppUiState.Success).weather.tempNext12hrs
                    Text(text = "Success")
                    Text(text = "${a}")
                    WeatherScrollableRow1(hourlyWeatherData = timeList)
                }
                is AppUiState.Error ->{
                    Text(text = "Error")
                }
            }

        }
    }
}

@Composable
fun WeatherScrollableRow1(hourlyWeatherData: List<TemperatureNext12Hours>){
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
            painter = painterResource(id = R.drawable.ic_sunny),
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