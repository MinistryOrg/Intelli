package com.mom.intelli.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mom.intelli.data.eshop.Device

@Dao
interface DeviceDao {
    @Query("SELECT * FROM device")
    fun getAll(): List<Device>

    @Insert
    fun insertAll(vararg device: Device)

    @Delete
    fun delete(device: Device)

}