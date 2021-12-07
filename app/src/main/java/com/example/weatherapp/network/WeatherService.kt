package com.example.weatherapp.network

import com.example.weatherapp.constants.ApplicationConstants
import com.example.weatherapp.network.models.CurrentWeatherResponseModel
import com.example.weatherapp.network.models.WeatherResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(ApplicationConstants.WEATHER_ENDPOINT)
    suspend fun getWeatherData(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") appId: String,
        @Query("units") units: String? = ApplicationConstants.WEATHER_UNIT_DEFAULT_VALUE
    ) : WeatherResponseModel
}