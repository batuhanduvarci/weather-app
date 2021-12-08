package com.example.weatherapp.ui.weatherapi

import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherApiBinding
import com.example.weatherapp.ui.base.BaseFragment

/**
 * Created by Batuhan Duvarci on 6.12.2021.
 */
class WeatherApiFragment : BaseFragment<FragmentWeatherApiBinding, WeatherApiViewModel>(R.layout.fragment_weather_api) {

    override val viewModel: WeatherApiViewModel by viewModels()

    override fun bind(view: View) = FragmentWeatherApiBinding.bind(view)

    override fun initUserInterface() {
        with(binding!!){
            apiTextInputLayout.editText?.let {
                it.doOnTextChanged { text, start, before, count ->
                    viewModel.validateApiKey(text.toString())
                }
            }
            proceedMaterialButton.setOnClickListener{
                viewModel.validation.value?.let {
                    if (it){
                        findNavController().navigate(WeatherApiFragmentDirections.toFragmentWeatherDetail(apiTextInputEditText.text.toString()))
                    }
                }
            }
        }
    }

    override fun initObservers() {
        viewModel.validation.observe(viewLifecycleOwner) {
            with(binding!!) {
                if (it) {
                    apiTextInputLayout.isErrorEnabled = false
                    apiTextInputLayout.boxStrokeColor = resources.getColor(R.color.green)
                } else {
                    apiTextInputLayout.error =
                        getString(R.string.fragment_weather_api_text_input_layout_error_text)
                }

            }
        }
    }
}