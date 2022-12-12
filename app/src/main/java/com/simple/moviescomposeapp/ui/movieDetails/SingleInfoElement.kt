package com.simple.moviescomposeapp.ui.movieDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SingleInfoElement(elementName: String, value: String, drawableId: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = drawableId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Column {
            Text(
                text = value,
                style = MaterialTheme.typography.subtitle2,
                fontSize = 20.sp
            )
            Text(
                text = elementName,
                style = MaterialTheme.typography.subtitle2,
                fontSize = 10.sp
            )
        }
    }
}