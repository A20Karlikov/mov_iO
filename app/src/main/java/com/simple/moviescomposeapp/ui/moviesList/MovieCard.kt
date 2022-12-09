package com.simple.moviescomposeapp.ui.moviesList

import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.simple.moviescomposeapp.data.MoviesRepository
import com.simple.moviescomposeapp.data.models.Movie
import kotlinx.coroutines.coroutineScope

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieCard(movie: Movie) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = rememberImagePainter(movie.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(if (isExpanded) 0.8F else 1.6F, false),
                contentScale = ContentScale.Crop
            )
            Surface(
                color = Color.Black.copy(alpha = 0.7F)
            ) {
                Column(
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.h5,
                        color = Color.White,
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
                    )
                    movie.overview?.run {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = this@run,
                                style = MaterialTheme.typography.subtitle2,
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                                    .weight(5F),
                                maxLines = if (isExpanded) 10 else 2,
                                overflow = TextOverflow.Ellipsis,
                                color = Color.White.copy(alpha = 0.7F)
                            )
                            Icon(
                                imageVector = if (isExpanded)
                                    Icons.Default.KeyboardArrowUp
                                else
                                    Icons.Default.KeyboardArrowDown,
                                contentDescription = "Expand/Collapse icon",
                                tint = Color.White.copy(alpha = 0.7F),
                                modifier = Modifier
                                    .weight(1F)
                                    .padding(horizontal = 8.dp)
                                    .align(
                                        if (isExpanded)
                                            Alignment.Bottom
                                        else
                                            Alignment.CenterVertically
                                    )
                                    .clickable { isExpanded = !isExpanded }
                            )
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RatingBar(
                            rating = if (movie.voteAverage != null) (movie.voteAverage / 2).toFloat() else 0F,
                            modifier = Modifier
                                .padding(8.dp)
                                .width(120.dp)
                                .height(24.dp)
                        )
                        Text(
                            text = if (movie.voteAverage != null) "(${movie.voteAverage})" else "---",
                            color = Color.White.copy(alpha = 0.7F),
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun MovieCardPreview() {
    MovieCard(Movie(
        1,
        "The Shawshank redemption",
        "https://flxt.tmsimg.com/assets/p15987_p_v8_ai.jpg",
        overview = "The Shawshank Redemption is a 1994 American drama film written and directed" +
                " by Frank Darabont, based on the 1982 Stephen King novella Rita Hayworth and" +
                " Shawshank Redemption. It tells the story of banker Andy Dufresne (Tim Robbins)," +
                " who is sentenced to life in Shawshank State Penitentiary" +
                " for the murders of his wife and her lover, despite his claims of innocence. ",
        voteAverage = 9.2,
        releaseDate = null
    ))
}