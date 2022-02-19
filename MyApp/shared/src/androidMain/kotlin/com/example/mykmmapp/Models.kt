package com.example.mykmmapp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class MovieResponse(
    val page:Int,
val movies:List<MoviesInfo>
)
@Serializable
data class MoviesInfo(
    @SerialName("id")
    val critics_pick:String,

    val display_title: String,
    val mpaa_rating:String,
val imageURL:String
)