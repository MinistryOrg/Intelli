package com.mom.intelli.data.calendar

import kotlinx.datetime.LocalDate

data class CalendarDay(
    val date: java.time.LocalDate,
    val isSelected: Boolean = false,
    val isToday: Boolean = false,
    val isDisabled: Boolean = false,
    val reminders: List<Reminder> = emptyList()
)