package com.telekommms.library.weathersdk

import com.telekommms.library.weathersdk.models.MetricUnit
import com.telekommms.library.weathersdk.models.Response
import com.telekommms.library.weathersdk.models.cache.CachePolicy
import com.telekommms.library.weathersdk.models.data.HistoricalWeather
import com.telekommms.library.weathersdk.models.data.RealtimeWeather
import com.telekommms.library.weathersdk.models.data.WeatherForecast
import com.telekommms.library.weathersdk.network.NetworkClient
import com.telekommms.library.weathersdk.network.NetworkClient.client
import com.telekommms.library.weathersdk.persistence.PlatformFileStore
import com.telekommms.library.weathersdk.persistence.PlatformSettingStore
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.request
import io.ktor.util.InternalAPI
import io.ktor.util.toByteArray
import io.ktor.utils.io.jvm.javaio.toInputStream
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.ByteBuffer
import java.nio.ByteOrder

class WeatherClient(
    appId: String,
    platformFileStore: PlatformFileStore,
    platformSettingStore: PlatformSettingStore
) {
    companion object {
        private const val domain = ""

        private const val apiVersion = ""

        private const val routeWeather = ""

        private const val endPointForecast = ""

        private const val endPointRealtime = ""

        private const val endPointHistoryRecent = ""

        private const val TAG = "WEATHER_CLIENT"
    }

    @OptIn(InternalAPI::class)
    suspend fun requestWeatherForecast(
        latitude: Double,
        longitude: Double,
        units: MetricUnit = MetricUnit.metric,
        cachePolicy: CachePolicy = CachePolicy(0, false)
    ): Response<WeatherForecast> {
        val response: HttpResponse =
            client.get("https://api.tomorrow.io/v4/weather/forecast?location=$latitude,$longitude&apikey=X4Ctxmi35fC8EL5EZe3L7rAETOIuXhCn")
        val inputAsString = response.content.toInputStream().bufferedReader().use { it.readText() }
        val obj = Json.decodeFromString<WeatherForecast>(inputAsString)
        return Response.Success(obj)
    }

//    suspend fun requestRealtimeWeather(
//        latitude: Double,
//        longitude: Double,
//        units: MetricUnit = MetricUnit.metric,
//        cachePolicy: CachePolicy = CachePolicy(0, false)
//    ): Response<RealtimeWeather> {
//        /* compiled code */
//    }
//
//    suspend fun requestHistoricalWeather(
//        latitude: Double,
//        longitude: Double,
//        units: MetricUnit = MetricUnit.metric,
//        cachePolicy: CachePolicy = CachePolicy(0, false)
//    ): Response<HistoricalWeather> {
//        /* compiled code */
//    }
//
//    fun ByteArray.toIntArray() {
//        val intBuf =
//            ByteBuffer.wrap(this)
//                .order(ByteOrder.BIG_ENDIAN)
//                .asIntBuffer()
//        val array = IntArray(intBuf.remaining())
//        intBuf[array]
//    }
}
