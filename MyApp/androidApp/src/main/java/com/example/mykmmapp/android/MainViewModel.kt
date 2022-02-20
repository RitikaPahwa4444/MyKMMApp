package com.example.mykmmapp.android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mykmmapp.MoviesInfo
import com.example.mykmmapp.Usecase.MoviesUsecase
import com.example.mykmmapp.repo.MoviesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    val moviesUsecase: MoviesUsecase = MoviesUsecase()

    private val _movies = MutableLiveData<List<MoviesInfo>>()
    val movies: LiveData<List<MoviesInfo>> = _movies

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = moviesUsecase.getMoviesList();
            withContext(Dispatchers.Main) {
                _movies.value = result.movies
            }
        }
    }
}