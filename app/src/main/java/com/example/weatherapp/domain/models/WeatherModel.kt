package com.example.weatherapp.domain.models

/**
 * Created by Batuhan Duvarci on 7.12.2021.
 */
data class WeatherModel(
    val current: CurrentWeatherModel? = null,
    val daily: List<DailyWeatherItemModel>? = listOf()
)
