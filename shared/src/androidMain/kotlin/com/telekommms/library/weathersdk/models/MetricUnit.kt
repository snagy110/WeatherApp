package com.telekommms.library.weathersdk.models

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
enum class MetricUnit {
    @SerialName("metric")
    metric,

    @SerialName("imperial")
    imperial;
}