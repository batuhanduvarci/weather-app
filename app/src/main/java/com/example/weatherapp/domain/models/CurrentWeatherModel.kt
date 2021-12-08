package com.example.weatherapp.domain.models

/**
 * Created by Batuhan Duvarci on 8.12.2021.
 */
data class CurrentWeatherModel(
    val temp: Int? = null,
    val currentWeather: List<WeatherItemModel> = listOf()
)
