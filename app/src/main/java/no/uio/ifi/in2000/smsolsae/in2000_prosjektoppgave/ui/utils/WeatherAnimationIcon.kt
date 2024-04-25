package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R

@Composable
fun WeatherAnimation(weather: String) {
    val animationSpec = when(weather) {
        // Clear conditions
        "clearsky_day" -> R.raw.sunny
        "clearsky_night" -> R.raw.night_cloudy
        "clearsky_polartwilight" -> R.raw.night_cloudy

        // Cloudy conditions
        "cloudy" -> R.raw.cloudy
        "partlycloudy_day" -> R.raw.cloudy_sunny
        "partlycloudy_night" -> R.raw.night_cloudy
        "partlycloudy_polartwilight" -> R.raw.night_cloudy

        // Fair conditions
        "fair_day" -> R.raw.sunny
        "fair_night" -> R.raw.night_cloudy
        "fair_polartwilight" -> R.raw.night_cloudy

        // Foggy conditions
        "fog" -> R.raw.fog

        // Rain conditions
        "heavyrain" -> R.raw.thunder_rain
        "lightrain" -> R.raw.sunny_rain_anim
        "rain" -> R.raw.rainy_anim
        "heavyrainshowers_night" -> R.raw.night_rain
        "heavyrainshowers_polartwilight" -> R.raw.night_rain
        "lightrainshowers_night" -> R.raw.night_rain
        "lightrainshowers_polartwilight" -> R.raw.night_rain
        "rainshowers_night" -> R.raw.night_rain
        "rainshowers_polartwilight" -> R.raw.night_rain
        "heavyrainshowers_day" -> R.raw.sunny_rain_anim
        "heavyrainshowersandthunder_day" -> R.raw.thunder_rain
        "heavyrainshowersandthunder_night" -> R.raw.night_rain
        "heavyrainshowersandthunder_polartwilight" -> R.raw.night_rain
        "lightrainshowersandthunder_night" -> R.raw.night_rain
        "lightrainshowersandthunder_polartwilight" -> R.raw.night_rain
        "rainshowersandthunder_day" -> R.raw.thunder_rain
        "rainshowersandthunder_night" -> R.raw.night_rain
        "rainshowersandthunder_polartwilight" -> R.raw.night_rain

        // Sleet conditions
        "heavysleet" -> R.raw.sunny_rain_anim
        "lightsleet" -> R.raw.sunny_rain_anim
        "sleet" -> R.raw.sunny_rain_anim
        "heavysleetshowers_day" -> R.raw.sunny_rain_anim
        "heavysleetshowers_night" -> R.raw.night_rain
        "heavysleetshowers_polartwilight" -> R.raw.night_rain
        "lightsleetshowers_day" -> R.raw.sunny_rain_anim
        "lightsleetshowers_night" -> R.raw.night_rain
        "lightsleetshowers_polartwilight" -> R.raw.night_rain
        "sleetshowers_day" -> R.raw.sunny_rain_anim
        "sleetshowers_night" -> R.raw.night_rain
        "sleetshowers_polartwilight" -> R.raw.night_rain
        "heavysleetandthunder" -> R.raw.thunder
        "lightsleetandthunder" -> R.raw.thunder
        "sleetandthunder" -> R.raw.thunder
        "heavysleetshowersandthunder_day" -> R.raw.thunder
        "heavysleetshowersandthunder_night" -> R.raw.night_rain
        "heavysleetshowersandthunder_polartwilight" -> R.raw.night_rain
        "lightsleetshowersandthunder_day" -> R.raw.thunder
        "lightsleetshowersandthunder_night" -> R.raw.night_rain
        "lightsleetshowersandthunder_polartwilight" -> R.raw.night_rain

        // Snow conditions
        "heavysnow" -> R.raw.snow
        "lightsnow" -> R.raw.snow
        "snow" -> R.raw.snow
        "heavysnowandthunder" -> R.raw.thunder
        "lightsnowandthunder" -> R.raw.thunder
        "snowandthunder" -> R.raw.thunder
        "heavysnowshowers_day" -> R.raw.snow
        "heavysnowshowers_night" -> R.raw.night_snow
        "heavysnowshowers_polartwilight" -> R.raw.night_snow
        "lightsnowshowers_day" -> R.raw.snow
        "lightsnowshowers_night" -> R.raw.night_snow
        "lightsnowshowers_polartwilight" -> R.raw.night_snow
        "snowshowers_day" -> R.raw.snow
        "snowshowers_night" -> R.raw.night_snow
        "snowshowers_polartwilight" -> R.raw.night_snow
        "heavysnowshowersandthunder_day" -> R.raw.thunder
        "heavysnowshowersandthunder_night" -> R.raw.night_snow
        "heavysnowshowersandthunder_polartwilight" -> R.raw.night_snow
        "lightsnowshowersandthunder_day" -> R.raw.thunder
        "lightsnowshowersandthunder_night" -> R.raw.night_snow
        "lightsnowshowersandthunder_polartwilight" -> R.raw.night_snow

        // Thunder conditions
        "heavyrainandthunder" -> R.raw.thunder_rain
        "lightrainandthunder" -> R.raw.thunder_rain
        // Sunny rain conditions
        "rainshowers_day" -> R.raw.sunny_rain_anim
        // Night Rain
        "heavyrain_night" -> R.raw.night_rain
        "lightrain_night" -> R.raw.night_rain
        "rain_night" -> R.raw.night_rain
        // Night Cloudy
        "cloudy_night" -> R.raw.night_cloudy
        else -> R.raw.cloudy
    }
    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(
            resId = animationSpec
        )
    )
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier.height(120.dp).padding(16.dp)
    )
}