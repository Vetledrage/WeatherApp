package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp


/**
 * Composable function used mainly for showing fun facts (More information to be added)
 * @param text The text to show
 */
@Composable
fun CustomBox(
    modifier: Modifier = Modifier,
    backgroundImage: Painter,
    text: String,
    textSize: TextUnit = 20.sp, // Adjusted text size
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .size(100.dp)
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .graphicsLayer(alpha = 0.5f), // Adjust the alpha value as needed
            contentScale = ContentScale.Crop
        )

        // Add background to the text
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = text,
                style = TextStyle(
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontSize = textSize // Adjusted text size
                ),
                modifier = Modifier.background(Color.White.copy(alpha = 0.4f)), // Adjust background color and alpha
                textAlign = TextAlign.Center
            )
        }

    }
}