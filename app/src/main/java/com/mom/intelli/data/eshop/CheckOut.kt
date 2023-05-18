package com.mom.intelli.data.eshop

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity
@TypeConverters(DeviceListConverter::class)
data class CheckOut(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "fullname") val fullname : String?,
    @ColumnInfo(name = "emailAddress") val address : String?,
    @ColumnInfo(name = "country") val country : String?,
    @ColumnInfo(name = "payment") val payment : String?,
    @ColumnInfo(name = "device") val device: List<Device>

)