//ST10496347_MADITSI RAPELEGO
package com.example.playlistmanager

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
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
fun MainScreen(navController: NavController) {
    //Input states for form fields
    var song by remember { mutableStateOf("") }
    var artist by remember { mutableStateOf("") }
    var ratings by remember { mutableStateOf("") }
    var comments by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Song Name", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        //Input fields
        OutlinedTextField(value = song, onValueChange = { song = it }, label = { Text("Song") })
        OutlinedTextField(
            value = artist,
            onValueChange = { artist = it },
            label = { Text("Artist") })
        OutlinedTextField(
            value = ratings,
            onValueChange = { ratings = it },
            label = { Text("Ratings") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = comments,
            onValueChange = { comments = it },
            label = { Text("Comments") })

        Spacer(modifier = Modifier.height(12.dp))

        //Button to add Name of the song
        Button(onClick = {
            //Vallidates input before saving
            if (song.isNotBlank() && artist.isNotBlank() && ratings.toIntOrNull() != null && comments.isNotBlank()) {

                //Save to parallel arrays
                songList.add(song)
                artistList.add(artist)
                ratingsList.add(ratings.toInt())
                commentsList.add(comments)

                //Log the data to Logcat
                Log.i("PlaylistManager", "Song added: $song,$artist,$ratings,$comments")

                //Notify user if successful
                Toast.makeText(context, "Song Added", Toast.LENGTH_SHORT).show()

                //Reset fields
                song = ""; artist = ""; ratings = ""; comments = ""
            } else {
                //Display error if validation fails
                Toast.makeText(context, "Please all song details correctly.", Toast.LENGTH_SHORT)
                    .show()
            }
        }) { Text("Add to Playlist") }

        Spacer(modifier = Modifier.height(8.dp))

        //Button that Navigates to the second screen when clicked
        Button(onClick = { navController.navigate("second") })  {
            Text("Exit App")
        }
    }
}
