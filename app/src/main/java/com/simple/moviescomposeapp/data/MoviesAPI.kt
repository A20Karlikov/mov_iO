package com.simple.moviescomposeapp.data

import com.simple.moviescomposeapp.data.models.MovieByIdResources
import com.simple.moviescomposeapp.data.models.MoviesListResources
import com.simple.moviescomposeapp.network.ConstantNetwork.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPI {

    @GET("movie/top_rated?api_key=${API_KEY}")
    suspend fun getMovies(): MoviesListResources

    @GET("movie/{id}?api_key=${API_KEY}&language=en-US")
    suspend fun getMovieById(@Path("id") id: Int): MovieByIdResources

    @GET("search/movie?api_key=${API_KEY}")
    suspend fun searchMovie(@Query("query") query: String): MoviesListResources

    @GET("search/movie?api_key=${API_KEY}")
    suspend fun latestMovies(
        @Query("query") query: String = "%20",
        @Query("primary_release_year") year: Int?
    ): MoviesListResources
}