package com.telekommms.library.weathersdk.network

import io.ktor.client.HttpClient
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

internal object NetworkClient {
//    val client: HttpClient /* compiled code */

    val client = HttpClient(CIO) {
        install(Logging) {
            level = LogLevel.INFO
        }
    }
}