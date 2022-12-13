package com.simple.moviescomposeapp.ui.movieDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation.Vertical
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextOverflow.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.simple.moviescomposeapp.R
import com.simple.moviescomposeapp.R.string
import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.data.models.toValuesList
import com.simple.moviescomposeapp.ui.CustomTopAppBar
import com.simple.moviescomposeapp.ui.theme.Shapes
import java.text.SimpleDateFormat

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
                color = MaterialTheme.colors.secondary
            ) {
                currentMovie?.run { MovieInfo(movie = currentMovie) }
            }
        }
    }
}