package com.example.weatherapp.ui.weatherapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.constants.ApplicationConstants
import java.util.regex.Pattern

/**
 * Created by Batuhan Duvarci on 6.12.2021.
 */
class WeatherApiViewModel : ViewModel() {

    private val _validation = MutableLiveData<Boolean>()
    val validation: LiveData<Boolean> get() = _validation

    fun validateApiKey(apiKey: String){
        val pattern = Pattern.compile(ApplicationConstants.API_KEY_REGEX)
        _validation.value = pattern.matcher(apiKey).matches()
    }
}