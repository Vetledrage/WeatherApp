package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens.FrontPage
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.screens.ShowSun
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.theme.IN2000ProsjektoppgaveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IN2000ProsjektoppgaveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FrontPage()
                }
            }
        }
    }
}

