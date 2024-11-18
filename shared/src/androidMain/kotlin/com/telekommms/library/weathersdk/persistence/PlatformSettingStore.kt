package com.telekommms.library.weathersdk.persistence

import android.content.Context
import kotlinx.coroutines.flow.flow

//import androidx.datastore.preferences.preferencesDataStore

class PlatformSettingStore(context: Context) {
    companion object {
        private const val TAG: String = "PLATFORM_SETTING_STORE" /* compiled code */
    }

//    private val context: android.content.Context /* compiled code */

//    private val android.content.Context.dataStore: androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> /* compiled code */
//        private get

//    val Context.dataStore by preferencesDataStore(name = "settings")
    private val preferences = context.applicationContext.getSharedPreferences("PREFERENCES", Context.MODE_PRIVATE)

    suspend fun writeString(forKey: String, value: String) { /* compiled code */ }

    fun readString(forKey: String) = flow {
        emit(preferences.getString(forKey, ""))
    /* compiled code */
    }

    suspend fun writeInt(forKey: String, value: Int) {
        preferences.edit().let {
            it.putInt(forKey, value)
            it.apply()
        }
    }

    fun readInt(forKey: String) = flow {
        emit(preferences.getInt(forKey, 0))
    }

    suspend fun writeLong(forKey: String, value: Long) {
        preferences.edit().let {
            it.putLong(forKey, value)
            it.apply()
        }
    }

    fun readLong(forKey: String) = flow {
        emit(preferences.getLong(forKey, 0L))
    }

    suspend fun writeBool(forKey: String, value: Boolean) {
        preferences.edit().let {
            it.putBoolean(forKey, value)
            it.apply()
        }
    }

    fun readBool(forKey: String) = flow {
        emit(preferences.getBoolean(forKey, false))
    }

    suspend fun removeValue(forKey: String) {
        preferences.edit().let {
            it.remove(forKey)
            it.apply()
        }
    }
}