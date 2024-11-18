package com.telekommms.library.weathersdk.models.cache

data class CachePolicy(
    val timeToLive: Int,
    val returnCacheAsFallback: Boolean
)