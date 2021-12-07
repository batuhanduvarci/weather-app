package com.example.weatherapp.ui.weatherdetail

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherDetailBinding
import com.example.weatherapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
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
        with(viewLifecycleOwner) {
            lifecycleScope.launch(Dispatchers.IO) {
                whenStarted {
                    viewModel.getWeatherData(38.423733, 27.142826, "8ddadecc7ae4f56fee73b2b405a63659")
                }
            }
        }
    }
}