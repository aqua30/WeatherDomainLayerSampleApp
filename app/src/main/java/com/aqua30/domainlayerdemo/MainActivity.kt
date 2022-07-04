package com.aqua30.domainlayerdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.aqua30.domainlayerdemo.presentation.WeatherHomeScreen
import com.aqua30.domainlayerdemo.presentation.WeatherViewModel
import com.aqua30.domainlayerdemo.ui.theme.DomainLayerDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DomainLayerDemoTheme {
                WeatherHomeScreen(
                    viewModel.weatherState.value
                ) { provider ->
                    viewModel.changeProvider(provider)
                }
            }
        }
    }
}