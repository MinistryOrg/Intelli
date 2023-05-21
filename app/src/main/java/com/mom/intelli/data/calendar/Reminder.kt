package com.mom.intelli.data.calendar

import kotlinx.datetime.LocalTime

data class Reminder(
    val id: Int,
    val title: String,
    val time: LocalTime
)