package com.aqua30.domainlayerdemo.domain.repository

import com.aqua30.domainlayerdemo.data.remote.response.ApiResponse
import retrofit2.Response

/**
 * Created by Saurabh
 */
interface WeatherRepository {
    suspend fun getWeatherReport(): Response<out ApiResponse>
}