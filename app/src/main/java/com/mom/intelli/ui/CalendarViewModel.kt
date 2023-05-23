package com.mom.intelli.ui

import androidx.lifecycle.ViewModel
import com.mom.intelli.data.calendar.Reminder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate

class CalendarViewModel : ViewModel() {
    private val _currentMonth = MutableStateFlow(LocalDate.now().withDayOfMonth(1))
    val currentMonth: StateFlow<LocalDate> = _currentMonth.asStateFlow()

    private val _selectedDate = MutableStateFlow<LocalDate?>(null)
    val selectedDate: StateFlow<LocalDate?> = _selectedDate.asStateFlow()

    private val _reminders = MutableStateFlow<List<Reminder>>(emptyList())
    val reminders: StateFlow<List<Reminder>> = _reminders.asStateFlow()

    fun navigateMonth(direction: Int) {
        _currentMonth.value = _currentMonth.value.plusMonths(direction.toLong())
    }

    fun selectDate(date: LocalDate) {
        _selectedDate.value = date
    }

    fun addReminder(reminder: Reminder) {
        _reminders.value = _reminders.value + reminder
    }
}
