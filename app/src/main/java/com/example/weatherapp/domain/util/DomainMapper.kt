package com.example.weatherapp.domain.util

import com.example.weatherapp.domain.models.*
import com.example.weatherapp.network.models.*

interface DomainMapper {

    fun mapToDomainModel(response: WeatherResponseModel): WeatherModel

    fun mapCurrentWeather(initial: CurrentWeatherResponseModel?): CurrentWeatherModel?

    fun mapWeatherList(initial: List<CurrentWeatherItemResponseModel>?): List<WeatherItemModel>

    fun mapDailyList(initial: List<DailyWeatherItemResponseModel>?): List<DailyWeatherItemModel>

    fun mapToWeatherItem(initialModel: CurrentWeatherItemResponseModel): WeatherItemModel

    fun mapToDailyWeatherItem(initialModel: DailyWeatherItemResponseModel): DailyWeatherItemModel

    fun mapToTemperature(initialModel: TemperatureResponseModel?): TemperatureModel?
}