package com.mom.intelli.data.calendar

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.mom.intelli.data.eshop.DeviceListConverter
import java.time.LocalDate
import java.time.LocalTime


@Entity
@TypeConverters(ReminderListConverter::class)
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name="date") val date: LocalDate,
    @ColumnInfo(name="title") val title: String,
    @ColumnInfo(name = "description") val description: String
)