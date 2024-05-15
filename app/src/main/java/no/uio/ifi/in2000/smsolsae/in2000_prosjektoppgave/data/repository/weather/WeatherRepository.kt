package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.data.repository.weather

import no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.ui.ui_state.WeatherLocationInfo

/**
 * Interface for WeatherRepository, which is a repository for weather data.
 * Implemented in ImplementedWeatherRepository.
 */
interface WeatherRepository{

    /**
     * Fetches the weather information for a specific location.
     * @param latitude Latitude of the location.
     * @param longitude Longitude of the location.
     * @param altitude Altitude of the location (optional).
     * @return WeatherLocationInfo object containing detailed weather information for the location.
     */
    suspend fun getLocationWeather(latitude: String, longitude: String, altitude: String? = null) : WeatherLocationInfo
}
