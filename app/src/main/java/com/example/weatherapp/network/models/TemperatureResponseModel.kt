package com.example.weatherapp.network.models


import com.google.gson.annotations.SerializedName

data class TemperatureResponseModel(
    @SerializedName("day")
    val day: Double?,
    @SerializedName("eve")
    val eve: Double?,
    @SerializedName("max")
    val max: Double?,
    @SerializedName("min")
    val min: Double?,
    @SerializedName("morn")
    val morn: Double?,
    @SerializedName("night")
    val night: Double?
)