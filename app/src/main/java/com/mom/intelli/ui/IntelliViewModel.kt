package com.mom.intelli.ui

import android.content.Context
import androidx.lifecycle.ViewModel
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

}