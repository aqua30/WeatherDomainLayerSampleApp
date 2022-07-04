package com.aqua30.domainlayerdemo.data.remote.repository

import com.aqua30.domainlayerdemo.data.remote.WeatherApis
import com.aqua30.domainlayerdemo.data.remote.response.open_api.OpenApiData
import com.aqua30.domainlayerdemo.domain.repository.WeatherRepository
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Saurabh
 */
class OpenApiRepository @Inject constructor(
    private val api: WeatherApis
): WeatherRepository {
    override suspend fun getWeatherReport(): Response<OpenApiData> =
        api.openApiReport()
}