package com.simple.moviescomposeapp.ui.movieDetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.domain.DataResult
import com.simple.moviescomposeapp.domain.GetMovieByIdUseCase
import kotlinx.coroutines.launch

class MovieDetailsViewModel : ViewModel() {

    private val useCase = GetMovieByIdUseCase()
    val currentMovie: MutableState<Movie?> = mutableStateOf(null)

    init {
        getMovieById(155) // <--- TODO
    }

    private fun getMovieById(id: Int) {
        viewModelScope.launch {
            when (val result = useCase.execute(id)) {
                is DataResult.Success -> currentMovie.value = result.value
                is DataResult.Failure -> Unit //TODO
            }
        }
    }
}