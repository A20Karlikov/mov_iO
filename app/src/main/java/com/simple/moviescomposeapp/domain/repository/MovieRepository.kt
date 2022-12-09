package com.simple.moviescomposeapp.domain.repository

import com.simple.moviescomposeapp.data.models.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>

    suspend fun getMovieById(id: Int): Movie

    suspend fun searchMovie(query: String): List<Movie>

    suspend fun latestMovies(query: Unit, year: Int): List<Movie>
}