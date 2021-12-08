package com.example.weatherapp.ui.weatherdetail

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherDetailBinding
import com.example.weatherapp.network.handler.NetworkResult
import com.example.weatherapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WeatherDetailFragment : BaseFragment<FragmentWeatherDetailBinding, WeatherDetailViewModel>(R.layout.fragment_weather_detail) {

    override val viewModel: WeatherDetailViewModel by viewModels()

    private val navArgs: WeatherDetailFragmentArgs by navArgs()

    private lateinit var adapter: WeatherListAdapter

    override fun bind(view: View) = FragmentWeatherDetailBinding.bind(view)

    override fun initUserInterface() {
        with(binding!!){
            adapter = WeatherListAdapter()
            weatherRecyclerView.adapter = adapter
        }

    }

    override fun initObservers() {
        viewModel.weatherData.observe(viewLifecycleOwner){
            when (it) {
                is NetworkResult.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
                is NetworkResult.Loading -> {}
                is NetworkResult.Success -> {
                    it.data?.let { weatherModel ->
                        adapter.submitList(weatherModel.daily)
                        with(binding!!){
                            itemWeatherDetail.locationTextView.text = "İzmir"
                            Glide.with(requireContext()).load(weatherModel.current?.currentWeather?.last()?.icon).into(itemWeatherDetail.weatherImageView)
                            itemWeatherDetail.degreeTextView.text = weatherModel.current?.temp.toString()
                        }
                    }
                }
            }
        }
    }

    override fun startCoroutine() {
        with(viewLifecycleOwner) {
            lifecycleScope.launch(Dispatchers.IO) {
                whenStarted {
                    viewModel.getWeatherData(38.423733, 27.142826, navArgs.appId)
                }
            }
        }
    }
}