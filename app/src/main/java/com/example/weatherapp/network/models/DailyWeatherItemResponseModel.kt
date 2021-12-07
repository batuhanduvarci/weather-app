package com.example.weatherapp.network.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Batuhan Duvarci on 8.12.2021.
 */
data class DailyWeatherItemResponseModel(
    @SerializedName("dt")
    val date: Long? = null,
    @SerializedName("temp")
    val temp: TemperatureResponseModel? = null,
    @SerializedName("weather")
    val dailyWeather: List<CurrentWeatherItemResponseModel> = listOf()
)
