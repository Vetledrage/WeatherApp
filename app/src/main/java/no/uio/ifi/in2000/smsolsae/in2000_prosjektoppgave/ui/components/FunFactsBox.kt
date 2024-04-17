package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils.DailyFactManager


/**
 * Composable function used mainly for showing fun facts (More information to be added)
 * @param context The context of the app.
 */
@Composable
fun CustomBox(context: Context) {
    val dailyFactManager = DailyFactManager(context)
    val fact = dailyFactManager.getDailyFact()
    
    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(400.dp, 100.dp)
                .clip(shape = RoundedCornerShape(15.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp, 170.dp)
                        .background(Color.White)
                    //.clip(RoundedCornerShape(15.dp)) //I think it looks better without clip.
                ) {
                    // Content for the side picture
                    Image(
                        painter = painterResource(id = R.drawable.panda_bear),
                        contentDescription = "bear",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                Box(
                    modifier = Modifier
                        .size(190.dp, 94.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .shadow(30.dp)
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp).fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Fact of the day",
                            textAlign = TextAlign.Center,
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = fact,
                            textAlign = TextAlign.Center,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}


