package com.aqua30.domainlayerdemo.domain.use_cases

import com.aqua30.domainlayerdemo.data.common.Constants.OA_REPO
import com.aqua30.domainlayerdemo.data.common.Constants.VC_REPO
import com.aqua30.domainlayerdemo.data.common.DataProvider
import com.aqua30.domainlayerdemo.data.common.Resource
import com.aqua30.domainlayerdemo.data.dto.toWeatherData
import com.aqua30.domainlayerdemo.data.remote.response.open_api.OpenApiData
import com.aqua30.domainlayerdemo.data.remote.response.visual_crossing.VisualCrossingData
import com.aqua30.domainlayerdemo.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.concurrent.TimeoutException
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Saurabh
 */
class GetWeatherUseCaseImpl @Inject constructor(
    @Named(OA_REPO) private val oaRepository: WeatherRepository,
    @Named(VC_REPO) private val vcRepository: WeatherRepository,
): GetWeatherUseCase {

    override fun fetch(type: DataProvider) = flow {
        try {
            emit(Resource.Loading())
            when(type) {
                DataProvider.OPEN_API -> {
                    val apiResponse = oaRepository.getWeatherReport()
                    if (apiResponse.isSuccessful) {
                        val result = apiResponse.body() as OpenApiData
                        emit(Resource.Success(result.toWeatherData()))
                    } else {
                        emit(Resource.Error("Api is unsuccessful"))
                    }
                }
                DataProvider.VISUAL_CROSSING -> {
                    val apiResponse = vcRepository.getWeatherReport()
                    if (apiResponse.isSuccessful) {
                        val result = apiResponse.body() as VisualCrossingData
                        emit(Resource.Success(result.toWeatherData()))
                    } else {
                        emit(Resource.Error("Api is unsuccessful"))
                    }
                }
            }
        } catch (e: IOException) {
            emit(Resource.Error("IO Exception: ${e.message}"))
        } catch (e: TimeoutException) {
            emit(Resource.Error("Timeout Exception: ${e.message}"))
        } catch (e: HttpException) {
            emit(Resource.Error("Http Exception: ${e.message}"))
        }
    }
}