package com.mom.intelli.data

data class NewsApiResponse(
    val status : String,
    val totalResults : Int,
    val results : List<Results>
    )