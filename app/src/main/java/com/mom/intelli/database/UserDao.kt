package com.mom.intelli.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mom.intelli.data.eshop.Device
import com.mom.intelli.data.smarthome.Smarthome
import com.mom.intelli.data.user.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert
    fun insertAll(vararg user : User)

    @Delete
    fun delete(user: User)
}