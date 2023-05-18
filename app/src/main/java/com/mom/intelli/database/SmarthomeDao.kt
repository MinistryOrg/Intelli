package com.mom.intelli.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mom.intelli.data.eshop.Device
import com.mom.intelli.data.smarthome.Smarthome

@Dao
interface SmarthomeDao {
    @Query("SELECT * FROM smarthome")
    fun getAll(): List<Smarthome>

    @Insert
    fun insertAll(vararg smarthome: Smarthome)

    @Delete
    fun delete(smarthome: Smarthome)
}