package com.aqua30.domainlayerdemo.di

import com.aqua30.domainlayerdemo.data.remote.WeatherApis
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Saurabh
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideWeatherService(): WeatherApis {
        return Retrofit.Builder()
            .baseUrl("https://someUrl.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApis::class.java)
    }
}