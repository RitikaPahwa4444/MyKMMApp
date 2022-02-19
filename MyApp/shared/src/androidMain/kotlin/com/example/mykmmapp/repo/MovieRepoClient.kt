package com.example.mykmmapp.repo

import com.example.mykmmapp.MovieResponse
import com.example.mykmmapp.httpClient
import io.ktor.client.request.*


const val requestURL="https://api.nytimes.com/svc/movies/v2/reviews/search.json?query=godfather&api-key=SE33YnSuLuxbtkjsjlnbGv0hSTzp6CZJ"
suspend fun getBooks(): MovieResponse {
    return httpClient.get(requestURL)
}