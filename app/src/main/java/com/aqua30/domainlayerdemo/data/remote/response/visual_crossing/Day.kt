package com.aqua30.domainlayerdemo.data.remote.response.visual_crossing

data class Day(
    val feelslike: Double,
    val feelslikemax: Double,
    val feelslikemin: Double,
    val humidity: Double,
    val pressure: Double,
    val sunrise: String,
    val sunset: String,
    val temp: Double,
    val tempmax: Double,
    val tempmin: Double,
    val windspeed: Double
)