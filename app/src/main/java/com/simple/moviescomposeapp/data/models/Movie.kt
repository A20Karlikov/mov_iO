package com.simple.moviescomposeapp.data.models

data class Movie(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val releaseDate: String? = null,
    val genres: List<Genre>,
    var voteAverage: Double?,
    val overview: String?,
    var budget: Int? = null,
    val duration: Int? = null
)

data class Genre(
    val id: Int,
    val name: String
)
