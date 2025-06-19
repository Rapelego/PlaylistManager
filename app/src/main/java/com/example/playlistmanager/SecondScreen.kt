package com.example.playlistmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.ui.unit.dp
import com.example.playlistmanager.ui.theme.PlaylistManagerTheme
import androidx.navigation.NavHostController

@Composable
fun SecondScreen(navController: NavController) {
    var showAll by remember { mutableStateOf(true) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Playlist Manager", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
       }
        Button(onClick = {showAll= true}) {
            Text("Show all songs")
    } 
        LazyColumn {
            val indices = songList.indices.filter {
                showAll|| ratingsList[it] >=5
            }
            song(indices.size) {index ->
                val i =indices[index]
                Text("${songList[i]} ")

            }
        }
    }
