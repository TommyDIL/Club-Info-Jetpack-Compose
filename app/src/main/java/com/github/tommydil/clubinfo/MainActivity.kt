package com.github.tommydil.clubinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.github.tommydil.clubinfo.screens.MainScreen
import com.github.tommydil.clubinfo.screens.SecondScreen
import com.github.tommydil.clubinfo.ui.theme.ClubInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClubInfoTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "mainScreen"
                ) {
                    composable("mainScreen") {
                        MainScreen(
                            navigateToSecondScreen = { navController.navigate("secondScreen?$it") }
                        )
                    }
                    composable(
                        "secondScreen?{text}",
                        arguments = listOf(navArgument("text") {
                            type = NavType.StringType
                            nullable = true
                            defaultValue = null
                        })
                    ) {
                        SecondScreen(
                            navigateBack = { navController.popBackStack() },
                            textToShow = it.arguments?.getString("text") ?: "No text!"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClubInfoTheme {
        Greeting("Android")
    }
}