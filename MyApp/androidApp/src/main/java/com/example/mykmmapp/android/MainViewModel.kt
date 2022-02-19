package com.example.mykmmapp.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mykmmapp.MoviesInfo
import com.example.mykmmapp.repo.BooksRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
     val movieRepo:BooksRepo= BooksRepo()
    private val _movies=MutableLiveData<List<MoviesInfo>>()
    val movie:LiveData<List<MoviesInfo>> =_movies
    init{
        getBooks()
    }
    private fun getBooks(){
        viewModelScope.launch (Dispatchers.IO){
val result=movieRepo.getBooksList()
            withContext(Dispatchers.Main){
                _movies.value=result.movies
            }
        }
    }
}