package com.mom.intelli.data.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "fullname") val fullname : String?,
    @ColumnInfo(name = "email")    val email    : String?,
    @ColumnInfo(name = "password") var password : String?,
    @ColumnInfo(name = "salt")     var salt     : String?,
    @ColumnInfo(name="remember_me") val rememberMe : Boolean = false
) {

}