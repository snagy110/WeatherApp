package com.telekommms.library.weathersdk.models.data

@kotlinx.serialization.Serializable
data class RealtimeWeather(
    val location: Location,
    val data: TimelineItem<DataValuesMinutely>
)