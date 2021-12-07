package com.example.weatherapp.network.mapper

import com.example.weatherapp.domain.models.WeatherItemModel
import com.example.weatherapp.domain.util.DomainMapper
import com.example.weatherapp.network.models.WeatherItemResponseModel

class WeatherResponseMapper : DomainMapper<WeatherItemResponseModel, WeatherItemModel> {

    override fun mapToDomainModel(response: WeatherItemResponseModel): WeatherItemModel {
        return WeatherItemModel(
            response.description,
            response.icon,
            response.id,
            response.main
        )
    }

    override fun fromEntityList(initial: List<WeatherItemResponseModel>): List<WeatherItemModel> {
        return initial.map { mapToDomainModel(it) }
    }
}