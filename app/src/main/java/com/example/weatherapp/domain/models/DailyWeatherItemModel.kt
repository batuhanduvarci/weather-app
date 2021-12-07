package com.example.weatherapp.domain.models

/**
 * Created by Batuhan Duvarci on 8.12.2021.
 */
data class DailyWeatherItemModel(
    val date: String? = null,
    val temp: TemperatureModel? = null,
    val dailyWeather: List<WeatherItemModel> = listOf()
)
