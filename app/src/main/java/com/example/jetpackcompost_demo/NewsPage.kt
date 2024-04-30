package com.example.jetpackcompost_demo

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NewsPage(navController: NavController) {

    var justNews by remember { mutableStateOf(emptyList<String>()) }

    val newsUpdates = remember {
        flow<String> {
            delay(2000)
            emit("Big Crypto Update Coming")
            delay(2000)

            emit("Real Time News")
            delay(2000)

            emit("Donald Tremp")
            delay(2000)

            emit("There is no more news today")
        }
    }

    LaunchedEffect(Unit) {
        val collectedNews = mutableListOf<String>()
        newsUpdates.collect {
            collectedNews.add(it)
            justNews = collectedNews.toList()
        }
    }

//    Box(
//        modifier = Modifier.fillMaxSize().background(Color.LightGray),
//        contentAlignment = Alignment.Center
//    ){
//        Text("This is news page",
//            color = MaterialTheme.colorScheme.onBackground,
//            fontWeight = FontWeight.Bold,
//            fontSize = MaterialTheme.typography.bodyLarge.fontSize
//        )
//    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            justNews.forEach {
                Text(it, modifier = Modifier.padding(8.dp))
            }
        }
    }


}