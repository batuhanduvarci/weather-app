package com.example.weatherapp.network.mapper.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Batuhan Duvarci on 8.12.2021.
 */
object DateUtils {

    fun convertToDate(time: Long?): String? {
        val simpleDateFormat = SimpleDateFormat("EEEE", Locale.ENGLISH)
        time?.let {
            return try {
                simpleDateFormat.format(Date(it*1000))
            } catch (ex: Exception) {
                null
            }
        }
        return null
    }
}