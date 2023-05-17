package com.mom.intelli.data.weather

data class WeatherApiResponse (
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main
)
