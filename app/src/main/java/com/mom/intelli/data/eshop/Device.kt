package com.mom.intelli.data.eshop

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Device(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name : String?,
    @ColumnInfo(name = "image") val image: Int?
)
