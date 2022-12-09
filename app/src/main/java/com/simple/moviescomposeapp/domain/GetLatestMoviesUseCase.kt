package com.simple.moviescomposeapp.domain

import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.domain.repository.MovieRepository
import java.util.*
import javax.inject.Inject

class GetLatestMoviesUseCase @Inject constructor(private val repository: MovieRepository) :
    UseCase<Unit, DataResult<List<Movie>>> {

    override suspend fun execute(param: Unit): DataResult<List<Movie>> = asDataResult {
        repository.latestMovies(Unit, Calendar.getInstance().get(Calendar.YEAR))
    }

}