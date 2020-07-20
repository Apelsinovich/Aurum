package com.example.myapplication.data.network

import androidx.lifecycle.LiveData
import com.example.myapplication.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    //прочитать про suspend, LiveData
    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
}