package com.mom.intelli.repository

import com.mom.intelli.data.location.Location
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApi {
    @GET("reverse")
    suspend fun getLocation(
        @Query("format") format: String,
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ) : Response<Location>
}