package com.example.weatherapp.repository

import com.example.weatherapp.domain.models.WeatherItemModel
import com.example.weatherapp.network.WeatherService
import com.example.weatherapp.network.mapper.WeatherResponseMapper
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherService: WeatherService,
    private val weatherResponseMapper: WeatherResponseMapper
) : WeatherRepository {

    override suspend fun getWeatherData(latitude: Double, longitude: Double, apiId: String): List<WeatherItemModel> {
        return weatherResponseMapper.fromEntityList(weatherService.getWeatherData(latitude, longitude, apiId).weather)
    }
}