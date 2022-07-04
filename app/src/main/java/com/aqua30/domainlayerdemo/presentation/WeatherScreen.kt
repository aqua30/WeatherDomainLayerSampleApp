package com.aqua30.domainlayerdemo.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aqua30.domainlayerdemo.domain.models.WeatherData

/**
 * Created by Saurabh
 */
@Composable
fun WeatherScreen(
    state: WeatherData,
) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .background(Color.White),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "${state.temp} C",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 40.sp
                )
            )
        }
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WeatherPropertyItem(
                modifier = Modifier.weight(1f),
                title = "Sunrise",
                data = state.sunrise
            )

            WeatherPropertyItem(
                modifier = Modifier.weight(1f),
                title = "Sunset",
                data = state.sunset
            )
        }

        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WeatherPropertyItem(
                modifier = Modifier.weight(1f),
                title = "Feels like",
                data = state.feelsLike
            )

            WeatherPropertyItem(
                modifier = Modifier.weight(1f),
                title = "Humidity",
                data = state.humidity
            )
        }

        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WeatherPropertyItem(
                modifier = Modifier.weight(1f),
                title = "Wind",
                data = state.windSpeed
            )

            WeatherPropertyItem(
                modifier = Modifier.weight(1f),
                title = "Pressure",
                data = state.pressure
            )
        }

        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WeatherPropertyItem(
                modifier = Modifier.weight(1f),
                title = "Latitude",
                data = state.lat
            )

            WeatherPropertyItem(
                modifier = Modifier.weight(1f),
                title = "Longitude",
                data = state.lng
            )
        }

        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WeatherPropertyItem(
                modifier = Modifier.weight(1f),
                title = "Max Temp",
                data = state.maxTemp
            )

            WeatherPropertyItem(
                modifier = Modifier.weight(1f),
                title = "Min Temp",
                data = state.minTemp
            )
        }
    }
}

@Preview
@Composable
fun previewWeatherScreen() {
    WeatherScreen(state = WeatherData(temp = "42"))
}