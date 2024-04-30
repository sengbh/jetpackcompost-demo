package com.example.jetpackcompost_demo

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.seconds



@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NewsPage(navController: NavController) {

    var justNews by remember { mutableStateOf(emptyList<String>()) }

    var newsUpdates = remember {
        flow<String> {
            delay(2.seconds)
            emit("Big Crypto Update Coming")

            delay(2.seconds)
            emit("Real Time News")

            delay(2.seconds)
            emit("Donald Tremp")
        }
    }

    LaunchedEffect(Unit) {
        newsUpdates.collect{
            justNews += it
        }
        justNews += "No more for today"
    }
    Box(
        modifier = Modifier.fillMaxSize().background(Color.LightGray),
        contentAlignment = Alignment.Center
    ){
        Text("This is news pages",
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize
        )
    }

    Column(){
        justNews.forEach {
            Text(it)
        }
    }

}