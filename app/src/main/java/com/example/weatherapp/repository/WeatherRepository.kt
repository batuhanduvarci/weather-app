package com.example.weatherapp.repository

import com.example.weatherapp.domain.models.WeatherModel

interface WeatherRepository {

    suspend fun getWeatherData(latitude: Double, longitude: Double, apiId: String) : WeatherModel
}