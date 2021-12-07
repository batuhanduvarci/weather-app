package com.example.weatherapp.domain.models

/**
 * Created by Batuhan Duvarci on 7.12.2021.
 */
data class WeatherModel(
    val current: List<WeatherItemModel>? = listOf(),
    val daily: List<List<WeatherItemModel>>? = listOf()
)
