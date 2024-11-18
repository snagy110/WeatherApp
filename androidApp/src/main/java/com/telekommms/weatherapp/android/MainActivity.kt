package com.telekommms.weatherapp.android

import android.location.Address
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.telekommms.library.weathersdk.WeatherClient
import com.telekommms.library.weathersdk.helper.DeviceLocationTracker
import com.telekommms.library.weathersdk.persistence.PlatformFileStore
import com.telekommms.library.weathersdk.persistence.PlatformSettingStore
import com.telekommms.weatherapp.Greeting
import com.telekommms.weatherapp.android.ui.details_screen.DetailsScreen
import com.telekommms.weatherapp.android.ui.home_screen.HomeScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity(), DeviceLocationTracker.DeviceLocationListener {
    private var lat = 0.0
    private var lon = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val platformFileStore = PlatformFileStore(this)
        val platformSettingStore = PlatformSettingStore(this)
        val weatherClient = WeatherClient(
            appId = "Weather App",
            platformSettingStore = platformSettingStore,
            platformFileStore = platformFileStore
        )
        CoroutineScope(Dispatchers.Default).launch {
            val weatherForecast = weatherClient.requestWeatherForecast(
                latitude = lat,
                longitude = lon
            )
        }
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(this)
//                    GreetingView(Greeting().greet())
                }
            }
        }
    }

    override fun onDeviceLocationChanged(results: List<Address>?) {
        val currentLocation = results?.get(0)
        currentLocation?.apply {
            var currentAddressLine = String()
            for (i in 0..this.maxAddressLineIndex) {
                currentAddressLine += this.getAddressLine(i)
            }
            lat = latitude
            lon = longitude
        }
    }
}
