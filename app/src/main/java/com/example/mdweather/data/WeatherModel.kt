package com.example.mdweather.data

data class WeatherModel(
    val city: String,
    val time: String,
    val currentTemp: String,
    val condition: String,
    val icon: String,
    val humidity: String,
    val windSpeed: String,
    val hours: String
)
