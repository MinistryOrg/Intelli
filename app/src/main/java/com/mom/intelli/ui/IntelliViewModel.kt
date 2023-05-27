package com.mom.intelli.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import com.mom.intelli.data.calendar.Reminder
import com.mom.intelli.data.eshop.CheckOut
import com.mom.intelli.data.eshop.Device
import com.mom.intelli.data.news.NewsApiResponse
import com.mom.intelli.data.smarthome.Smarthome
import com.mom.intelli.data.user.User
import com.mom.intelli.data.weather.WeatherApiResponse
import com.mom.intelli.data.weather.WeatherData
import com.mom.intelli.service.IntelliService
import java.time.LocalDate

class IntelliViewModel : ViewModel() {
    private var intelliService: IntelliService? = null
    public var user : User ?= null
    fun init(context: Context) {
        intelliService = IntelliService(context = context)
    }

    fun openMaps() {
        intelliService!!.openMaps()
    }

    suspend fun getWeather() : WeatherData {
        return intelliService!!.getWeather()
    }

    fun showEmail() {
        intelliService!!.showEmail()
    }

    fun sendEmail(emailAddress: String, emailSubject: String, emailBody: String) {
        intelliService!!.sendEmail(emailAddress, emailSubject, emailBody)
    }

    fun openNewsLink(link: String, action : String) {
        intelliService!!.openNewsLink(link, action)
    }

    suspend fun getNews(category: String): NewsApiResponse {
        return intelliService!!.getNews(category)
    }

    suspend fun insertDeviceToDatabase(device: Device){
        intelliService!!.insertDeviceToDatabase(device)
    }

    suspend fun getCartDevices() : List<Device> {
        return intelliService!!.getCartDevices()
    }

    suspend fun insertCheckOut(checkOut : CheckOut){
        intelliService!!.insertCheckOut(checkOut)
    }

    suspend fun getCheckOut() : List<CheckOut>{
       return intelliService!!.getCheckOut()
    }

    suspend fun insertSmarthomeToDatabase(smarthome: Smarthome){
        intelliService!!.insertSmarthomeToDatabase(smarthome)
    }

    suspend fun getSmarthome() : List<Smarthome>{
        return intelliService!!.getSmarthome()
    }

    suspend fun deleteDevice(devices : List<Device>){
        return intelliService!!.deleteDevice(devices)
    }

    suspend fun insertReminderToDatabase(reminder: Reminder){
        intelliService!!.insertReminder(reminder)
    }

    suspend fun getReminders() : List<Reminder> {
        return intelliService!!.getReminders()
    }

    suspend fun getRemindersByDate (date: LocalDate) : List<Reminder> {
        return intelliService!!.getRemindersByDate(date)
    }

    suspend fun deleteReminder(reminder: Reminder){
        intelliService!!.deleteReminder(reminder)
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

    suspend fun signUp (user : User) : Boolean {
       return intelliService!!.signUp(user)
    }

    suspend fun signIn (user: User) : Boolean{
        this.user = user
        return intelliService!!.signIn(user)
    }

}