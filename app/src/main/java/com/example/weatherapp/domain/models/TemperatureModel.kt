package com.example.weatherapp.domain.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Batuhan Duvarci on 8.12.2021.
 */
data class TemperatureModel(
    val day: Double? = null,
    val eve: Double? = null,
    val max: Double? = null,
    val min: Double? = null,
    val morn: Double? = null,
    val night: Double? = null
)
