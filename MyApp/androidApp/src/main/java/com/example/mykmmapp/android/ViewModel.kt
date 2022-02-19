package com.example.mykmmapp.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mykmmapp.BooksInfo
import com.example.mykmmapp.repo.BooksRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel: ViewModel() {
    private val booksRepo:BooksRepo= BooksRepo()
    private val _books=MutableLiveData<List<BooksInfo>>()
    val book:LiveData<List<BooksInfo>> =_books
    init{
        getBooks()
    }
    private fun getBooks(){
        viewModelScope.launch (Dispatchers.IO){
val result=booksRepo.getBooksList()
            withContext(Dispatchers.Main){
                _books.value=result.books
            }
        }
    }
}