package com.mom.intelli.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mom.intelli.data.eshop.Device

@Database(entities = [Device::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun deviceDao(): DeviceDao
}
