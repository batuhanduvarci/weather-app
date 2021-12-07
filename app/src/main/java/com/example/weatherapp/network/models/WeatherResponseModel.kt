package com.example.weatherapp.network.models

import com.google.gson.annotations.SerializedName

data class WeatherResponseModel(
    @SerializedName("current")
    val current: CurrentWeatherResponseModel? = null,
    @SerializedName("daily")
    val daily: List<DailyWeatherItemResponseModel> = listOf()
)
