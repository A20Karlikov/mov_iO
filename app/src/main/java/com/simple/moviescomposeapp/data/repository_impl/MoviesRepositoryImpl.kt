package com.simple.moviescomposeapp.data.repository_impl

import com.simple.moviescomposeapp.data.MoviesAPI
import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.data.models.MovieByIdResources
import com.simple.moviescomposeapp.data.models.MoviesListResources
import com.simple.moviescomposeapp.domain.repository.MovieRepository
import com.simple.moviescomposeapp.network.ConstantNetwork.IMAGE_URL_START_PART
import com.simple.moviescomposeapp.network.ConstantNetwork.NO_IMAGE_URL
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val api: MoviesAPI) : MovieRepository {

    private val moviesByYear: MutableMap<Int, List<Movie>> = mutableMapOf()

    override suspend fun getMovies(): List<Movie> = api.getMovies().toDomain()

    override suspend fun getMovieById(id: Int): Movie = api.getMovieById(id).toDomain()

   override suspend fun searchMovie(query: String): List<Movie> =
        api.searchMovie(query).toDomain()

   override suspend fun latestMovies(query: Unit, year: Int): List<Movie> {
        return if (moviesByYear.containsKey(year)) {
            moviesByYear.getValue(year)
        } else {
            val movies = api.latestMovies(year = year).toDomain()
            moviesByYear.put(year, movies)
            movies
        }
    }
}

private fun MovieByIdResources.toDomain(): Movie = Movie(
    id = this.id,
    title = this.title,
    imageUrl = this.posterPath?.run { "${IMAGE_URL_START_PART}$this" }
        ?: NO_IMAGE_URL,
    releaseDate = this.releaseDate,
    genres = this.genres.map { genre -> Movie.Genre(genre.id, genre.name) },
    voteAverage = this.voteAverage,
    overview = this.overview
)


private fun MoviesListResources.toDomain(): List<Movie> =
    this.moviesResources.map {
        Movie(
            id = it.id,
            title = it.title,
            imageUrl = it.posterPath?.run { "${IMAGE_URL_START_PART}$this" }
                ?: NO_IMAGE_URL,
            releaseDate = it.releaseDate,
            voteAverage = it.voteAverage,
            overview = it.overview
        )
    }
