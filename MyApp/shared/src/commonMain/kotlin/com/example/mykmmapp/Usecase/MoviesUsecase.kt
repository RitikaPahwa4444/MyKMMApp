package com.example.mykmmapp.Usecase

import com.example.mykmmapp.MovieResponse

expect  class MoviesUsecase{

  suspend fun getMoviesList(): MovieResponse
}