package com.simple.moviescomposeapp.ui.moviesList

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.simple.moviescomposeapp.R.string
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import kotlin.math.min

@Composable
fun MoviesListScreen(navigationCallback: (Int) -> Unit) {
    val viewModel: MoviesListViewModel = hiltViewModel()
    val movies = viewModel.moviesState.value

    val focusManager = LocalFocusManager.current
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val defaultTextMessageHeightSize by animateDpAsState(targetValue = if (listState.isScrolled) 0.dp else 18.dp)

    Column() {

        SearchMoviesField(
            text = viewModel.searchTextState.value,
            onTextChange = { viewModel.updateSearchTextState(it) },
            onSearchClicked = { viewModel.searchMovies() },
            focusManager = focusManager
        )

        if (viewModel.searchTextState.value.length < SEARCH_MIN_CHARS)
            Text(
            text = stringResource(string.default_search_message),
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp, top = 8.dp)
                .fillMaxWidth()
                .height(defaultTextMessageHeightSize),
            style = MaterialTheme.typography.subtitle2,
            color = MaterialTheme.colors.primary
        )

        LazyColumn(
            modifier = Modifier
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            state = listState
        ) {
            coroutineScope.launch {
                listState.animateScrollToItem(0)
            }
            items(movies) { movie ->
                MovieCard(movie, navigationCallback)
            }
        }
    }
}

@Composable
@Preview
fun MoviesListScreenPreview() {
    MoviesListScreen {}
}

val LazyListState.isScrolled: Boolean
    get() = firstVisibleItemIndex > 0 || firstVisibleItemScrollOffset > 0