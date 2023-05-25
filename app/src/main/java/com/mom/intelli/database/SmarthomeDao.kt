package com.mom.intelli.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.TypeConverters
import com.mom.intelli.data.eshop.DeviceListConverter
import com.mom.intelli.data.smarthome.Smarthome
import com.mom.intelli.data.user.User
import com.mom.intelli.data.user.UserConverter

@Dao
//@TypeConverters(UserConverter::class)
interface SmarthomeDao {
    @Query("SELECT * FROM smarthome")
    fun getAll(): List<Smarthome>

//    @Query("SELECT * FROM smarthome WHERE user = :user")
//    fun getByUser(user: User): List<Smarthome>

    @Insert
    fun insertAll(vararg smarthome: Smarthome)

    @Delete
    fun delete(smarthome: Smarthome)
}