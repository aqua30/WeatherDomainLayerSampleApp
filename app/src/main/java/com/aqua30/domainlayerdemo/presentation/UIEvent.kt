package com.aqua30.domainlayerdemo.presentation

import com.aqua30.domainlayerdemo.data.common.DataProvider

/**
 * Created by Saurabh
 */
sealed class UIEvent {
    data class FetchWeatherReport(val provider: DataProvider): UIEvent()
    data class FetchWeatherForLocation(val lat: Long, val lng: Long): UIEvent()
}