package com.simple.moviescomposeapp.data.models

data class Movie(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val releaseDate: String?,
    val genres: List<Genre>,
    val voteAverage: Double?,
    val overview: String?
)

data class Genre(
    val id: Int,
    val name: String
)
