package com.mom.intelli.data.location

data class Location(
    val place_id: Int,
    val licence: String, // Modify the type to String
    val lat: String,
    val lon: String,
    val display_name: String
)