package com.github.tommydil.clubinfo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    navigateToSecondScreen: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var count by rememberSaveable {
            mutableIntStateOf(0)
        }

        var text by rememberSaveable {
            mutableStateOf("")
        }

        Text(text = "You are on the main screen!")
        Button(onClick = { navigateToSecondScreen(text) }) {
            Text(text = "Go to second screen!")
        }
        Button(onClick = { count += 1 }) {
            Text(text = "Increment the counter!")
        }
        Text(text = "Counter value: $count")

        OutlinedTextField(value = text, onValueChange = {
            text = it
        })
    }
}