package com.mom.intelli.data.eshop

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.mom.intelli.data.user.User
import com.mom.intelli.data.user.UserConverter

@Entity
@TypeConverters(DeviceListConverter::class, UserConverter::class)
data class CheckOut(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "fullname") val fullname : String?,
    @ColumnInfo(name = "emailAddress") val address : String?,
    @ColumnInfo(name = "country") val country : String?,
    @ColumnInfo(name = "payment") val payment : String?,
    //    @ColumnInfo(name = "user") val user : User
    @ColumnInfo(name = "device") val device: List<Device>

)
