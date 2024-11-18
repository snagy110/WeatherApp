package com.telekommms.library.weathersdk.models.data

@kotlinx.serialization.Serializable
data class Location(
    val lat: Double? = null,
    val lon: Double? = null,
    val name: String? = null,
    val type: String? = null
)