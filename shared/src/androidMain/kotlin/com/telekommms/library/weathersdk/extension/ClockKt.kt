package com.telekommms.library.weathersdk.extension

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun kotlinx.datetime.Clock.System.nowAsLocalDateTime(): LocalDateTime {
    return this.now().toLocalDateTime(TimeZone.UTC)
}