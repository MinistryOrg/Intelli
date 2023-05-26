package com.mom.intelli.service

import android.content.Context
import androidx.room.Room
import com.mom.intelli.data.calendar.Reminder
import com.mom.intelli.data.eshop.CheckOut
import com.mom.intelli.data.eshop.Device
import com.mom.intelli.data.news.NewsApiResponse
import com.mom.intelli.data.smarthome.Smarthome
import com.mom.intelli.data.user.User
import com.mom.intelli.data.weather.WeatherData
import com.mom.intelli.database.AppDatabase
import com.mom.intelli.util.serviceUtil.EmailUtil
import com.mom.intelli.util.serviceUtil.IntentAppsUtil
import com.mom.intelli.util.serviceUtil.NewsUtil
import com.mom.intelli.util.serviceUtil.WeatherUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.security.MessageDigest
import java.security.SecureRandom
import java.time.LocalDate
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec


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
    private val smarthomeDao  = db.smarthomeDao()
    private val checkOutDao = db.checkOutDao()
    private val reminderDao  = db.reminderDao()
    private val userDao = db.userDao()

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

    fun openNewsLink(link: String, action: String) {
        newsUtil.openNewsLink(link,context, action)
    }

    suspend fun insertDeviceToDatabase(device: Device){
        return withContext(Dispatchers.IO) {
            deviceDao.insertAll(device)
        }
    }

    suspend fun deleteDevice(devices: List<Device>) {
        return withContext(Dispatchers.IO) {
            devices.forEach{ value ->
                deviceDao.delete(value)
            }
        }

    }

    suspend fun getCartDevices() : List<Device>{
        return withContext(Dispatchers.IO) {
            deviceDao.getAll()
        }
    }

    suspend fun insertSmarthomeToDatabase(smarthome: Smarthome){
        return withContext(Dispatchers.IO) {
            smarthomeDao.insertAll(smarthome)
        }
    }

    suspend fun getSmarthome() : List<Smarthome>{
        return withContext(Dispatchers.IO) {
            smarthomeDao.getAll()
        }
    }

    suspend fun insertCheckOut(checkOut : CheckOut){
        return withContext(Dispatchers.IO) {
            checkOutDao.insertAll(checkOut)
        }
    }

    suspend fun getCheckOut() : List<CheckOut>{
        return withContext(Dispatchers.IO) {
            checkOutDao.getAll()
        }
    }

    suspend fun insertReminder(reminder: Reminder){
        return withContext(Dispatchers.IO) {
            reminderDao.insertAll(reminder)
        }
    }

    suspend fun deleteReminder(reminder: Reminder){
        return withContext(Dispatchers.IO) {
            reminderDao.delete(reminder)
        }
    }

    suspend fun getReminders() : List<Reminder>{
        return withContext(Dispatchers.IO) {
            reminderDao.getAll()
        }
    }

    suspend fun getRemindersByDate(date : LocalDate) : List<Reminder>{
        return withContext(Dispatchers.IO) {
            reminderDao.getByDate(date)
        }
    }
    suspend fun getNews(category: String): NewsApiResponse {
        return newsUtil.getNews(category,context)
    }

    suspend fun getWeather() : WeatherData {
        return weatherUtil.getWeather()
    }

    suspend fun signUp (user : User) : Boolean {
        val userList = userDao.getAll()
        for (i in userList) { // check  if the user already exist
            if(user.email == i.email || user.username == i.username) {
                return false
            }
        }
        val hash = hashPassword(user.password!!)
        user.password = hash[0]
        user.salt = hash[1]
        userDao.insertAll(user)
        return true
    }

    suspend fun signIn (user: User) : Boolean{
        val userList = userDao.getAll()
        for (i in userList) { // if the user exist log in
            val correctPassword  = checkPassword(user.password!!,  user.salt!!, i.password!!)
            if(user.username == i.username && correctPassword){
                return true
            }
        }
        return false
    }

    private fun hashPassword(password: String): List<String> {
        // random value used for hashing
        val salt = ByteArray(16).also { SecureRandom().nextBytes(it) }
        // Set up the key specifications for password-based encryption
        val iterations = 10000
        val keyLength = 256
        val spec = PBEKeySpec(password.toCharArray(), salt, iterations, keyLength)
        val secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
        // Generate the encrypted password
        return listOf(secretKeyFactory.generateSecret(spec).encoded.toString(), salt.toString()) // idk if works with string
    }

    private fun checkPassword(password: String, salt : String, hashedPassword: String): Boolean {
        // Set up the key specifications for password-based encryption
        val iterations = 10000
        val keyLength = 256
        val spec = PBEKeySpec(password.toCharArray(), salt.toByteArray(), iterations, keyLength)
        val secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
        // Generate the encrypted password using the entered password and retrieved salt
        val hashedEnteredPassword = secretKeyFactory.generateSecret(spec).encoded

        return MessageDigest.isEqual( // compare the password
            hashedEnteredPassword,
            hashedPassword.toByteArray()
        ) // and returns true or false
    }

}