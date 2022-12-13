package com.simple.moviescomposeapp.ui.aboutscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simple.moviescomposeapp.R

@Composable
fun AboutScreen() {

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
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
                painter = painterResource(id = R.drawable.ic_question_mark),
                contentDescription = null,
                modifier = Modifier
                    .size(70.dp, 70.dp)
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
        }
    }
}

@Composable
fun CardHolderInformation(header: String, information: String) {

    Card(
        shape = CircleShape,
        backgroundColor = Color.Black,
        contentColor = Color.White,
        modifier = Modifier
            .wrapContentSize()
            .padding(12.dp)
    ) {
        Column {
            Text(
                text = header,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(12.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
            Text(
                text = information,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .padding(start = 24.dp, end = 16.dp, bottom = 12.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Start
            )
        }
    }

}


@Composable
@Preview
fun AboutScreenPreview() {
    AboutScreen()
}