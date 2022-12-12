package com.simple.moviescomposeapp.ui.movieDetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.domain.DataResult
import com.simple.moviescomposeapp.domain.GetMovieByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val useCase: GetMovieByIdUseCase
) : ViewModel() {
    val currentMovie: MutableState<Movie?> = mutableStateOf(null)

    init {
        getMovieById(436270) // <--- TODO
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