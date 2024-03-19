package no.uio.ifi.in2000.smsolsae.in2000_prosjektoppgave.model.weather

data class Details(
    val air_pressure_at_sea_level: Double,
    val air_temperature: Double,
    val cloud_area_fraction: Double,
    val relative_humidity: Double,
    val wind_from_direction: Double,
    val wind_speed: Double
)