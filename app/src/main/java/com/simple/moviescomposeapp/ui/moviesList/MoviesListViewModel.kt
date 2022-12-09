package com.simple.moviescomposeapp.ui.moviesList

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.domain.DataResult
import com.simple.moviescomposeapp.domain.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(
    private val useCase: GetMoviesUseCase
) : ViewModel() {
    val latestMoviesState: MutableState<List<Movie>> = mutableStateOf(emptyList())

    init {
        getLatestMovies()
    }

    private fun getLatestMovies() {
        viewModelScope.launch {
            when (val result = useCase.execute(Unit)) {
                is DataResult.Success -> {
                    latestMoviesState.value = result.value
                    Log.i("TestsMovie", result.value[0].toString())
                }
                is DataResult.Failure -> {}
            }
        }
    }
}

