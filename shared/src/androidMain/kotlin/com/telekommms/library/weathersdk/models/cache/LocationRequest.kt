package com.telekommms.library.weathersdk.models.cache

import com.telekommms.library.weathersdk.models.MetricUnit

@kotlinx.serialization.Serializable
data class LocationRequest(
    val latitude: Double,
    val longitude: Double,
    val metricUnit: MetricUnit
)