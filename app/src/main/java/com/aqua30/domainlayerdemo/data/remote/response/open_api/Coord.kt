package com.aqua30.domainlayerdemo.data.remote.response.open_api

import com.google.gson.annotations.SerializedName

data class Coord(
    val lat: Double,
    @SerializedName("lon")
    val lng: Double
)