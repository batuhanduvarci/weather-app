package com.example.weatherapp.domain.util

import com.example.weatherapp.domain.models.DailyWeatherItemModel
import com.example.weatherapp.domain.models.TemperatureModel
import com.example.weatherapp.domain.models.WeatherItemModel
import com.example.weatherapp.domain.models.WeatherModel
import com.example.weatherapp.network.models.CurrentWeatherItemResponseModel
import com.example.weatherapp.network.models.DailyWeatherItemResponseModel
import com.example.weatherapp.network.models.TemperatureResponseModel
import com.example.weatherapp.network.models.WeatherResponseModel

interface DomainMapper {

    fun mapToDomainModel(response: WeatherResponseModel): WeatherModel

    fun mapCurrentList(initial: List<CurrentWeatherItemResponseModel>?): List<WeatherItemModel>

    fun mapDailyList(initial: List<DailyWeatherItemResponseModel>?): List<DailyWeatherItemModel>

    fun mapToWeatherItem(initialModel: CurrentWeatherItemResponseModel): WeatherItemModel

    fun mapToDailyWeatherItem(initialModel: DailyWeatherItemResponseModel): DailyWeatherItemModel

    fun mapToTemperature(initialModel: TemperatureResponseModel?): TemperatureModel?
}