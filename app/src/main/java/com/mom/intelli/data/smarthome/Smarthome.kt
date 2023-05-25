package com.mom.intelli.data.smarthome

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mom.intelli.data.user.User

@Entity

data class Smarthome(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "name") val name : String?,
    @ColumnInfo(name = "image") val image: Int?,
//    @ColumnInfo(name = "user") val user : User
)
