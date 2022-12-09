package com.simple.moviescomposeapp.domain

import com.simple.moviescomposeapp.data.MoviesRepository
import com.simple.moviescomposeapp.data.models.Movie
import java.util.*

class GetLatestMoviesUseCase(private val repository: MoviesRepository = MoviesRepository) :
    UseCase<Unit, DataResult<List<Movie>>> {

    override suspend fun execute(param: Unit): DataResult<List<Movie>> = asDataResult {
        repository.latestMovies(Unit, Calendar.getInstance().get(Calendar.YEAR))
    }

}