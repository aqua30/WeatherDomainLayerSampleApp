package com.aqua30.domainlayerdemo.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

/**
* Created by Saurabh
*/
@Composable
fun WeatherPropertyItem(
    modifier: Modifier = Modifier,
    title: String,
    data: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 20.sp
            )
        )
        Text(
            text = data,
            style = TextStyle(
                color = Color.Black,
                fontSize = 30.sp
            )
        )
    }
}