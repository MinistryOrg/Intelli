package com.mom.intelli.util.serviceUtil

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.mom.intelli.data.NewsApiResponse
import com.mom.intelli.repository.NewsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsUtil {
    suspend fun getNews(category: String, context: Context): NewsApiResponse {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsdata.io/api/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val newsApiService = retrofit.create(NewsApi::class.java)

        val apikey = "pub_222077c5f72377e7b3b6c33454715d7e4b54e"
        val language = "en"

        val response = newsApiService.getNews(apikey, language, category)
        val news = response.body()
        // Access the retrieved data
        val status = news?.status
        val results = news?.results
        val totalResponse = news?.totalResults

        return NewsApiResponse(status!!, totalResponse!!, results!!)
    }
    fun openNewsLink(link: String, context: Context) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        context.startActivity(intent)
    }

}