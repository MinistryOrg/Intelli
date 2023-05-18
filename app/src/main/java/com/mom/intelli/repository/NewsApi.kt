package com.mom.intelli.repository

import com.mom.intelli.data.news.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("news?")
    suspend fun getNews(
        @Query("apikey") apikey: String,
        @Query("country") country: String,
        @Query("language") language: String,
        @Query("category") category : String
    ): Response <NewsApiResponse>
}