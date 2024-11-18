package com.telekommms.library.weathersdk.models.data

@kotlinx.serialization.Serializable
data class HistoricalWeatherTimeline(
    val hourly: List<TimelineItem<DataValuesHourly>>,
    val daily: List<TimelineItem<DataValuesDaily>>
)