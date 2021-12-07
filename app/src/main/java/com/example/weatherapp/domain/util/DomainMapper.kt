package com.example.weatherapp.domain.util

import com.example.weatherapp.domain.models.WeatherItemModel
import com.example.weatherapp.domain.models.WeatherModel
import com.example.weatherapp.network.models.WeatherItemResponseModel
import com.example.weatherapp.network.models.WeatherResponseModel

interface DomainMapper {

    fun mapToDomainModel(response: WeatherResponseModel): WeatherModel

    fun mapToDomainList(initial: List<WeatherItemResponseModel>?): List<WeatherItemModel>

    fun mapToDomainItem(initialModel: WeatherItemResponseModel): WeatherItemModel
}