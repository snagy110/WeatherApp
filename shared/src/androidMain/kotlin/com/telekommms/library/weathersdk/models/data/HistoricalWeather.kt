package com.telekommms.library.weathersdk.models.data

@kotlinx.serialization.Serializable
data class HistoricalWeather(
    val location: Location,
    val timelines: HistoricalWeatherTimeline
)