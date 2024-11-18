package com.telekommms.library.weathersdk.models.data

import kotlinx.datetime.Instant

@kotlinx.serialization.Serializable
data class TimelineItem<out E>(
    val time: Instant,
    val values: E
)