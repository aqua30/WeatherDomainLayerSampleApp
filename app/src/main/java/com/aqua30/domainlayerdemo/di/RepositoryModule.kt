package com.aqua30.domainlayerdemo.di

import com.aqua30.domainlayerdemo.data.common.Constants.OA_REPO
import com.aqua30.domainlayerdemo.data.common.Constants.VC_REPO
import com.aqua30.domainlayerdemo.data.remote.repository.OpenApiRepository
import com.aqua30.domainlayerdemo.data.remote.repository.VisualCrossingRepository
import com.aqua30.domainlayerdemo.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

/**
 * Created by Saurabh
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Named(OA_REPO)
    abstract fun provideOARepository(
        repository: OpenApiRepository
    ): WeatherRepository

    @Binds
    @Named(VC_REPO)
    abstract fun provideVCRepository(
        repository: VisualCrossingRepository
    ): WeatherRepository
}