package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.utils



import androidx.compose.runtime.Composable




@Composable
fun weatherCodeBetterNames(weatherName: String): String {
    val weatherNameMap = mapOf(
        // Clear conditions
        "clearsky_day" to "Clear Sky Day",
        "clearsky_night" to "Clear Sky Night",
        "clearsky_polartwilight" to "Clear Sky Polar Twilight",

        // Cloudy conditions
        "cloudy" to "Cloudy",
        "partlycloudy_day" to "Partly Cloudy Day",
        "partlycloudy_night" to "Partly Cloudy Night",
        "partlycloudy_polartwilight" to "Partly Cloudy Polar Twilight",

        // Fair conditions
        "fair_day" to "Fair Day",
        "fair_night" to "Fair Night",
        "fair_polartwilight" to "Fair Polar Twilight",

        // Foggy conditions
        "fog" to "Fog",

        // Rain conditions
        "heavyrain" to "Heavy Rain",
        "lightrain" to "Light Rain",
        "rain" to "Rain",
        "heavyrainshowers_night" to "Heavy Rain Showers Night",
        "heavyrainshowers_polartwilight" to "Heavy Rain Showers Polar Twilight",
        "lightrainshowers_night" to "Light Rain Showers Night",
        "lightrainshowers_polartwilight" to "Light Rain Showers Polar Twilight",
        "rainshowers_night" to "Rain Showers Night",
        "rainshowers_polartwilight" to "Rain Showers Polar Twilight",
        "heavyrainshowers_day" to "Heavy Rain Showers Day",
        "heavyrainshowersandthunder_day" to "Heavy Rain Showers And Thunder Day",
        "heavyrainshowersandthunder_night" to "Heavy Rain Showers And Thunder Night",
        "heavyrainshowersandthunder_polartwilight" to "Heavy Rain Showers And Thunder Polar Twilight",
        "lightrainshowersandthunder_night" to "Light Rain Showers And Thunder Night",
        "lightrainshowersandthunder_polartwilight" to "Light Rain Showers And Thunder Polar Twilight",
        "rainshowersandthunder_day" to "Rain Showers And Thunder Day",
        "rainshowersandthunder_night" to "Rain Showers And Thunder Night",
        "rainshowersandthunder_polartwilight" to "Rain Showers And Thunder Polar Twilight",

        // Sleet conditions
        "heavysleet" to "Heavy Sleet",
        "lightsleet" to "Light Sleet",
        "sleet" to "Sleet",
        "heavysleetshowers_day" to "Heavy Sleet Showers Day",
        "heavysleetshowers_night" to "Heavy Sleet Showers Night",
        "heavysleetshowers_polartwilight" to "Heavy Sleet Showers Polar Twilight",
        "lightsleetshowers_day" to "Light Sleet Showers Day",
        "lightsleetshowers_night" to "Light Sleet Showers Night",
        "lightsleetshowers_polartwilight" to "Light Sleet Showers Polar Twilight",
        "sleetshowers_day" to "Sleet Showers Day",
        "sleetshowers_night" to "Sleet Showers Night",
        "sleetshowers_polartwilight" to "Sleet Showers Polar Twilight",
        "heavysleetandthunder" to "Heavy Sleet And Thunder",
        "lightsleetandthunder" to "Light Sleet And Thunder",
        "sleetandthunder" to "Sleet And Thunder",
        "heavysleetshowersandthunder_day" to "Heavy Sleet Showers And Thunder Day",
        "heavysleetshowersandthunder_night" to "Heavy Sleet Showers And Thunder Night",
        "heavysleetshowersandthunder_polartwilight" to "Heavy Sleet Showers And Thunder Polar Twilight",
        "lightsleetshowersandthunder_day" to "Light Sleet Showers And Thunder Day",
        "lightsleetshowersandthunder_night" to "Light Sleet Showers And Thunder Night",
        "lightsleetshowersandthunder_polartwilight" to "Light Sleet Showers And Thunder Polar Twilight",

        // Snow conditions
        "heavysnow" to "Heavy Snow",
        "lightsnow" to "Light Snow",
        "snow" to "Snow",
        "heavysnowandthunder" to "Heavy Snow And Thunder",
        "lightsnowandthunder" to "Light Snow And Thunder",
        "snowandthunder" to "Snow And Thunder",
        "heavysnowshowers_day" to "Heavy Snow Showers Day",
        "heavysnowshowers_night" to "Heavy Snow Showers Night",
        "heavysnowshowers_polartwilight" to "Heavy Snow Showers Polar Twilight",
        "lightsnowshowers_day" to "Light Snow Showers Day",
        "lightsnowshowers_night" to "Light Snow Showers Night",
        "lightsnowshowers_polartwilight" to "Light Snow Showers Polar Twilight",
        "snowshowers_day" to "Snow Showers Day",
        "snowshowers_night" to "Snow Showers Night",
        "snowshowers_polartwilight" to "Snow Showers Polar Twilight",
        "heavysnowshowersandthunder_day" to "Heavy Snow Showers And Thunder Day",
        "heavysnowshowersandthunder_night" to "Heavy Snow Showers And Thunder Night",
        "heavysnowshowersandthunder_polartwilight" to "Heavy Snow Showers And Thunder Polar Twilight",
        "lightsnowshowersandthunder_day" to "Light Snow Showers And Thunder Day",
        "lightsnowshowersandthunder_night" to "Light Snow Showers And Thunder Night",
        "lightsnowshowersandthunder_polartwilight" to "Light Snow Showers And Thunder Polar Twilight",

        // Thunder conditions
        "heavyrainandthunder" to "Heavy Rain And Thunder",
        "lightrainandthunder" to "Light Rain And Thunder",
        "heavysleetandthunder" to "Heavy Sleet And Thunder",
        "lightsleetandthunder" to "Light Sleet And Thunder",
        "heavysnowandthunder" to "Heavy Snow And Thunder",
        "lightsnowandthunder" to "Light Snow And Thunder",
        "snowandthunder" to "Snow And Thunder",
        "rainandthunder" to "Rain And Thunder",
        "sleetandthunder" to "Sleet And Thunder",

        // Sunny rain conditions
        "rainshowers_day" to "Rain Showers Day",
        "heavyrainshowers_day" to "Heavy Rain Showers Day",
        "lightrainshowers_day" to "Light Rain Showers Day",

        // Night Rain
        "heavyrain_night" to "Heavy Rain Night",
        "lightrain_night" to "Light Rain Night",
        "rain_night" to "Rain Night",

        // Night Cloudy
        "cloudy_night" to "Cloudy Night"
    )
    return weatherNameMap[weatherName] ?: "Unknown Weather Condition"}








