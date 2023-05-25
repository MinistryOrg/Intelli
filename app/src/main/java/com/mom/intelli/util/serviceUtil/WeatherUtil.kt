package com.mom.intelli.util.serviceUtil

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.mom.intelli.data.news.NewsApiResponse
import com.mom.intelli.data.weather.WeatherData
import com.mom.intelli.repository.LocationApi
import com.mom.intelli.repository.NewsApi
import com.mom.intelli.repository.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WeatherUtil(private val context: Context) {
    private val weatherApiKey : String = "846df6c82e04eac5b4a6f45a9f680baf"
    suspend fun getWeather() : WeatherData {
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
        val description = weather[0].description
        val temp = (main.temp - 273.15).toInt()
        val feelsLike = (main.feelsLike - 273.15).toInt()
        var location = getUserCity(locationData[0], locationData[1])
        Log.d("Kairos", location)
        val city = location.split(", ")
        location = city[4] + ", " + city[city.size-1]

<<<<<<< Updated upstream
        return WeatherData(iconID = weather[0].icon, temp = temp, feelsLike = feelsLike , location = location, weather[0].description)
=======
        return WeatherData(iconID = weather[0].icon, temp = temp, feelsLike = feelsLike , location = location, description = description)
>>>>>>> Stashed changes
    }

    private suspend fun getUserCity(latitude: Double, longitude: Double): String {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://nominatim.openstreetmap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val locationApiService = retrofit.create(LocationApi::class.java)
        try {
            val response = locationApiService.getLocation("json", latitude, longitude)
            if (response.isSuccessful) {
                val responseBody = response.body()?.display_name
                responseBody?.let {
                    Log.d("Response", it)
                    return it
                }
            } else {
                Log.e("API Error", response.errorBody()?.string() ?: "Unknown error")
            }
        } catch (e: Exception) {
            Log.e("API Error", e.toString())
        }

        return "" // Return a default value or handle error cases accordingly
    }


    fun getUserLocation() : List <Double>{
        var latitude = 37.975443
        var longitude = 23.735431
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