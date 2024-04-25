package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R

/**
 * Function for returning a string with bear-type based on temperature, humidity, and weather tags.
 *
 * @param temperature representation of the temperature
 * @param humidity representation of relative air humidity
 * @param weatherCode represantation of weather which is translated to sunny, cloudy, rainy, or other
 * @return one of eight bear types (polar, brown, panda, am-black, as-black, spectacled, sun, sloth)
 */
fun pickBear(temperature: Int = 15, humidity: Int = 70, weatherCode: String = "sunny", error: Boolean = false) : String{
    val weatherType = weatherType(weatherCode)
    return if (error) "redPanda"
    else if (temperature < -5) "polarBear"
    else if (temperature < 15)
        if (weatherType == "rainy") "brownBear"
        else if (humidity >= 70 && temperature >= 10) "pandaBear"
        else if (weatherType == "cloudy" && temperature >= 5) "spectacledBear"
        else "americanBlackBear"
    else if (temperature < 30)
        if (weatherType == "rainy") "asianBlackBear"
        else if (humidity >= 70 && temperature < 20) "pandaBear"
        else if (humidity >= 70 && temperature >= 25) "slothBear"
        else if (weatherType == "sunny" && temperature >= 20) "sunBear"
        else if (weatherType == "cloudy" && temperature < 25) "spectacledBear"
        else "americanBlackBear"
    else "slothBear" //temp >= 30
}

/**
 * Helper function for returning a string with weather type based on weather tags.
 *
 * @param weatherCode represantation of weather
 * @return one of four weather types as String (sunny, cloudy, rainy, or other)
 */
fun weatherType(weatherCode: String): String{
    return if (weatherCode == "clearsky_day" || weatherCode == "fair_day") "sunny"
    else if (weatherCode == "cloudy" || weatherCode == "fog") "cloudy"
    else if (weatherCode.startsWith("rain") || weatherCode.startsWith("sleet") || weatherCode.startsWith("snow")
        || weatherCode.startsWith("light") || weatherCode.startsWith("heavy")
        ) "rainy"
    else "other"
  }

/**
 * Composable function for displaying the bear image.
 * @param bear The string representing the bear to be displayed.
 */
@Composable //mange endringer på format,
fun getBearImageResource(bear: String): Int {
    return when(bear) {
        "polarBear" -> R.drawable.polarbear_snow
        "americanBlackBear" -> R.drawable.americanblackbear_cloudy
        "asianBlackBear" -> R.drawable.asianblackbear_rainy1
        "brownBear" -> R.drawable.brownbear_raincloudy
        "pandaBear" -> R.drawable.panda_humidsun
        "spectacledBear" -> R.drawable.foggy_spectablebear
        "sunBear" -> R.drawable.sunbear_sunnyday2
        "slothBear" -> R.drawable.slothbear_verysunny
        else -> R.drawable.red_panda // Default case if no valid bear is provided
    }
}

//Preview - change inputs to change preview
@Preview(showSystemUi = true)
@Composable
fun PreviewBearImage(){
    getBearImageResource(bear = pickBear(temperature = 14, humidity = 70, weatherCode = "sunny")) //tags: "sunny", "cloudy", "rainy"
}
