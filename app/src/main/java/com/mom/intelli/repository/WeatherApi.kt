package com.mom.intelli.repository

import com.mom.intelli.data.weather.WeatherApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
        @GET("weather")
        suspend fun getWeather(
            @Query("lat") latitude: Double,
            @Query("lon") longitude: Double,
            @Query("appid") apiKey: String
        ) : Response <WeatherApiResponse>

}