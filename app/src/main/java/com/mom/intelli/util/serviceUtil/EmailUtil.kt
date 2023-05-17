package com.mom.intelli.util.serviceUtil

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri

class EmailUtil {
    fun showEmail(context : Context) {
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

    fun sendEmail(context: Context, emailAddress: String, emailSubject: String, emailBody: String) {
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