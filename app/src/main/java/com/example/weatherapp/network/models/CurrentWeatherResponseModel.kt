package com.example.weatherapp.network.models

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponseModel(
    @SerializedName("temp")
    val temp: Double? = null,
    @SerializedName("weather")
    val currentWeather: List<CurrentWeatherItemResponseModel> = listOf()
)
