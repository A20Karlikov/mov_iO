package com.simple.moviescomposeapp.ui.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import coil.compose.rememberAsyncImagePainter
import com.simple.moviescomposeapp.data.models.Genre
import com.simple.moviescomposeapp.data.models.Movie

@OptIn(ExperimentalUnitApi::class)
@Composable
fun MovieCardHorizontal(movie: Movie) {

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .padding(10.dp)
            .size(width = 150.dp, height = 250.dp)
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = rememberAsyncImagePainter(movie.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp, 250.dp),
                contentScale = ContentScale.Crop
            )
            Surface(
                color = Color.Black.copy(alpha = 0.7F)
            ) {
                Column(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = movie.title,
                            style = MaterialTheme.typography.h5,
                            color = Color.White,
                            modifier = Modifier
                                .padding(start = 8.dp, end = 8.dp, top = 8.dp),
                            fontSize = 16.sp,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }

}

@Composable
@Preview
fun MovieCardHorizontalPreview() {
    MovieCardHorizontal(
        Movie(
            1,
            "The Shawshank redemption",
            "https://flxt.tmsimg.com/assets/p15987_p_v8_ai.jpg",
            overview = "The Shawshank Redemption is a 1994 American drama film written and directed" +
                    " by Frank Darabont, based on the 1982 Stephen King novella Rita Hayworth and" +
                    " Shawshank Redemption. It tells the story of banker Andy Dufresne (Tim Robbins)," +
                    " who is sentenced to life in Shawshank State Penitentiary" +
                    " for the murders of his wife and her lover, despite his claims of innocence. ",
            voteAverage = 9.2,
            releaseDate = null,
            genres = listOf(Genre(18, "Drama"), Genre(53, "Thriller"))
        )
    )
}