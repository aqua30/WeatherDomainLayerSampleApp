package com.aqua30.domainlayerdemo.data.remote.response.visual_crossing

import com.aqua30.domainlayerdemo.data.remote.response.ApiResponse

data class VisualCrossingData(
    val address: String,
    val currentConditions: CurrentConditions,
    val days: List<Day>,
    val latitude: Double,
    val longitude: Double,
): ApiResponse