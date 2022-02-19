package com.example.mykmmapp.repo

import com.example.mykmmapp.BookResponse
import com.example.mykmmapp.httpClient
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.request.*
import kotlin.text.get

class BooksRepo {
    suspend fun getBooksList():BookResponse {
        return getBooks()
    }
}
const val requestURL="https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=SE33YnSuLuxbtkjsjlnbGv0hSTzp6CZJ"
suspend fun getBooks(): BookResponse {
   return httpClient.get(requestURL)
}