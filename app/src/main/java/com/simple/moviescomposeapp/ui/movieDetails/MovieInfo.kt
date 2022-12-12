package com.simple.moviescomposeapp.ui.movieDetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simple.moviescomposeapp.R.drawable
import com.simple.moviescomposeapp.R.string
import com.simple.moviescomposeapp.data.models.Movie
import com.simple.moviescomposeapp.data.models.toValuesList

@Composable
fun MovieInfo(movie: Movie) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Text(
            text = movie.title,
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
                    value = movie.releaseDate ?: stringResource(string.no_info_provided),
                    drawableId = drawable.ic_release_date
                )
                Spacer(modifier = Modifier.padding(8.dp))
                SingleInfoElement(
                    elementName = stringResource(string.movie_detail_rating),
                    value = movie.voteAverage.toString(),
                    drawableId = drawable.ic_rating
                )
            }
            Column {
                SingleInfoElement(
                    elementName = stringResource(string.movie_detail_budget),
                    value = "${movie.budget.toString()}M",
                    drawableId = drawable.ic_budget
                )
                Spacer(modifier = Modifier.padding(8.dp))
                SingleInfoElement(
                    stringResource(string.movie_detail_duration),
                    value = "${movie.duration.toString()} min",
                    drawableId = drawable.ic_duration
                )
            }
        }
        Text(
            text = movie.genres.toValuesList().joinToString(", "),
            modifier = Modifier
                .padding(top = 16.dp, start = 12.dp, end = 12.dp, bottom = 4.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            style = MaterialTheme.typography.subtitle2
        )
        movie.overview?.run {
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
            Text(text = stringResource(string.suggest_movie_btn))
        }
    }
}