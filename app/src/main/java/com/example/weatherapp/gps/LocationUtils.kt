package com.example.weatherapp.gps

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import com.example.weatherapp.constants.ApplicationConstants
import java.util.*

object LocationUtils {

    fun getCurrentLocation(context: Context) : Pair<String, Location?>? {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        return if (checkLocationPermission(context)){
            try {
                val gpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                val currentState = getCurrentState(context, gpsLocation)

                Pair(currentState, gpsLocation)
            } catch (ex: Exception){
                null
            }
        } else {
            null
        }
    }

    private fun checkLocationPermission(context: Context): Boolean{
        return ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    fun requestLocationPermission(activity: Activity){
        ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), ApplicationConstants.LOCATION_PERMISSION_ID)
    }

    private fun getCurrentState(context: Context, currentLocation: Location?): String{
        try {
            currentLocation?.let {
                val geocoder = Geocoder(context, Locale.getDefault())
                val addresses = geocoder.getFromLocation(currentLocation.latitude, currentLocation.longitude, 1)

                return if (addresses.size > 0){
                    addresses[0].adminArea
                } else {
                    "Unknown"
                }
            }
        } catch (ex: Exception){
            return "Unknown"
        }
        return "Unknown"
    }
}