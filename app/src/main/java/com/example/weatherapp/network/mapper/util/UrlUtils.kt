package com.example.weatherapp.network.mapper.util

/**
 * Created by Batuhan Duvarci on 8.12.2021.
 */
object UrlUtils {

    fun generateUrl(iconString: String?): String?{
        iconString?.let {
            return "http://openweathermap.org/img/wn/${iconString}@2x.png"
        }
        return null
    }
}