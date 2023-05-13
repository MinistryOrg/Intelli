package com.mom.intelli.service

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.Uri
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntelliService (var context : Context){
    fun openMaps(){
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
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/$latitude,$longitude"))
            context.startActivity(webIntent)
        }
    }

    fun openWeather(){
        val packageManager = context.packageManager
        val packageName = "com.google.android.apps.weather"
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        if (intent != null) {
            context.startActivity(intent)
        } else {
            Toast.makeText(context, "Weather app not found", Toast.LENGTH_SHORT).show()
        }
    }

    fun showEmail(){
        val intent = Intent(Intent.ACTION_MAIN).apply {
            // Add the flags to ensure the email client opens in the email view
            addCategory(Intent.CATEGORY_APP_EMAIL)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
        try {
            context.startActivity(Intent.createChooser(intent, "Send Email"))
        } catch (e: ActivityNotFoundException) {
            // Handle the case where no email app is available to handle the intent
        }
    }

    fun sendEmail(emailAddress : String, emailSubject : String, emailBody : String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress)) // recipients
            putExtra(Intent.EXTRA_SUBJECT, emailSubject)
            putExtra(Intent.EXTRA_TEXT, emailBody)
        }

        try {
            context.startActivity(Intent.createChooser(intent, "Send Email"))
        } catch (e: ActivityNotFoundException) {
            // Handle the case where no email app is available to handle the intent
        }
    }

}