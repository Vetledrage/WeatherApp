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


/**
 * This function gives a written summary of the forecast based on the weather code
 * @param weatherName The weather code
 * @return A map where the weather code is the key and the summary is the value
 */

@Composable
fun weatherCodeToSummary(weatherName: String) : String {
    val weatherNameMap = mapOf(
        // Clear conditions
        "clearsky_day" to "The weather today will be clear with sunshine.",
        "clearsky_night" to "The night sky will be clear.",
        "clearsky_polartwilight" to "Clear skies with polar twilight conditions.",

        // Cloudy conditions
        "cloudy" to "Expect cloudy skies today.",
        "partlycloudy_day" to "The weather today will be partly cloudy.",
        "partlycloudy_night" to "Tonight will be partly cloudy.",
        "partlycloudy_polartwilight" to "Partly cloudy with polar twilight conditions.",

        // Fair conditions
        "fair_day" to "The weather today will be fair and pleasant.",
        "fair_night" to "Tonight will be fair.",
        "fair_polartwilight" to "Fair weather with polar twilight conditions.",

        // Foggy conditions
        "fog" to "The weather today will be foggy.",

        // Rain conditions
        "heavyrain" to "Expect heavy rain today.",
        "lightrain" to "Light rain is expected today.",
        "rain" to "It will be rainy today.",
        "heavyrainshowers_night" to "Heavy rain showers are expected tonight.",
        "heavyrainshowers_polartwilight" to "Heavy rain showers with polar twilight conditions.",
        "lightrainshowers_night" to "Light rain showers expected tonight.",
        "lightrainshowers_polartwilight" to "Light rain showers with polar twilight conditions.",
        "rainshowers_night" to "Rain showers expected tonight.",
        "rainshowers_polartwilight" to "Rain showers with polar twilight conditions.",
        "heavyrainshowers_day" to "Expect heavy rain showers today.",
        "heavyrainshowersandthunder_day" to "Heavy rain showers and thunderstorms today.",
        "heavyrainshowersandthunder_night" to "Heavy rain showers and thunderstorms tonight.",
        "heavyrainshowersandthunder_polartwilight" to "Heavy rain showers and thunderstorms with polar twilight conditions.",
        "lightrainshowersandthunder_night" to "Light rain showers and thunderstorms expected tonight.",
        "lightrainshowersandthunder_polartwilight" to "Light rain showers and thunderstorms with polar twilight conditions.",
        "rainshowersandthunder_day" to "Rain showers and thunderstorms expected today.",
        "rainshowersandthunder_night" to "Rain showers and thunderstorms tonight.",
        "rainshowersandthunder_polartwilight" to "Rain showers and thunderstorms with polar twilight conditions.",

        // Sleet conditions
        "heavysleet" to "Expect heavy sleet today.",
        "lightsleet" to "Light sleet is expected today.",
        "sleet" to "Sleet is expected today.",
        "heavysleetshowers_day" to "Heavy sleet showers expected today.",
        "heavysleetshowers_night" to "Heavy sleet showers tonight.",
        "heavysleetshowers_polartwilight" to "Heavy sleet showers with polar twilight conditions.",
        "lightsleetshowers_day" to "Light sleet showers expected today.",
        "lightsleetshowers_night" to "Light sleet showers tonight.",
        "lightsleetshowers_polartwilight" to "Light sleet showers with polar twilight conditions.",
        "sleetshowers_day" to "Sleet showers expected today.",
        "sleetshowers_night" to "Sleet showers tonight.",
        "sleetshowers_polartwilight" to "Sleet showers with polar twilight conditions.",
        "heavysleetandthunder" to "Heavy sleet and thunder expected today.",
        "lightsleetandthunder" to "Light sleet and thunder expected today.",
        "sleetandthunder" to "Sleet and thunder expected today.",
        "heavysleetshowersandthunder_day" to "Heavy sleet showers and thunder expected today.",
        "heavysleetshowersandthunder_night" to "Heavy sleet showers and thunder tonight.",
        "heavysleetshowersandthunder_polartwilight" to "Heavy sleet showers and thunder with polar twilight conditions.",
        "lightsleetshowersandthunder_day" to "Light sleet showers and thunder expected today.",
        "lightsleetshowersandthunder_night" to "Light sleet showers and thunder tonight.",
        "lightsleetshowersandthunder_polartwilight" to "Light sleet showers and thunder with polar twilight conditions.",

        // Snow conditions
        "heavysnow" to "Expect heavy snowfall today.",
        "lightsnow" to "Light snowfall is expected today.",
        "snow" to "Snowfall is expected today.",
        "heavysnowandthunder" to "Heavy snow and thunderstorms expected today.",
        "lightsnowandthunder" to "Light snow and thunderstorms expected today.",
        "snowandthunder" to "Snow and thunderstorms expected today.",
        "heavysnowshowers_day" to "Heavy snow showers expected today.",
        "heavysnowshowers_night" to "Heavy snow showers tonight.",
        "heavysnowshowers_polartwilight" to "Heavy snow showers with polar twilight conditions.",
        "lightsnowshowers_day" to "Light snow showers expected today.",
        "lightsnowshowers_night" to "Light snow showers tonight.",
        "lightsnowshowers_polartwilight" to "Light snow showers with polar twilight conditions.",
        "snowshowers_day" to "Snow showers expected today.",
        "snowshowers_night" to "Snow showers tonight.",
        "snowshowers_polartwilight" to "Snow showers with polar twilight conditions.",
        "heavysnowshowersandthunder_day" to "Heavy snow showers and thunderstorms today.",
        "heavysnowshowersandthunder_night" to "Heavy snow showers and thunderstorms tonight.",
        "heavysnowshowersandthunder_polartwilight" to "Heavy snow showers and thunderstorms with polar twilight conditions.",
        "lightsnowshowersandthunder_day" to "Light snow showers and thunderstorms expected today.",
        "lightsnowshowersandthunder_night" to "Light snow showers and thunderstorms tonight.",
        "lightsnowshowersandthunder_polartwilight" to "Light snow showers and thunderstorms with polar twilight conditions.",

        // Thunder conditions
        "heavyrainandthunder" to "Expect heavy rain and thunderstorms today.",
        "lightrainandthunder" to "Light rain and thunderstorms expected today.",
        "heavysleetandthunder" to "Heavy sleet and thunderstorms today.",
        "lightsleetandthunder" to "Light sleet and thunderstorms expected today.",
        "heavysnowandthunder" to "Heavy snow and thunderstorms today.",
        "lightsnowandthunder" to "Light snow and thunderstorms expected today.",
        "snowandthunder" to "Snow and thunderstorms today.",
        "rainandthunder" to "Rain and thunderstorms today.",
        "sleetandthunder" to "Sleet and thunderstorms today.",

        // Sunny rain conditions
        "rainshowers_day" to "Expect rain showers today.",
        "heavyrainshowers_day" to "Expect heavy rain showers today.",
        "lightrainshowers_day" to "Expect light rain showers today.",

        // Night Rain
        "heavyrain_night" to "Expect heavy rain tonight.",
        "lightrain_night" to "Expect light rain tonight.",
        "rain_night" to "Expect rain tonight.",

        // Night Cloudy
        "cloudy_night" to "Expect cloudy skies tonight."
    )
    return weatherNameMap[weatherName] ?: "The weather today is not available."
}





