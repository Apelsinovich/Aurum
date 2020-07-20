package com.example.myapplication.data.db.unitlocalized

import androidx.room.ColumnInfo

data class MetricCurrentWeatherEntry(
    @ColumnInfo(name = "cloudCover")
    override val cloudCover: Double,
    @ColumnInfo(name = "feelsLike")
    override val feelsLike: Double,
    @ColumnInfo(name = "humidity")
    override val humidity: Double,
    @ColumnInfo(name = "observationTime")
    override val observationTime: String,
    @ColumnInfo(name = "precip")
    override val precip: Double,
    @ColumnInfo(name = "pressure")
    override val pressure: Double,
    @ColumnInfo(name = "temperature")
    override val temperature: Double,
    @ColumnInfo(name = "uvIndex")
    override val uvIndex: Double,
    @ColumnInfo(name = "weatherCode")
    override val weatherCode: Double,
    @ColumnInfo(name = "windDir")
    override val windDir: String,
    @ColumnInfo(name = "windSpeed")
    override val windSpeed: Double

) : UnitSpecificCurrentWeatherEntry
