package com.aqua30.domainlayerdemo.di

import com.aqua30.domainlayerdemo.domain.use_cases.GetWeatherUseCase
import com.aqua30.domainlayerdemo.domain.use_cases.GetWeatherUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Saurabh
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun provideGetWeatherUseCase(
        useCase: GetWeatherUseCaseImpl
    ): GetWeatherUseCase
}