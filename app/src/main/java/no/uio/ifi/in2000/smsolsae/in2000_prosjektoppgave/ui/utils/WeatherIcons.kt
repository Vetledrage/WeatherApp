package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.R

fun getWeatherIcon(symbol_code: String?): Int {
    return when (symbol_code) {
        "clearsky", "fair", "partlycloudy" -> R.drawable.ic_sunny
        "cloudy" -> R.drawable.ic_cloudy
        "fog" -> R.drawable.ic_cloudy
        "heavyrain", "heavyrainandthunder", "heavyrainshowers", "heavyrainshowersandthunder" -> R.drawable.ic_rainy
        "heavysleet", "heavysleetandthunder", "heavysleetshowers", "heavysleetshowersandthunder" -> R.drawable.ic_thunder
        "heavysnow", "heavysnowandthunder", "heavysnowshowers", "heavysnowshowersandthunder" -> R.drawable.ic_snowy
        "lightrain", "lightrainandthunder", "lightrainshowers", "lightrainshowersandthunder" -> R.drawable.ic_rainshower
        "lightsleet", "lightsleetandthunder", "lightsleetshowers" -> R.drawable.ic_rainshower
        "lightsnow", "lightsnowandthunder", "lightsnowshowers", "lightssleetshowersandthunder", "lightssnowshowersandthunder" -> R.drawable.ic_snowy
        "rain", "rainandthunder", "rainshowers", "rainshowersandthunder" -> R.drawable.ic_rainy
        "sleet", "sleetandthunder", "sleetshowers", "sleetshowersandthunder" -> R.drawable.ic_thunder
        "snow", "snowandthunder", "snowshowers", "snowshowersandthunder" -> R.drawable.ic_snowy
        else -> R.drawable.ic_sunny
    }
}

