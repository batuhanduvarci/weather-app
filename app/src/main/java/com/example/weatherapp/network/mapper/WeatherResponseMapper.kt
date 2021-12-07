package com.example.weatherapp.network.mapper

import com.example.weatherapp.domain.models.WeatherItemModel
import com.example.weatherapp.domain.models.WeatherModel
import com.example.weatherapp.domain.util.DomainMapper
import com.example.weatherapp.network.models.WeatherItemResponseModel
import com.example.weatherapp.network.models.WeatherResponseModel

class WeatherResponseMapper : DomainMapper {

    override fun mapToDomainModel(response: WeatherResponseModel): WeatherModel {
        return WeatherModel(
            current = mapToDomainList(response.current?.weather),
            daily = response.daily.map { mapToDomainList(it.weather) }
        )
    }

    override fun mapToDomainList(initial: List<WeatherItemResponseModel>?): List<WeatherItemModel> {
        initial?.let { list ->
            return list.map { mapToDomainItem(it) }
        }
        return listOf()
    }

    override fun mapToDomainItem(initialModel: WeatherItemResponseModel): WeatherItemModel {
        return WeatherItemModel(
            initialModel.description,
            initialModel.icon,
            initialModel.id,
            initialModel.main
        )
    }
}