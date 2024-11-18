package com.telekommms.library.weathersdk.models

import com.telekommms.library.weathersdk.models.data.Error

sealed class Response<out R> protected constructor() {
    data class Success<WeatherInformation>(
        val data: WeatherInformation
    ): Response<WeatherInformation>()

    data class FromCache<WeatherInformation>(
        val data: WeatherInformation
    ): Response<WeatherInformation>()

    data class Failure(
        val cause: Error, val reason: String?
    ): Response<Nothing>()
}