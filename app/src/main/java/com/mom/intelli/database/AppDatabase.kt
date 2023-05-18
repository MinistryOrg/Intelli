package com.mom.intelli.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mom.intelli.data.eshop.CheckOut
import com.mom.intelli.data.eshop.Device
import com.mom.intelli.data.smarthome.Smarthome

@Database(entities = [Device::class, Smarthome::class, CheckOut::class], version =8 )
abstract class AppDatabase : RoomDatabase() {
    abstract fun deviceDao(): DeviceDao
    abstract fun smarthomeDao(): SmarthomeDao
    abstract fun checkOutDao(): CheckOutDao
}
