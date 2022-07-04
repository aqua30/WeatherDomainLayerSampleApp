package com.aqua30.domainlayerdemo.data.remote.response.open_api

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("feels_like")
    val feelsLike: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    @SerializedName("temp_max")
    val maxTemp: Double,
    @SerializedName("temp_min")
    val minTemp: Double
)