package com.example.weatherapp.ui.weatherdetail

import android.view.View
import androidx.fragment.app.viewModels
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherDetailBinding
import com.example.weatherapp.ui.base.BaseFragment

class WeatherDetailFragment : BaseFragment<FragmentWeatherDetailBinding, WeatherDetailViewModel>(R.layout.fragment_weather_detail) {

    override val viewModel: WeatherDetailViewModel by viewModels()

    override fun bind(view: View) = FragmentWeatherDetailBinding.bind(view)

    override fun initUserInterface() {
        //TODO("Not yet implemented")
    }

    override fun initObservers() {
        //TODO("Not yet implemented")
    }

    override fun startCoroutine() {
        //TODO("Not yet implemented")
    }
}