package com.example.weatherapp.network.mapper

import com.example.weatherapp.domain.models.*
import com.example.weatherapp.domain.util.DomainMapper
import com.example.weatherapp.network.mapper.util.DateUtils
import com.example.weatherapp.network.mapper.util.UrlUtils
import com.example.weatherapp.network.models.*

class WeatherResponseMapper : DomainMapper {

    override fun mapToDomainModel(response: WeatherResponseModel): WeatherModel {
        return WeatherModel(
            current = mapCurrentWeather(response.current),
            daily = mapDailyList(response.daily)
        )
    }

    override fun mapCurrentWeather(initial: CurrentWeatherResponseModel?): CurrentWeatherModel? {
        initial?.let {
            return CurrentWeatherModel(
                it.temp?.toInt(),
                mapWeatherList(it.currentWeather)
            )
        }
        return null
    }

    override fun mapWeatherList(initial: List<CurrentWeatherItemResponseModel>?): List<WeatherItemModel> {
        initial?.let { list ->
            return list.map { mapToWeatherItem(it) }
        }
        return listOf()
    }

    override fun mapDailyList(initial: List<DailyWeatherItemResponseModel>?): List<DailyWeatherItemModel> {
        initial?.let { list ->
            return list.map { mapToDailyWeatherItem(it) }
        }
        return listOf()
    }

    override fun mapToWeatherItem(initialModel: CurrentWeatherItemResponseModel): WeatherItemModel {
        return WeatherItemModel(
            icon = UrlUtils.generateUrl(initialModel.icon)
        )
    }

    override fun mapToDailyWeatherItem(initialModel: DailyWeatherItemResponseModel): DailyWeatherItemModel {
        return DailyWeatherItemModel(
            DateUtils.convertToDate(initialModel.date),
            mapToTemperature(initialModel.temp),
            mapWeatherList(initialModel.dailyWeather)
        )
    }

    override fun mapToTemperature(initialModel: TemperatureResponseModel?): TemperatureModel? {
        initialModel?.let {
            return TemperatureModel(
                max = it.max?.toInt(),
                min = it.min?.toInt()
            )
        }
        return null
    }
}