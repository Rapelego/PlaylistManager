//ST10496347_MADITSI RAPELEGO
package com.example.playlistmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController

import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.playlistmanager.ui.theme.PlaylistManagerTheme

//Parallel arrays
val songList = mutableListOf<String>()
val artistList = mutableListOf<String>()
val ratingsList = mutableListOf<Int>()
val commentsList = mutableListOf<String>()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaylistManagerTheme {
                val navController = rememberNavController()

                //Set up Navigation with two screens: main and second
                NavHost(
                    navController = navController, startDestination = "main",) {
                    composable("main"){ MainScreen(navController) }
                    composable("second"){SecondScreen(navController)}
                }
            }
        }
    }
}
@Composable
fun MainScreen(navController: NavController){
    
}