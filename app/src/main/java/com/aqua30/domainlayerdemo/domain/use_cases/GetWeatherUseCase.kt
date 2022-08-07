package com.aqua30.domainlayerdemo.domain.use_cases

import com.aqua30.domainlayerdemo.data.common.DataProvider
import com.aqua30.domainlayerdemo.data.common.Resource
import com.aqua30.domainlayerdemo.domain.models.WeatherData
import kotlinx.coroutines.flow.Flow

/**
 * Created by Saurabh
 */
interface GetWeatherUseCase {

    fun fetch(type: DataProvider): Flow<Resource<WeatherData>>
}