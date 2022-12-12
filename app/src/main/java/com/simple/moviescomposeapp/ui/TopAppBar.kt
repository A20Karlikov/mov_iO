package com.simple.moviescomposeapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simple.moviescomposeapp.R
import com.simple.moviescomposeapp.ui.theme.MoviesComposeAppTheme

@Composable
fun CustomTopAppBar() {
    TopAppBar(
        title =
        {
            Row(
                verticalAlignment = Alignment.CenterVertically ,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 12.dp)
            ) {
                Text(
                    stringResource(R.string.movio_title),
                    modifier = Modifier
                        .border(
                            BorderStroke(1.dp, Color.White),
                            shape = CircleShape
                        )
                        .padding(8.dp),
                    textAlign = TextAlign.Center
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = Color.Black,
        contentColor = Color.White
    )

}

@Preview(showBackground = true)
@Composable
fun CustomTopAppBarPreview() {
    MoviesComposeAppTheme {
        CustomTopAppBar()
    }
}