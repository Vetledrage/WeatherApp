package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
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
 * The MainActivity class is the entrypoint of the app. Akin to the main()-method in Java.
 */
class MainActivity : ComponentActivity() {

    private var networkCallback: ConnectivityManager.NetworkCallback? = null
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

                            RootNavHost(navController = navController, context = this)
                        if(!isNetworkConnected()){
                            showNetworkErrorDialog()
                        }
                    }
                }
            }
        }
        registerNetworkCallback()

    }

    //To handle if the network is not connected.
    /**
     * Function to handle if network is not connected
     * @return
     */
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

    private fun registerNetworkCallback() {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                performGetData()
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                showNetworkErrorDialog()
            }
        }
        connectivityManager.registerDefaultNetworkCallback(networkCallback as ConnectivityManager.NetworkCallback)
    }

    /**
     * Function to display network error dialog
     */
    private fun showNetworkErrorDialog() {
        AlertDialog.Builder(this)
            .setTitle("Network Error")
            .setMessage("Please connect to internet and try again!")
            .setPositiveButton("OK") { _, _ ->
                if (!isNetworkConnected()) {
                    showNetworkErrorDialog()
                } else {
                    performGetData()
                }
            }
            .show()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterNetworkCallback()
    }

    private fun unregisterNetworkCallback() {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        networkCallback?.let {
            connectivityManager.unregisterNetworkCallback(it)
        }
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

