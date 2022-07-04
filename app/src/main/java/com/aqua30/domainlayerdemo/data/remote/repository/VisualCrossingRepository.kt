package com.aqua30.domainlayerdemo.data.remote.repository

import com.aqua30.domainlayerdemo.data.remote.WeatherApis
import com.aqua30.domainlayerdemo.data.remote.response.visual_crossing.VisualCrossingData
import com.aqua30.domainlayerdemo.domain.repository.WeatherRepository
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Saurabh
 */
class VisualCrossingRepository @Inject constructor(
    private val api: WeatherApis
): WeatherRepository {
    override suspend fun getWeatherReport(): Response<VisualCrossingData> =
        api.visualCrossingReport()
}