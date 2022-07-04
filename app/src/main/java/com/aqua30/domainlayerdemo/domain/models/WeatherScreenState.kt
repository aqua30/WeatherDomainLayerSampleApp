package com.aqua30.domainlayerdemo.domain.models

/**
 * Created by Saurabh
 */
data class WeatherScreenState(
    val data: WeatherData? = null,
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: String? = null
)