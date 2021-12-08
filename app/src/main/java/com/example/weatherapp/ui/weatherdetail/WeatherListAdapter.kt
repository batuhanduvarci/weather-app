package com.example.weatherapp.ui.weatherdetail

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.weatherapp.R
import com.example.weatherapp.domain.models.DailyWeatherItemModel
import javax.inject.Inject

/**
 * Created by Batuhan Duvarci on 7.12.2021.
 */
class WeatherListAdapter(private val resources: Resources) : ListAdapter<DailyWeatherItemModel, WeatherViewHolder>(WeatherListItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return WeatherViewHolder(view, resources)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_weather
    }

    class WeatherListItemDiffCallback : DiffUtil.ItemCallback<DailyWeatherItemModel>() {
        override fun areItemsTheSame(oldItem: DailyWeatherItemModel, newItem: DailyWeatherItemModel): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: DailyWeatherItemModel, newItem: DailyWeatherItemModel): Boolean {
            return oldItem == newItem
        }
    }
}