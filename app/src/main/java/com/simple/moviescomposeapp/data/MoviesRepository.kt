package com.simple.moviescomposeapp.data

import com.simple.moviescomposeapp.data.models.*
import com.simple.moviescomposeapp.network.ConstantNetwork.IMAGE_URL_START_PART
import com.simple.moviescomposeapp.network.ConstantNetwork.NO_IMAGE_URL
import com.simple.moviescomposeapp.network.RetrofitInstance

object MoviesRepository {

    private val moviesByYear: MutableMap<Int, List<Movie>> = mutableMapOf()

    suspend fun getMovies(): List<Movie> = RetrofitInstance.api.getMovies().toDomain()

    suspend fun getMovieById(id: Int): Movie = RetrofitInstance.api.getMovieById(id).toDomain()

    suspend fun searchMovie(query: String): List<Movie> =
        RetrofitInstance.api.searchMovie(query).toDomain()

    suspend fun latestMovies(query: Unit, year: Int): List<Movie> {
        return if (moviesByYear.containsKey(year)) {
            moviesByYear.getValue(year)
        } else {
            val movies = RetrofitInstance.api.latestMovies(year = year).toDomain()
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
    genres = this.genres.map { genre -> Genre(genre.id, genre.name) },
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
            genres = it.genres.map { genre -> Genre(genre, Genres.values().first { genre == it.id }.value) } ,
            voteAverage = it.voteAverage,
            overview = it.overview
        )
    }
