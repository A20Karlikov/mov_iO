package com.simple.moviescomposeapp.ui.homescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.domain.DataResult
import com.simple.moviescomposeapp.domain.GetLatestMoviesUseCase
import com.simple.moviescomposeapp.domain.GetTopRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getLatestMoviesUseCase: GetLatestMoviesUseCase
) : ViewModel() {

    val topRatedMoviesState: MutableState<List<Movie>> = mutableStateOf(emptyList())
    val latestMoviesState: MutableState<List<Movie>> = mutableStateOf(emptyList())


    init {
        getTopRatedMovies()
        getLatestMovies()
    }

    private fun getTopRatedMovies() {
        viewModelScope.launch {
            when (val result = getTopRatedMoviesUseCase.execute(Unit)) {
                is DataResult.Success ->
                    topRatedMoviesState.value = result.value
                is DataResult.Failure -> Unit // TODO
            }
        }
    }

    private fun getLatestMovies(){
        viewModelScope.launch {
            when (val result = getLatestMoviesUseCase.execute(Unit)) {
                is DataResult.Success ->
                    latestMoviesState.value = result.value
                is DataResult.Failure -> Unit // TODO
            }
        }
    }
}