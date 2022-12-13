package com.simple.moviescomposeapp.ui.movieDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.ui.theme.Shapes

@Composable
fun MovieDetailsScreen( currentMovie: Movie?) {

    Column {
        Box(contentAlignment = Alignment.BottomCenter) {
            Card(shape = Shapes.large) {
                Image(
                    painter = rememberAsyncImagePainter(currentMovie?.imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }
            Surface(
                modifier = Modifier
                    .padding(top =16.dp , start = 16.dp , end = 16.dp , bottom = 56.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(6.dp),
                color = MaterialTheme.colors.secondary.copy(alpha = 0.7f)
            ) {
                currentMovie?.run { MovieInfo(movie = currentMovie) }
            }
        }
    }
}