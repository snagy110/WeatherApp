package com.telekommms.library.weathersdk.models.data

@kotlinx.serialization.Serializable
data class WeatherForecastTimelines(
    val minutely: Array<TimelineItem<DataValuesMinutely>>,
    val hourly: Array<TimelineItem<DataValuesHourly>>,
    val daily: Array<TimelineItem<DataValuesDaily>>
)