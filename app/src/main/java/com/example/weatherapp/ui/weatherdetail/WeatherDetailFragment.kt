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
import com.example.weatherapp.ui.components.extensions.hideLoading
import com.example.weatherapp.ui.components.extensions.showLoading
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
            adapter = WeatherListAdapter(resources)
            weatherRecyclerView.adapter = adapter
        }
    }

    override fun initObservers() {
        viewModel.locationData.observe(viewLifecycleOwner){
            it?.let { pair ->
                with(binding!!.itemWeatherDetail){
                    locationTextView.text = pair.first
                }
                pair.second?.let { location ->
                    viewModel.getWeatherData(location.latitude, location.longitude, navArgs.appId)
                } ?: kotlin.run {
                    hideLoading()
                    Toast.makeText(requireContext(), resources.getString(R.string.fragment_weather_detail_location_error_text), Toast.LENGTH_LONG).show()
                }
            } ?: kotlin.run {
                hideLoading()
                Toast.makeText(requireContext(), resources.getString(R.string.fragment_weather_detail_location_error_text), Toast.LENGTH_LONG).show()
            }

        }

        viewModel.weatherData.observe(viewLifecycleOwner){
            when (it) {
                is NetworkResult.Error -> {
                    hideLoading()
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()
                }
                is NetworkResult.Loading -> { showLoading() }
                is NetworkResult.Success -> {
                    hideLoading()
                    it.data?.let { weatherModel ->
                        adapter.submitList(weatherModel.daily)
                        with(binding!!.itemWeatherDetail){
                            Glide.with(requireContext()).load(weatherModel.current?.currentWeather?.last()?.icon).into(weatherImageView)
                            degreeTextView.text = String.format(resources.getString(R.string.fragment_weather_detail_degree_text), weatherModel.current?.temp)
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getLocationData()
    }
}