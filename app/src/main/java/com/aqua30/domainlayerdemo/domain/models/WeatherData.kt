package com.aqua30.domainlayerdemo.domain.models

/**
 * Created by Saurabh
 */
data class WeatherData(
    val lat: String = "22.1",
    val lng: String = "43.5",
    val temp: String = "50",
    val sunrise: String = "06:00",
    val sunset: String = "19:00",
    val windSpeed: String = "10 km/h",
    val pressure: String = "1015 hPa",
    val humidity: String = "77%",
    val feelsLike: String = "25",
    val maxTemp: String = "100",
    val minTemp: String = "0",
)
