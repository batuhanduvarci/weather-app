package com.example.weatherapp.network.mapper

import com.example.weatherapp.domain.models.DailyWeatherItemModel
import com.example.weatherapp.domain.models.TemperatureModel
import com.example.weatherapp.domain.models.WeatherItemModel
import com.example.weatherapp.domain.models.WeatherModel
import com.example.weatherapp.domain.util.DomainMapper
import com.example.weatherapp.network.mapper.util.DateUtils
import com.example.weatherapp.network.mapper.util.UrlUtils
import com.example.weatherapp.network.models.CurrentWeatherItemResponseModel
import com.example.weatherapp.network.models.DailyWeatherItemResponseModel
import com.example.weatherapp.network.models.TemperatureResponseModel
import com.example.weatherapp.network.models.WeatherResponseModel

class WeatherResponseMapper : DomainMapper {

    override fun mapToDomainModel(response: WeatherResponseModel): WeatherModel {
        return WeatherModel(
            current = mapCurrentList(response.current?.currentWeather),
            daily = mapDailyList(response.daily)
        )
    }

    override fun mapCurrentList(initial: List<CurrentWeatherItemResponseModel>?): List<WeatherItemModel> {
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
            mapCurrentList(initialModel.dailyWeather)
        )
    }

    override fun mapToTemperature(initialModel: TemperatureResponseModel?): TemperatureModel? {
        initialModel?.let {
            return TemperatureModel(
                max = it.max,
                min = it.min
            )
        }
        return null
    }
}