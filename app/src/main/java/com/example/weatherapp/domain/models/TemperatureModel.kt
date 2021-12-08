package com.example.weatherapp.domain.models


/**
 * Created by Batuhan Duvarci on 8.12.2021.
 */
data class TemperatureModel(
    val day: Double? = null,
    val eve: Double? = null,
    val max: Int? = null,
    val min: Int? = null,
    val morn: Double? = null,
    val night: Double? = null
)
