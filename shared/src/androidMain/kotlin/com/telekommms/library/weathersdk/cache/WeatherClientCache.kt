package com.telekommms.library.weathersdk.cache

import android.content.Context
import com.telekommms.library.weathersdk.models.data.HistoricalWeather
import com.telekommms.library.weathersdk.models.cache.LocationRequest
import com.telekommms.library.weathersdk.persistence.PlatformFileStore
import com.telekommms.library.weathersdk.persistence.PlatformSettingStore
import com.telekommms.library.weathersdk.models.data.RealtimeWeather
import com.telekommms.library.weathersdk.models.data.WeatherForecast
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.*
import kotlinx.serialization.json.*

internal class WeatherClientCache(context: Context) {

    companion object {
        private const val TAG: String = "WEATHER_CLIENT_CACHE.log"

        private const val CACHE_FILENAME_FORECAST_PARAMETERS: String = "FORECAST_PARAMETERS.log"

        private const val CACHE_FILENAME_REALTIME_PARAMETERS: String = "REALTIME_PARAMETERS.log"

        private const val CACHE_FILENAME_HISTORICAL_PARAMETERS: String = "HISTORICAL_PARAMETERS.log"

        private const val CACHE_FILENAME_FORECAST_RESPONSE: String = "FORECAST_RESPONSE.log"

        private const val CACHE_FILENAME_REALTIME_RESPONSE: String = "REALTIME_RESPONSE.log"

        private const val CACHE_FILENAME_HISTORICAL_RESPONSE: String = "HISTORICAL_RESPONSE.log"

        private const val CACHE_TIMESTAMP_FORECAST: String = "TIMESTAMP_FORECAST.log"

        private const val CACHE_TIMESTAMP_REALTIME: String = "TIMESTAMP_REALTIME.log"

        private const val CACHE_TIMESTAMP_HISTORICAL: String = "TIMESTAMP_HISTORICAL.log"
    }

    private val platformFileStore: PlatformFileStore = PlatformFileStore(context = context)

    private val platformSettingStore: PlatformSettingStore = PlatformSettingStore(context = context)

    suspend fun writeWeatherForecastResponse(
        locationRequest: LocationRequest,
        forecast: WeatherForecast
    ) {
        /* compiled code */
    }

    fun readWeatherForecastLocationRequest(): LocationRequest? {
        return platformFileStore.readFromFile(CACHE_FILENAME_FORECAST_PARAMETERS)?.let {
            Json.decodeFromString<LocationRequest>(it)
        }
    }

    fun readWeatherForecastResponse(): WeatherForecast? {
        return platformFileStore.readFromFile(CACHE_FILENAME_FORECAST_RESPONSE)?.let {
            Json.decodeFromString<WeatherForecast>(it)
        }
    }

    fun readWeatherForecastTimestamp() = flow {
        var forecastTimeStamp = 0L
        platformFileStore.readFromFile(CACHE_TIMESTAMP_FORECAST)?.let {
            forecastTimeStamp = it.toLong()
        }
        emit(forecastTimeStamp)
    }

    suspend fun clearWeatherForecastResponse() {
        platformFileStore.removeFile(CACHE_FILENAME_FORECAST_RESPONSE)
    }

    suspend fun writeRealtimeWeatherResponse(
        locationRequest: LocationRequest,
        realtime: RealtimeWeather
    ) {
        platformFileStore.writeToFile(
            CACHE_TIMESTAMP_REALTIME,
            Json.encodeToString(locationRequest)
        )

        platformFileStore.writeToFile(
            CACHE_FILENAME_REALTIME_RESPONSE,
            Json.encodeToString(realtime)
        )
    }

    fun readRealtimeWeatherLocationRequest(): LocationRequest? {
        return platformFileStore.readFromFile(
            CACHE_FILENAME_REALTIME_PARAMETERS
        )?.let {
            Json.decodeFromString<LocationRequest>(it)
        }
    }

    fun readRealtimeWeatherResponse(): RealtimeWeather? {
        return platformFileStore.readFromFile(
            CACHE_FILENAME_HISTORICAL_PARAMETERS
        )?.let {
            Json.decodeFromString<RealtimeWeather>(it)
        }
    }

    fun readRealtimeWeatherTimestamp() = flow {
        var weatherTimeStamp = 0L
        platformFileStore.readFromFile(CACHE_TIMESTAMP_FORECAST)?.let {
            weatherTimeStamp = it.toLong()
        }
        emit(weatherTimeStamp)
    }

    suspend fun clearRealtimeWeatherResponse() {
        platformFileStore.removeFile(CACHE_FILENAME_REALTIME_RESPONSE)
    }

    suspend fun writeHistoricalWeatherResponse(
        locationRequest: LocationRequest,
        historical: HistoricalWeather
    ) {
        platformFileStore.writeToFile(
            CACHE_FILENAME_HISTORICAL_RESPONSE,
            Json.encodeToString(historical)
        )
    }

    fun readHistoricalWeatherLocationRequest(): LocationRequest? {
        return platformFileStore.readFromFile(
            CACHE_FILENAME_HISTORICAL_PARAMETERS
        )?.let {
            Json.decodeFromString<LocationRequest>(it)
        }
    }

    fun readHistoricalWeatherResponse(): HistoricalWeather? {
        return platformFileStore.readFromFile(
            CACHE_FILENAME_HISTORICAL_RESPONSE
        )?.let {
            Json.decodeFromString<HistoricalWeather>(it)
        }
    }

    fun readHistoricalWeatherTimestamp() = flow {
        var weatherTimeStamp = 0L
        platformFileStore.readFromFile(CACHE_TIMESTAMP_FORECAST)?.let {
            weatherTimeStamp = it.toLong()
        }
        emit(weatherTimeStamp)
    }

    suspend fun clearHistoricalWeatherResponse() {
        platformFileStore.removeFile(CACHE_FILENAME_REALTIME_RESPONSE)
    }

}