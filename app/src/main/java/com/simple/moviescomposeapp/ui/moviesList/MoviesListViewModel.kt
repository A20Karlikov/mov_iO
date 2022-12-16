package com.simple.moviescomposeapp.ui.moviesList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.domain.DataResult
import com.simple.moviescomposeapp.domain.GetLatestMoviesUseCase
import com.simple.moviescomposeapp.domain.GetTopRatedMoviesUseCase
import com.simple.moviescomposeapp.domain.SearchMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.schedule

const val SEARCH_MIN_CHARS = 2

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val getLatestMoviesUseCase: GetLatestMoviesUseCase,
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {
    private val _moviesState: MutableState<List<Movie>> = mutableStateOf(emptyList())
    val moviesState: State<List<Movie>> = _moviesState

    private val _searchTextState: MutableState<String> = mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    private var timer = Timer()

    init {
        getLatestMovies()
    }

    private fun getLatestMovies() {
        viewModelScope.launch {
            when (val result = getLatestMoviesUseCase.execute(Unit)) {
                is DataResult.Success ->
                    _moviesState.value = result.value
                is DataResult.Failure -> Unit // TODO
            }
        }
    }

    fun searchMovies() {
        viewModelScope.launch {
            when (val result = searchMoviesUseCase.execute(searchTextState.value)) {
                is DataResult.Success ->
                    _moviesState.value = result.value
                is DataResult.Failure -> Unit //TODO
            }
        }
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
        timer.cancel()
        timer = Timer()
        timer.schedule(1500) {
            if (newValue.trim().length >= SEARCH_MIN_CHARS)
                searchMovies()
            else
                getLatestMovies()
        }
    }
}

