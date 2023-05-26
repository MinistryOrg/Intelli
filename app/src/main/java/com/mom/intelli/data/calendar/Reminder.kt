package com.mom.intelli.data.calendar

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.mom.intelli.data.eshop.DeviceListConverter
import com.mom.intelli.data.user.User
import com.mom.intelli.data.user.UserConverter
import java.time.LocalDate
import java.time.LocalTime


//UserConverter::class
@Entity
@TypeConverters(ReminderListConverter::class)
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name="date") val date: LocalDate,
    @ColumnInfo(name="title") val title: String,
    //    @ColumnInfo(name = "user") val user : User
    @ColumnInfo(name = "description") val description: String
)