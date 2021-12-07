package com.example.weatherapp.ui.weatherdetail

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.R
import com.example.weatherapp.domain.models.WeatherItemModel
import com.example.weatherapp.network.handler.NetworkResult
import com.example.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherDetailViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val resources: Resources
) : ViewModel() {

    private val _weatherData =
        MutableLiveData<NetworkResult<List<WeatherItemModel>>>(NetworkResult.Loading())
    val weatherData: LiveData<NetworkResult<List<WeatherItemModel>>> get() = _weatherData

    suspend fun getWeatherData(latitude: Double, longitude: Double, apiId: String) {
        try {
            val response = weatherRepository.getWeatherData(latitude, longitude, apiId)
            if (response.isEmpty()) {
                _weatherData.postValue(NetworkResult.Error(resources.getString(R.string.fragment_weather_detail_network_error_text)))
            } else {
                _weatherData.postValue(NetworkResult.Success(response))
            }
        } catch (ex: Exception) {
            _weatherData.postValue(NetworkResult.Error(ex.message))
        }
    }
}