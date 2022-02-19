package com.example.mykmmapp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class BookResponse(
val books:List<BooksInfo>
)
@Serializable
data class BooksInfo(


    val display_name: String,
    val published_date_description:String,
    val updated:String
)