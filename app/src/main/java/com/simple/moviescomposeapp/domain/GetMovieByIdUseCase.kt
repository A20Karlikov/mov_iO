package com.simple.moviescomposeapp.domain

import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(private val repository: MovieRepository) :
    UseCase<Int, DataResult<Movie>> {
    override suspend fun execute(id: Int): DataResult<Movie> = asDataResult {
        repository.getMovieById(id).also {
            it.budget = it.budget?.div(1000000)
            it.voteAverage = Math.round(it.voteAverage?.times(10.0) ?: 0.0) / 10.0
        }
    }
}