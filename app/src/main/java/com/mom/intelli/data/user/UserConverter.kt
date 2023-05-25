package com.mom.intelli.data.user

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mom.intelli.data.eshop.Device

class UserConverter {
    @TypeConverter
    fun fromUser(user: User): String {
        val gson = Gson()
        return gson.toJson(user)
    }

    @TypeConverter
    fun toUser(userString : String): List<Device> {
        val gson = Gson()
        val type = object : TypeToken<User>() {}.type
        return gson.fromJson(userString, type)
    }
}