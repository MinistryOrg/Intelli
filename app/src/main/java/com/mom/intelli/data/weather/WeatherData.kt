package com.mom.intelli.data.weather

//Το εικονίδια που είπαμε θα αλλάζουν με το id , την θερμοκρασία, it feels like και την περιοχή /πόλη θέλω μόν
data class WeatherData(
    val iconID: String,
    val temp: Int,
    val feelsLike: Int,
    val location: String,
<<<<<<< Updated upstream
    val description : String
=======
    val description: String
>>>>>>> Stashed changes
)