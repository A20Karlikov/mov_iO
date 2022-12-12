package com.simple.moviescomposeapp.ui.movieDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation.Vertical
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.simple.moviescomposeapp.data.models.toValuesList
import com.simple.moviescomposeapp.ui.theme.Shapes
import java.text.SimpleDateFormat

@Composable
fun MovieDetailsScreen() {
    val viewModel: MovieDetailsViewModel = viewModel()
    val currentMovie = viewModel.currentMovie.value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Surface(elevation = 4.dp) {
            Card(shape = Shapes.large) {
                Image(
                    painter = rememberAsyncImagePainter(currentMovie?.imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.3F, false),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Text(
            text = currentMovie?.title ?: stringResource(string.no_title_message),
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                SingleInfoElement(
                    elementName = stringResource(string.movie_detail_release_date),
                    value = currentMovie?.releaseDate ?: stringResource(string.no_info_provided),
                    drawableId = R.drawable.ic_release_date
                )
                Spacer(modifier = Modifier.padding(8.dp))
                SingleInfoElement(
                    elementName = stringResource(string.movie_detail_rating),
                    value = currentMovie?.voteAverage.toString(),
                    drawableId = R.drawable.ic_rating
                )
            }
            Column {
                SingleInfoElement(
                    elementName = stringResource(string.movie_detail_budget),
                    value = "${currentMovie?.budget.toString()}M",
                    drawableId = R.drawable.ic_budget
                )
                Spacer(modifier = Modifier.padding(8.dp))
                SingleInfoElement(
                    stringResource(string.movie_detail_duration),
                    value = "${currentMovie?.duration.toString()} min",
                    drawableId = R.drawable.ic_duration
                )
            }
        }
        currentMovie?.genres?.run {
            Text(
                text = this.toValuesList().joinToString(", "),
                modifier = Modifier
                    .padding(top = 16.dp, start = 12.dp, end = 12.dp, bottom = 4.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                style = MaterialTheme.typography.subtitle2
            )
        }
        currentMovie?.overview?.run {
            Text(
                text = this@run,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth(),
                style = MaterialTheme.typography.subtitle1,
                fontSize = 18.sp,
            )
        }
        Button(modifier = Modifier
            .fillMaxWidth(0.35F)
            .padding(vertical = 16.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "SUGGEST")
        }
    }

}

@Composable
@Preview
fun MovieDetailsScreenPreview() {
    MovieDetailsScreen()
}