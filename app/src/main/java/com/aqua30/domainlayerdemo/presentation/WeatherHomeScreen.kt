package com.aqua30.domainlayerdemo.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aqua30.domainlayerdemo.data.common.DataProvider
import com.aqua30.domainlayerdemo.domain.models.WeatherScreenState

/**
 * Created by Saurabh
 */
@Composable
fun WeatherHomeScreen(
    state: WeatherScreenState,
    onProviderChanged: (DataProvider) -> Unit
) {
    var checked by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        state.data?.let { weatherData ->
            Column(
                verticalArrangement = Arrangement.Top
            ) {
                WeatherScreen(
                    state = weatherData,
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = {
                                checked = it
                                onProviderChanged(
                                    if (checked) DataProvider.VISUAL_CROSSING
                                    else DataProvider.OPEN_API
                                )
                            },
                            enabled = true,
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.Red,
                                uncheckedColor = Color.DarkGray,
                                checkmarkColor = Color.Green
                            )
                        )

                        Text(
                            text = "Check the box to load report from other provider",
                            style = TextStyle(
                                color = Color.DarkGray,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }
        }

        // if there is an error loading the report
        if (state.hasError) {
            Text(
                text = state.errorMessage ?: "Something went wrong",
                style = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                color = Color.DarkGray,
            )
        }
    }
}