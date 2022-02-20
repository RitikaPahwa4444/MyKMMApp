package com.example.mykmmapp.repo

import com.example.mykmmapp.MovieResponse
import com.example.mykmmapp.httpClient
import io.ktor.client.request.*


const val requestURL="https://api.themoviedb.org/3/movie/550?api_key="
suspend fun getMovies(): MovieResponse {
    return httpClient.get(requestURL)
}