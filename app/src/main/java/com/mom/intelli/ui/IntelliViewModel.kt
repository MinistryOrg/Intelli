package com.mom.intelli.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import com.mom.intelli.data.news.NewsApiResponse
import com.mom.intelli.data.weather.Main
import com.mom.intelli.service.IntelliService

class IntelliViewModel : ViewModel() {
    private var intelliService: IntelliService? = null

    fun init(context: Context) {
        intelliService = IntelliService(context = context)
    }

    fun openMaps() {
        intelliService!!.openMaps()
    }

    suspend fun getWeather() : Main {
        return intelliService!!.getWeather().main
    }

    fun showEmail() {
        intelliService!!.showEmail()
    }

    fun sendEmail(emailAddress: String, emailSubject: String, emailBody: String) {
        intelliService!!.sendEmail(emailAddress, emailSubject, emailBody)
    }

    fun openNewsLink(link: String) {
        intelliService!!.openNewsLink(link)
    }

    suspend fun getNews(category: String): NewsApiResponse? {
        return intelliService!!.getNews(category)
    }

    fun openMusicApp() {
        intelliService!!.openMusicApp()
    }

    fun openSettingsApp() {
        intelliService!!.openSettingsApp()
    }

    fun openPhoneCallsApp() {
        intelliService!!.openPhoneCallsApp()
    }

    fun openMessageApp() {
        intelliService!!.openMessageApp()
    }
    fun openAlarm(){
        intelliService!!.openAlarmApp()
    }
    fun openContactsApp() {
        intelliService!!.openContactsApp()
    }

}