package com.mom.intelli.data.eshop

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DeviceListConverter {
    @TypeConverter
    fun fromDeviceList(deviceList: List<Device>): String {
        val gson = Gson()
        return gson.toJson(deviceList)
    }

    @TypeConverter
    fun toDeviceList(deviceListString: String): List<Device> {
        val gson = Gson()
        val type = object : TypeToken<List<Device>>() {}.type
        return gson.fromJson(deviceListString, type)
    }
}
