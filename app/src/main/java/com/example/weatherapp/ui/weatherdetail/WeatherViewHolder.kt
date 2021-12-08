package com.example.weatherapp.ui.weatherdetail

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.databinding.ItemWeatherBinding
import com.example.weatherapp.domain.models.DailyWeatherItemModel

/**
 * Created by Batuhan Duvarci on 7.12.2021.
 */
class WeatherViewHolder(private val view : View) : RecyclerView.ViewHolder(view) {
    fun bind(weather: DailyWeatherItemModel) {
        val binding = ItemWeatherBinding.bind(view)
        with(binding){
            dayTextView.text = weather.date
            Glide.with(view).load(weather.dailyWeather.last().icon).into(weatherImageView)
            weather.temp?.let {
                degreeHighestTextView.text = it.max.toString()
                degreeLowestTextView.text = it.min.toString()
            }
        }
    }
}