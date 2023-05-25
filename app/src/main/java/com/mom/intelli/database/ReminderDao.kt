package com.mom.intelli.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mom.intelli.data.calendar.Reminder
import com.mom.intelli.data.user.User
import java.time.LocalDate

@Dao
interface ReminderDao {
    @Query("SELECT * FROM reminder")
    fun getAll(): List<Reminder>

    @Query("SELECT * FROM reminder WHERE date = :selectedDate")
    fun getByDate(selectedDate: LocalDate): List<Reminder>

    @Query("SELECT * FROM reminder WHERE date = :selectedDate and user = :user")
    fun getByDateAndUser(selectedDate: LocalDate, user: User): List<Reminder>

    @Insert
    fun insertAll(vararg reminder: Reminder)

    @Delete
    fun delete(reminder: Reminder)
}