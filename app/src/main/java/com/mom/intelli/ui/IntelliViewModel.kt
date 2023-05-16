package com.mom.intelli.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.mom.intelli.data.NewsApiResponse
import com.mom.intelli.data.Results
import com.mom.intelli.service.IntelliService

class IntelliViewModel : ViewModel(){
    private var intelliService : IntelliService ?= null

    fun init(context: Context){
        intelliService = IntelliService(context = context)
    }

    fun openMaps(){
        intelliService!!.openMaps()
    }

    fun openWeather(){

    }

    fun showEmail(){
        intelliService!!.showEmail()
    }

    fun sendEmail(emailAddress : String, emailSubject : String, emailBody : String) {
        intelliService!!.sendEmail(emailAddress,emailSubject,emailBody)
    }

    fun openNewsLink(link : String){
        intelliService!!.openNewsLink(link)
    }

    suspend fun getNews(category : String) : NewsApiResponse? {
       return intelliService!!.getNews(category)
    }


}