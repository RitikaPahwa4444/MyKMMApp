package com.example.mykmmapp.Usecase

import com.example.mykmmapp.MovieResponse
import com.example.mykmmapp.repo.MoviesRepo

actual class MoviesUsecase {
  actual suspend fun getMoviesList(): MovieResponse {
        return MoviesRepo().getMoviesList()
    }


}