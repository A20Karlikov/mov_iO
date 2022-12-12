package com.simple.moviescomposeapp.ui.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.simple.moviescomposeapp.R
import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.ui.CustomTopAppBar
import com.simple.moviescomposeapp.ui.theme.MoviesComposeAppTheme

@OptIn(ExperimentalUnitApi::class)
@Composable
fun HomeScreen() {
    val viewModel: HomeScreenViewModel = viewModel()

    val topRatedMovies = viewModel.topRatedMoviesState.value
    val latestMovies = viewModel.latestMoviesState.value
    val upcomingEvents = emptyList<Movie>()
    //TODO: Upcoming events ->
    // After having a local db where we save past events/movies (we have watched) ,
    // make a call to the db to get if there are upcoming else show sad face :(

    Column {
        CustomTopAppBar()
        LazyColumn {
            items(1) {
                Column(Modifier.padding(12.dp)) {
                    Text(
                        text = stringResource(R.string.upcoming_events_header),
                        modifier = Modifier
                            .wrapContentSize(align = Alignment.CenterStart)
                            .background(Color.Black, CircleShape)
                            .border(1.dp, Color.Black, CircleShape)
                            .padding(start = 12.dp, end = 12.dp),
                        style = MaterialTheme.typography.subtitle1,
                        fontSize = TextUnit(24f, TextUnitType.Sp),
                        color = Color.White
                    )

                    LazyRow {
                        // if no upcoming events -> TODO()
                        if (topRatedMovies.isEmpty()) items(topRatedMovies) { movie ->
                            MovieCardHorizontal(
                                movie
                            )
                        }
                        else items(topRatedMovies) { movie -> MovieCardHorizontal(movie) }
                    }

                    Text(
                        text = stringResource(R.string.latest_movies_header),
                        modifier = Modifier
                            .wrapContentSize(align = Alignment.CenterStart)
                            .background(Color.Black, CircleShape)
                            .border(1.dp, Color.Black, CircleShape)
                            .padding(start = 12.dp, end = 12.dp),
                        style = MaterialTheme.typography.subtitle1,
                        fontSize = TextUnit(24f, TextUnitType.Sp),
                        color = Color.White
                    )
                    LazyRow {
                        items(latestMovies) { movie -> MovieCardHorizontal(movie) }
                    }

                    Text(
                        text = stringResource(R.string.top_rated_movies_header),
                        modifier = Modifier
                            .wrapContentSize(align = Alignment.CenterStart)
                            .background(Color.Black, CircleShape)
                            .border(1.dp, Color.Black, CircleShape)
                            .padding(start = 12.dp, end = 12.dp),
                        style = MaterialTheme.typography.subtitle1,
                        fontSize = TextUnit(24f, TextUnitType.Sp),
                        color = Color.White
                    )

                    LazyRow {
                        items(topRatedMovies) { movie -> MovieCardHorizontal(movie) }
                    }
                }
            }
        }
        // TODO: Add Bottom Navigation Here...
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MoviesComposeAppTheme {
        HomeScreen()
    }
}