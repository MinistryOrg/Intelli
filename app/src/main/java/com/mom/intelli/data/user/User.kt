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
<<<<<<< HEAD
    @ColumnInfo(name = "salt")     var salt     : String?, // to uncrypt the password
    @ColumnInfo(name = "remember") var remember : Boolean?,
)
=======
    @ColumnInfo(name = "salt")     var salt     : String?,
    @ColumnInfo(name="remember_me") val rememberMe : Boolean = false
) {

}
>>>>>>> fc1c753879f4c9e16c4ed5c869e3296e281800ff
