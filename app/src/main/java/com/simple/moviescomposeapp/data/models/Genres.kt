package com.simple.moviescomposeapp.data.models

enum class Genres(val value: String, val id: Int) {
    ACTION("Action", 28),
    ADVENTURE("Adventure", 12),
    ANIMATION("Animation", 16),
    COMEDY("Comedy", 35),
    CRIME("Crime", 80),
    DOCUMENTARY("Documentary", 99),
    DRAMA("Drama",18),
    FAMILY("Family", 10751),
    FANTASY("Fantasy", 14),
    HISTORY("History", 36),
    HORROR("Horror",27),
    MUSIC("Music", 10402),
    MYSTERY("Mystery",9648),
    ROMANCE("Romance",10749),
    SCIENCE_FICTION("Science Fiction",878),
    TV_MOVIE("TV Movie", 10770),
    THRILLER("Thriller",53),
    WAR("War",10752),
    WESTERN("Western", 37)
}

fun List<Genre>.toValuesList(): List<String> =
    this.map { genre -> genre.name }
