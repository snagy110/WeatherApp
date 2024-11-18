package com.telekommms.library.weathersdk.helper

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.encodeToJsonElement

object SerializationHelper {
    inline fun <reified T> jsonBuilder(value: T): JsonElement {
        return Json.encodeToJsonElement(value)
    }
}