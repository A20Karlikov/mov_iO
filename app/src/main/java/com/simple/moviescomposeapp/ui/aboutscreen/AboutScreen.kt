package com.simple.moviescomposeapp.ui.aboutscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simple.moviescomposeapp.R
import com.simple.moviescomposeapp.ui.theme.DarkGreen

@Composable
fun AboutScreen() {

    Surface(modifier = Modifier.fillMaxSize(1f)) {
        val uriHandler = LocalUriHandler.current

        LazyColumn(modifier = Modifier.fillMaxSize().padding(bottom = 65.dp , start = 32.dp , end = 32.dp)) {
            items(1) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.about_screen_header),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h4,
                        textDecoration = TextDecoration.Underline,
                        fontWeight = Bold,
                        modifier = Modifier.padding(12.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_phone_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .padding(bottom = 12.dp)
                    )

                    CardHolderInformation(
                        header = stringResource(R.string.main_functionality_header),
                        information = stringResource(R.string.main_functionality_information)
                    )

                    CardHolderInformation(
                        header = stringResource(R.string.langueage_framework_header),
                        information = stringResource(R.string.langueage_framework_information)
                    )

                    CardHolderInformation(
                        header = stringResource(R.string.github_project_header),
                        information = stringResource(R.string.github_project_uri),
                        uriHandler
                    )

                }
            }
        }
    }

}

@Composable
fun CardHolderInformation(
    header: String,
    information: String,
    uriHandler: UriHandler? = null
) {

    Card(
        shape = CircleShape,
        backgroundColor = Color.Black,
        contentColor = Color.White,
        modifier = Modifier
            .wrapContentSize(align = Alignment.Center)
            .padding(6.dp)
    ) {
        Column {
            Text(
                text = header,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .wrapContentSize(align = Alignment.Center)
                    .padding(6.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
        }
    }

    Card(
        shape = CircleShape,
        backgroundColor = Color.LightGray,
        contentColor = Color.Black,
        modifier = Modifier
            .wrapContentSize(align = Alignment.Center)
            .padding(12.dp)
            .shadow(elevation = 4.dp, shape = CircleShape)
    ) {
        Column {
            Text(
                text = information,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 12.dp, top = 16.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable(uriHandler != null) {
                        uriHandler?.openUri(information)
                    },
                textAlign = TextAlign.Center,
                textDecoration = if (uriHandler != null) TextDecoration.Underline else null,
                color = if (uriHandler != null) DarkGreen else Color.Black
            )
        }
    }

}


@Composable
@Preview
fun AboutScreenPreview() {
    AboutScreen()
}