package com.mom.intelli.util.serviceUtil

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.util.Log
import androidx.compose.ui.platform.LocalFocusManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.mom.intelli.data.weather.Coord
import com.mom.intelli.data.weather.Main
import com.mom.intelli.data.weather.Weather
import com.mom.intelli.data.weather.WeatherApiResponse
import com.mom.intelli.repository.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherUtil(private val context: Context) {
    private val weatherApiKey : String = "846df6c82e04eac5b4a6f45a9f680baf"

    suspend fun getWeather() : WeatherApiResponse {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val weatherApiService = retrofit.create(WeatherApi::class.java)

        val locationData : List <Double> = getUserLocation()
        val response = weatherApiService.getWeather(locationData[0], locationData[1],weatherApiKey)
        val weatherBody = response.body()

        val coord = weatherBody!!.coord
        val weather = weatherBody.weather
        val base = weatherBody.base
        val main = weatherBody.main
        val tempCels = main.temp - 273.15
        Log.d("Temp", tempCels.toString())

        return WeatherApiResponse(coord,weather,base,main)
    }

    fun getTraffic(){

    }

    private fun getUserLocation() : List <Double>{
        var latitude = 35.1264
        var longitude = 33.4299
        val activity = context as Activity
        // Get the location manager
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        // can be anything is a code to request so yes
        val PERMISSIONS_REQUEST_LOCATION = 100
        // Request location permission if not already granted
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSIONS_REQUEST_LOCATION
            )
        }
        // Check if location is enabled
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            // Get the last known location
            val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (location != null) {
                // add the location to the values
                latitude = location.latitude
                longitude = location.longitude
            }
        }

            return arrayListOf(latitude,longitude)
    }
}