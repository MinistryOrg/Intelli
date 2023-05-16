package com.mom.intelli.repository

import com.mom.intelli.data.NewsApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("news?")
    suspend fun getNews(
        @Query("apikey") apikey: String,
        @Query("language") language: String,
        @Query("category") category : String
    ): Response <NewsApiResponse>
}