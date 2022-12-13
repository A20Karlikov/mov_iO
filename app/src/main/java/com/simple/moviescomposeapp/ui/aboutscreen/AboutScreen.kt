package com.simple.moviescomposeapp.ui.aboutscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AboutScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {

        Text(text = "About Screen")
    }
}