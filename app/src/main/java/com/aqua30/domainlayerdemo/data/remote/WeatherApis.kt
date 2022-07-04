package com.aqua30.domainlayerdemo.data.remote

import com.aqua30.domainlayerdemo.BuildConfig
import com.aqua30.domainlayerdemo.data.remote.response.open_api.OpenApiData
import com.aqua30.domainlayerdemo.data.remote.response.visual_crossing.VisualCrossingData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 * Created by Saurabh
 */
interface WeatherApis {

    @GET
    suspend fun openApiReport(
        @Url url: String = BuildConfig.OA_URL,
        @Query("appid") apiKey: String = BuildConfig.OA_API_KEY,
        @Query("lat") lat: Double = 40.7146,
        @Query("lon") lon: Double = -74.0071,
    ): Response<OpenApiData>

    @GET
    suspend fun visualCrossingReport(
        @Url url: String = BuildConfig.VC_URL,
        @Query("key") apiKey: String = BuildConfig.VC_API_KEY,
        @Query("contentType") contentType: String = "json",
        @Query("include") include: String = "events,current",
        @Query("unitGroup") unit: String = "us",
    ): Response<VisualCrossingData>
}