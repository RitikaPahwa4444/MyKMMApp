package com.example.mykmmapp.repo


import com.example.mykmmapp.MovieResponse
import com.example.mykmmapp.httpClient
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.request.*
import kotlin.text.get

class BooksRepo {
    suspend fun getBooksList():MovieResponse {
        return getBooks()
    }
}
