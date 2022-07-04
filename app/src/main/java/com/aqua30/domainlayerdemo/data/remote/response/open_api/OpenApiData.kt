package com.aqua30.domainlayerdemo.data.remote.response.open_api

import com.aqua30.domainlayerdemo.data.remote.response.ApiResponse
import com.google.gson.annotations.SerializedName

data class OpenApiData(

    @SerializedName("coord")
    val coordinates: Coord,
    @SerializedName("main")
    val details: Main,
    @SerializedName("sys")
    val dayTime: Sys,
    val wind: Wind
): ApiResponse