package com.mom.intelli.util.serviceUtil

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.AlarmClock
import android.provider.Settings

class IntentAppsUtil {
    fun openIntent(context: Context, action : String){
        var intent : Intent? = null
        when(action){
            "music" -> {
                intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_APP_MUSIC)
            }
            "settings" -> {
                intent = Intent(Settings.ACTION_SETTINGS)
            }
            "phoneCalls" -> {
                intent = Intent(Intent.ACTION_DIAL)
            }
            "message" -> {
                intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_APP_MESSAGING)
            }
            "contact" -> {
                intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("content://contacts/people")
            }
            "alarm" -> {
                intent  = Intent(AlarmClock.ACTION_SET_ALARM)
            }
        }
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)

    }

    fun openMaps(context: Context) {
        val weatherUtil = WeatherUtil(context)
        val data = weatherUtil.getUserLocation()
        val latitude = data[0]
        val longitude = data[1]

        // Create an intent with the Google Maps app and the location data
        val intentUri = Uri.parse("geo:$latitude,$longitude")
        val mapIntent = Intent(Intent.ACTION_VIEW, intentUri)
        mapIntent.setPackage("com.google.android.apps.maps")

        // Check if the Google Maps app is installed
        val packageManager = context.packageManager
        val isIntentSafe = mapIntent.resolveActivity(packageManager) != null

        // Start the Google Maps app if it is installed, otherwise open the website
        if (isIntentSafe) {
            context.startActivity(mapIntent)
        } else {
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/place/$latitude,$longitude")
            )
            context.startActivity(webIntent)
        }
}

}