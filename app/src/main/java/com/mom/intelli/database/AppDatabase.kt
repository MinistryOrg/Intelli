package com.mom.intelli.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mom.intelli.data.calendar.Reminder
import com.mom.intelli.data.calendar.ReminderListConverter
import com.mom.intelli.data.eshop.CheckOut
import com.mom.intelli.data.eshop.Device
import com.mom.intelli.data.smarthome.Smarthome
import com.mom.intelli.data.user.User

@Database(entities = [Device::class, Smarthome::class, CheckOut::class, Reminder::class, User :: class], version = 12 )
@TypeConverters(ReminderListConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun deviceDao(): DeviceDao
    abstract fun smarthomeDao(): SmarthomeDao
    abstract fun checkOutDao(): CheckOutDao
    abstract fun reminderDao() : ReminderDao
    abstract fun userDao() : UserDao
}
