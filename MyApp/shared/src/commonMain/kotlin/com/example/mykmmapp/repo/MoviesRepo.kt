package com.example.mykmmapp.repo


import com.example.mykmmapp.MovieResponse
import com.example.mykmmapp.httpClient
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.request.*


class MoviesRepo {
    suspend fun getMoviesList():MovieResponse {
        return getMovies()
    }
}
