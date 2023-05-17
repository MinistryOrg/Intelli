package com.mom.intelli.service

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.mom.intelli.data.NewsApiResponse
import com.mom.intelli.util.serviceUtil.EmailUtil
import com.mom.intelli.util.serviceUtil.IntentAppsUtil
import com.mom.intelli.util.serviceUtil.NewsUtil

class IntelliService(var context: Context) {
    private val intentAppsUtil : IntentAppsUtil = IntentAppsUtil()
    private val newsUtil : NewsUtil = NewsUtil()
    private val emailUtil : EmailUtil = EmailUtil()

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

    suspend fun getNews(category: String): NewsApiResponse {
        return newsUtil.getNews(category,context)
    }

}