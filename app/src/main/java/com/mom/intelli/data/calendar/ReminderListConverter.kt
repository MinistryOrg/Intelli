package com.mom.intelli.data.calendar

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mom.intelli.data.eshop.Device
import java.time.LocalDate

class ReminderListConverter {
    @TypeConverter
    fun fromDate(date: LocalDate): String {
        return date.toString()
    }
    @TypeConverter
    fun toDate(dateString: String): LocalDate {
        return LocalDate.parse(dateString)
    }
}