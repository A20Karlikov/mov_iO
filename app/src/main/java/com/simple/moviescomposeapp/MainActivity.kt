package com.simple.moviescomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.simple.moviescomposeapp.ui.movieDetails.MovieDetailsScreen
import com.simple.moviescomposeapp.ui.movieDetails.MovieDetailsViewModel
import com.simple.moviescomposeapp.ui.moviesList.MoviesListScreen
import com.simple.moviescomposeapp.ui.theme.MoviesComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesComposeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    MoviOApp()
                }
            }
        }
    }
}

@Composable
fun MoviOApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "movies_list_screen") {
        composable(route = "movies_list_screen") {
            MoviesListScreen() { movieId ->
                navController.navigate("movie_details_screen/$movieId")
            }
        }
        composable(route = "movie_details_screen/{movie_details_id}",
        arguments = listOf(navArgument("movie_details_id") {
            type = NavType.IntType
        })) {
            val viewModel : MovieDetailsViewModel = hiltViewModel()
            MovieDetailsScreen(currentMovie = viewModel.currentMovie.value)
        }
    }
}
