package com.simple.moviescomposeapp.ui.movieDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.simple.moviescomposeapp.R
import com.simple.moviescomposeapp.R.string
import com.simple.moviescomposeapp.data.models.toValuesList
import com.simple.moviescomposeapp.ui.theme.Shapes
import java.text.SimpleDateFormat

@Composable
fun MovieDetailsScreen() {
    val viewModel: MovieDetailsViewModel = viewModel()
    val currentMovie = viewModel.currentMovie.value

    Column {
        Surface(elevation = 4.dp) {
            Card(shape = Shapes.large) {
                Image(
                    painter = rememberAsyncImagePainter(currentMovie?.imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(2F, false),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Text(
            text = currentMovie?.title ?: stringResource(string.no_title_message),
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                Text(
                    text = currentMovie?.releaseDate ?: stringResource(string.no_info_provided),
                    style = MaterialTheme.typography.subtitle2
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Star, contentDescription = null)
                Text(
                    text = currentMovie?.voteAverage.toString(),
                    style = MaterialTheme.typography.subtitle2
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_budget),
                    contentDescription = null
                )
                Text(
                    text = "${currentMovie?.budget.toString()}M",
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
        currentMovie?.genres?.run {
            Text(text = this.toValuesList().joinToString(", "),
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                style = MaterialTheme.typography.subtitle2
            )
        }
        currentMovie?.overview?.run {
            Text(text = this,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            style = MaterialTheme.typography.subtitle2)
        }
    }

}

@Composable
@Preview
fun MovieDetailsScreenPreview() {
    MovieDetailsScreen()
}