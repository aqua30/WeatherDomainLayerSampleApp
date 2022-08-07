package com.aqua30.domainlayerdemo.presentation

import com.aqua30.domainlayerdemo.data.common.Resource
import com.aqua30.domainlayerdemo.domain.models.WeatherData
import com.aqua30.domainlayerdemo.domain.use_cases.FakeWeatherUseCase
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

/**
 * Created by Saurabh
 */
@OptIn(ExperimentalCoroutinesApi::class)
class WeatherViewModelTest {

    private lateinit var viewModel: WeatherViewModel
    private lateinit var fakeWeatherUseCase: FakeWeatherUseCase

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        fakeWeatherUseCase = FakeWeatherUseCase()
        viewModel = WeatherViewModel(fakeWeatherUseCase)
    }

    @Test
    fun `for success resource, data must be available`() = runTest {
        fakeWeatherUseCase.emit(Resource.Success(WeatherData()))
        assertThat(viewModel.weatherState.value.data).isNotNull()
    }

    @Test
    fun `for loading resource, data should be null && isLoading should be true`() = runTest {
        fakeWeatherUseCase.emit(Resource.Loading())
        assertThat(viewModel.weatherState.value.isLoading).isTrue()
        assertThat(viewModel.weatherState.value.data).isNull()
    }

    @Test
    fun `for error resource, data should be null && hasError should be true && errorMessage should be Error`() = runTest {
        fakeWeatherUseCase.emit(Resource.Error(message = "Error"))
        assertThat(viewModel.weatherState.value.data).isNull()
        assertThat(viewModel.weatherState.value.hasError).isTrue()
        assertThat(viewModel.weatherState.value.errorMessage).isEqualTo("Error")
    }
}