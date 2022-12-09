package com.simple.moviescomposeapp.domain

import com.simple.moviescomposeapp.data.MoviesRepository
import com.simple.moviescomposeapp.data.models.Movie

class GetMoviesUseCase(private val repository: MoviesRepository = MoviesRepository):
    UseCase<Unit, DataResult<List<Movie>>> {

    override suspend fun execute(param: Unit): DataResult<List<Movie>> = asDataResult {
        repository.getMovies()
    }
}