package com.simple.moviescomposeapp.ui.moviesList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.simple.moviescomposeapp.ui.CustomTopAppBar

@Composable
fun MoviesListScreen() {
    val viewModel: MoviesListViewModel = hiltViewModel()
    val movies = viewModel.topRatedMoviesState.value

    Column {
        CustomTopAppBar()

        LazyColumn(
            modifier = Modifier
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(movies) { movie ->
                MovieCard(movie)
            }
        }
    }

}

@Composable
@Preview
fun MoviesListScreenPreview(){
    MoviesListScreen()
}