package com.aqua30.domainlayerdemo.domain.use_cases

import com.aqua30.domainlayerdemo.data.common.DataProvider
import com.aqua30.domainlayerdemo.data.common.Resource
import com.aqua30.domainlayerdemo.domain.models.WeatherData
import kotlinx.coroutines.flow.MutableSharedFlow

/**
 * Created by Saurabh
 */
class FakeWeatherUseCase: GetWeatherUseCase {

    private val fakeFlow = MutableSharedFlow<Resource<WeatherData>>()

    suspend fun emit(value: Resource<WeatherData>) = fakeFlow.emit(value)

    override fun fetch(type: DataProvider) =  fakeFlow
}