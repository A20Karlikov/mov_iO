package com.simple.moviescomposeapp.ui.moviesList

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun SearchMoviesField(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: () -> Unit,
    focusManager: FocusManager
) {

    TextField(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, top = 4.dp)
            .fillMaxWidth(),
        value = text,
        onValueChange = { onTextChange(it) },
        placeholder = {
            Text(
                text = "Search here...",
                modifier = Modifier.alpha(ContentAlpha.medium),
                color = MaterialTheme.colors.primary
            )
        },
        singleLine = true,
        leadingIcon = {
            IconButton(
                modifier = Modifier.alpha(ContentAlpha.medium),
                onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colors.primary
                )
            }
        },
        trailingIcon = {
            IconButton(
                onClick = { if (text.isNotEmpty()) onTextChange("") else focusManager.clearFocus() }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Icon",
                    tint = MaterialTheme.colors.primary
                )
            }
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                focusManager.clearFocus()
                onSearchClicked()
            }),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent
        )
    )
}