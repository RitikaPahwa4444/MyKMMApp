package com.example.mykmmapp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val movies: List<MoviesInfo>
)

@Serializable
data class MoviesInfo(
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String,
    @SerialName("poster_path")
    val imageUrl: String,
    @SerialName("vote_average")
    val rating: Float,
)