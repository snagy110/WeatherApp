package com.telekommms.library.weathersdk.models.data

@kotlinx.serialization.Serializable
data class DataValuesMinutely(
    val cloudBase: Double? = null,
    val cloudCeiling: Double? = null,
    val cloudCover: Double,
    val dewPoint: Double,
    val freezingRainIntensity: Double,
    val humidity: Double,
    val precipitationProbability: Double,
    val pressureSurfaceLevel: Double,
    val rainIntensity: Double,
    val sleetIntensity: Double,
    val snowIntensity: Double,
    val temperature: Double,
    val temperatureApparent: Double,
    val uvHealthConcern: Int? = null,
    val uvIndex: Int? = null,
    val visibility: Double,
    val weatherCodeValue: Int,
    val windDirection: Double,
    val windGust: Double,
    val windSpeed: Double
)