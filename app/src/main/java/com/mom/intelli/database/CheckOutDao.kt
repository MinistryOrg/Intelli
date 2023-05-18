package com.mom.intelli.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mom.intelli.data.eshop.CheckOut

@Dao
interface CheckOutDao {
    @Query("SELECT * FROM checkout")
    fun getAll(): List<CheckOut>

    @Insert
    fun insertAll(vararg checkOut: CheckOut)

    @Delete
    fun delete(checkOut: CheckOut)
}