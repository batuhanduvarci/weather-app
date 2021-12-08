package com.example.weatherapp.ui.components.extensions

import androidx.fragment.app.Fragment
import com.example.weatherapp.ui.components.WeatherProgressDialog

fun Fragment.showLoading(){
    val progressDialogFragment = WeatherProgressDialog.newInstance()

    childFragmentManager.beginTransaction()
        .addToBackStack(null)

    progressDialogFragment.show(childFragmentManager, "progressDialog")
}

fun Fragment.hideLoading(){
    val progressDialogFragment =
        childFragmentManager.findFragmentByTag("progressDialog") as WeatherProgressDialog?
    progressDialogFragment?.dismiss()
}