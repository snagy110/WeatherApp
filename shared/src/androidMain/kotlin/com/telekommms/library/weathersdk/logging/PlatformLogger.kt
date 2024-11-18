package com.telekommms.library.weathersdk.logging

object PlatformLogger {
    fun i(calledClass: String, calledMethod: String, extra: String? = null) {
        println("${LogLevel.verbose} $calledClass $calledMethod $extra")
    }

    fun d(calledClass: String, calledMethod: String, extra: String? = null) {
        println("${LogLevel.debug} $calledClass $calledMethod $extra")
    }

    fun w(calledClass: String, calledMethod: String, extra: String? = null) {
        println("${LogLevel.warning} $calledClass $calledMethod $extra")
    }

    fun e(calledClass: String, calledMethod: String, extra: String? = null, error: Exception? /* = java.lang.Exception? */ = null) {
        println("${LogLevel.error} $calledClass $calledMethod $extra ${error?.printStackTrace()}")
    }
}