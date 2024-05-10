package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components.BottomBar
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.theme.IN2000ProsjektoppgaveTheme
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.viewModel.WeatherViewModel

/**
 * The MainActivity class is the entrypoint of the app. The main()-method. (More information to be added)
 */
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        if (isNetworkConnected()){
            performGetData()
        }
        super.onCreate(savedInstanceState)
        setContent {
            IN2000ProsjektoppgaveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {BottomBar(navController = navController)}
                    ) {
                        if (isNetworkConnected()){
                            RootNavHost(navController = navController, context = this)
                        }else{
                            showNetworkErrorDialog()
                        }
                    }
                }
            }

        }

    }

    //To handle if the network is not connected.
    private fun isNetworkConnected(): Boolean{
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val network = connectivityManager.activeNetwork ?: return false
        val capabilities =
            connectivityManager.getNetworkCapabilities(network) ?: return false

        return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
    }

    private fun showNetworkErrorDialog() {
        AlertDialog.Builder(this)
            .setTitle("Network Error")
            .setMessage("Please check your internet connection and try again.")
            .setPositiveButton("OK") { _, _ ->
                if (!isNetworkConnected()) {
                    showNetworkErrorDialog()
                } else {
                    performGetData()
                }
            }
            .show()
    }

    private fun performGetData(){
        val weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]

        if (weatherViewModel.hasLocationPermission(this)){
            weatherViewModel.getCurrentLocation(this)
        }else{
            weatherViewModel.getWeatherInfo("59.9139", "10.7522")
        }
    }
}

