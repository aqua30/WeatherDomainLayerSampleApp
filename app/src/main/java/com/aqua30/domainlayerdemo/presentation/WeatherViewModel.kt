package com.aqua30.domainlayerdemo.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aqua30.domainlayerdemo.data.common.DataProvider
import com.aqua30.domainlayerdemo.data.common.Resource
import com.aqua30.domainlayerdemo.domain.models.WeatherScreenState
import com.aqua30.domainlayerdemo.domain.use_cases.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Saurabh
 */
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUseCase: GetWeatherUseCase
): ViewModel() {

    private var _weatherState = mutableStateOf(WeatherScreenState())
    val weatherState: State<WeatherScreenState> = _weatherState

    init {
        getWeatherReport(DataProvider.OPEN_API)
    }

    fun changeProvider(provider: DataProvider) {
        getWeatherReport(provider)
    }

    private fun getWeatherReport(provider: DataProvider) {
        viewModelScope.launch {
            weatherUseCase(provider).collect { resource ->
                when(resource) {
                    is Resource.Success -> {
                        _weatherState.value = WeatherScreenState(
                            data = resource.data
                        )
                    }
                    is Resource.Error -> {
                        _weatherState.value = WeatherScreenState(
                            hasError = true,
                            errorMessage = resource.message
                        )
                    }
                    is Resource.Loading -> {
                        _weatherState.value = WeatherScreenState(
                            isLoading = true
                        )
                    }
                }
            }
        }
    }
}