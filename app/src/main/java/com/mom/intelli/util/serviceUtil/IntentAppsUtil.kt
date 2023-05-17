package com.mom.intelli.util.serviceUtil

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.Uri
import android.provider.AlarmClock
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

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
                intent  = Intent(AlarmClock.ACTION_SET_ALARM);
            }
        }
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)

    }

    fun openMaps(context: Context) {
        val activity = context as Activity
        // Default location if the user doesn't access (cyprus hehe)
        var latitude = 35.1264
        var longitude = 33.4299
        // can be anything is a code to request so yes
        val PERMISSIONS_REQUEST_LOCATION = 100
        // Request location permission if not already granted
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSIONS_REQUEST_LOCATION
            )
        }

        // Get the location manager
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        // Check if location is enabled
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            // Get the last known location
            val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

            if (location != null) {
                // add the location to the values
                latitude = location.latitude
                longitude = location.longitude
            }

        }

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