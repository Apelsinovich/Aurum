package com.example.myapplication.data.db.unitlocalized

import kotlin.String as String

interface UnitSpecificCurrentWeatherEntry {

    val cloudCover: Double
    val feelsLike: Double
    val humidity: Double
    val observationTime: String
    val precip: Double
    val pressure: Double
    val temperature: Double
    val uvIndex: Double
    val weatherCode: Double
    /*    @SerializedName ("weather_descriptions")
        val weatherDescriptions: List<String>,
        @SerializedName ("weather_icons")
        val weatherIcons: List<String>,*/
    val windDir: String
    val windSpeed: Double
}