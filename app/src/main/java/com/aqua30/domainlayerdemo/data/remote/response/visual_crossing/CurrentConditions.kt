package com.aqua30.domainlayerdemo.data.remote.response.visual_crossing

import com.google.gson.annotations.SerializedName

data class CurrentConditions(
    @SerializedName("feelslike")
    val feelsLike: Double,
    val humidity: Double,
    val pressure: Double,
    val sunrise: String,
    val sunriseEpoch: Int,
    val sunset: String,
    val sunsetEpoch: Int,
    val temp: Double,
    @SerializedName("windspeed")
    val windSpeed: Double
)