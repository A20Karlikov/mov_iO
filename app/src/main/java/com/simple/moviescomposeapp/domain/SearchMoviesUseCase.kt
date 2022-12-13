package com.simple.moviescomposeapp.domain

import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.domain.repository.MovieRepository
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(private val repository: MovieRepository) :
    UseCase<String, DataResult<List<Movie>>> {

    override suspend fun execute(query: String): DataResult<List<Movie>> = asDataResult {
        repository.searchMovie(query)
    }
}