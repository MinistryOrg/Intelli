package com.mom.intelli.data.calendar

import java.time.LocalDate
import java.time.LocalTime


data class Reminder(
    val date: LocalDate,
    val title: String,
    val description: String
)