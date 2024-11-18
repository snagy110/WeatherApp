package com.telekommms.library.weathersdk.models.data

@kotlinx.serialization.Serializable
internal data class ErrorResponse(
    val code: Int,
    val type: String,
    val message: String
)