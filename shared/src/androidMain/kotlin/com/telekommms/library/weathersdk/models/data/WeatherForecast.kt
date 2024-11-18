package com.telekommms.library.weathersdk.models.data

@kotlinx.serialization.Serializable
data class WeatherForecast(
    val timelines: WeatherForecastTimelines,
    val location: Location
)