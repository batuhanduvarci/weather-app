package com.example.weatherapp.ui.weatherdetail

import android.content.Context
import android.content.res.Resources
import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.R
import com.example.weatherapp.domain.models.WeatherModel
import com.example.weatherapp.gps.LocationUtils
import com.example.weatherapp.network.handler.NetworkResult
import com.example.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherDetailViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val resources: Resources,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _locationData =
        MutableLiveData<Pair<String, Location?>?>()
    val locationData: LiveData<Pair<String, Location?>?> get() = _locationData

    private val _weatherData =
        MutableLiveData<NetworkResult<WeatherModel>>(NetworkResult.Loading())
    val weatherData: LiveData<NetworkResult<WeatherModel>> get() = _weatherData

    fun getWeatherData(latitude: Double, longitude: Double, apiId: String) =
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = weatherRepository.getWeatherData(latitude, longitude, apiId)
                if (response.current == null || response.daily.isNullOrEmpty()) {
                    _weatherData.postValue(NetworkResult.Error(resources.getString(R.string.fragment_weather_detail_network_error_text)))
                } else {
                    _weatherData.postValue(NetworkResult.Success(response))
                }
            } catch (ex: Exception) {
                _weatherData.postValue(NetworkResult.Error(ex.message))
            }
        }

    fun getLocationData(){
        _locationData.value = LocationUtils.getCurrentLocation(context)
    }
}