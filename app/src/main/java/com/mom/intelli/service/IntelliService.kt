package com.mom.intelli.service

import android.content.Context
import androidx.room.Room
import com.mom.intelli.data.eshop.Device
import com.mom.intelli.data.news.NewsApiResponse
import com.mom.intelli.data.weather.WeatherApiResponse
import com.mom.intelli.database.AppDatabase
import com.mom.intelli.util.serviceUtil.EmailUtil
import com.mom.intelli.util.serviceUtil.IntentAppsUtil
import com.mom.intelli.util.serviceUtil.NewsUtil
import com.mom.intelli.util.serviceUtil.WeatherUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class IntelliService(var context: Context) {
    private val intentAppsUtil : IntentAppsUtil = IntentAppsUtil()
    private val newsUtil : NewsUtil = NewsUtil()
    private val emailUtil : EmailUtil = EmailUtil()
    private val weatherUtil : WeatherUtil = WeatherUtil(context)

    private val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "device"
    ).fallbackToDestructiveMigration().build()


    private val deviceDao = db.deviceDao()

    fun showEmail() {
        emailUtil.showEmail(context)
    }

    fun sendEmail(emailAddress: String, emailSubject: String, emailBody: String) {
        emailUtil.sendEmail(context,emailAddress,emailSubject, emailBody)
    }

    fun openMaps() {
        intentAppsUtil.openMaps(context)
    }

    fun openMusicApp() {
        intentAppsUtil.openIntent(context, "music")
    }

    fun openSettingsApp() {
        intentAppsUtil.openIntent(context, "settings")
    }

    fun openPhoneCallsApp() {
        intentAppsUtil.openIntent(context, "phoneCalls")
    }

    fun openMessageApp() {
        intentAppsUtil.openIntent(context, "message")
    }

    fun openAlarmApp() {
        intentAppsUtil.openIntent(context, "alarm")
    }

    fun openContactsApp() {
        intentAppsUtil.openIntent(context, "contact")
    }

    fun openNewsLink(link: String) {
        newsUtil.openNewsLink(link,context)
    }

    suspend fun insertToDatabase(device: Device){
        return withContext(Dispatchers.IO) {
            deviceDao.insertAll(device)
        }
    }

    suspend fun getCartDevices() : List<Device>{
        return withContext(Dispatchers.IO) {
            deviceDao.getAll()
        }
    }

    suspend fun getNews(category: String): NewsApiResponse {
        return newsUtil.getNews(category,context)
    }

    suspend fun getWeather() : WeatherApiResponse {
        return weatherUtil.getWeather()
    }

}