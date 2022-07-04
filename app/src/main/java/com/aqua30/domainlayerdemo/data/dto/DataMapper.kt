package com.aqua30.domainlayerdemo.data.dto

import com.aqua30.domainlayerdemo.data.remote.response.open_api.OpenApiData
import com.aqua30.domainlayerdemo.data.remote.response.visual_crossing.VisualCrossingData
import com.aqua30.domainlayerdemo.domain.models.WeatherData

/**
 * Created by Saurabh
 */
fun VisualCrossingData.toWeatherData() : WeatherData {
    return WeatherData(
        lat = this.latitude.toString(),
        lng = this.longitude.toString(),
        temp = this.currentConditions.temp.toString(),
        sunrise = this.currentConditions.sunrise,
        sunset = this.currentConditions.sunset,
        windSpeed = this.currentConditions.windSpeed.toString(),
        pressure = this.currentConditions.pressure.toString(),
        humidity = this.currentConditions.humidity.toString(),
        feelsLike = this.currentConditions.feelsLike.toString(),
        maxTemp = this.days[0].tempmax.toString(),
        minTemp = this.days[0].tempmin.toString(),
    )
}

fun OpenApiData.toWeatherData() : WeatherData {
    return WeatherData(
        lat = this.coordinates.lat.toString(),
        lng = this.coordinates.lng.toString(),
        temp = this.details.temp.toString(),
        sunrise = this.dayTime.sunrise.toString(),
        sunset = this.dayTime.sunset.toString(),
        windSpeed = this.wind.speed.toString(),
        pressure = this.details.pressure.toString(),
        humidity = this.details.humidity.toString(),
        feelsLike = this.details.feelsLike.toString(),
        maxTemp = this.details.maxTemp.toString(),
        minTemp = this.details.minTemp.toString(),
    )
}