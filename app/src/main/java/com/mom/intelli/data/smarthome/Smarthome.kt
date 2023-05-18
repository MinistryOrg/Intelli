package com.mom.intelli.data.smarthome

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Smarthome(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "name") val name : String?,
    @ColumnInfo(name = "image") val image: Int?
)