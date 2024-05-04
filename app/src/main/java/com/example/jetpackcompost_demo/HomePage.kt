package com.example.jetpackcompost_demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomePage(navController: NavController) {

//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ){
//        Text(
//            "This is home screen",
//            color = MaterialTheme.colorScheme.onBackground,
//            fontWeight = FontWeight.Bold,
//            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//        CounterApp()
//        Spacer(modifier = Modifier.height(16.dp))
//        UILayout()
//    }

    val newsList = listOf(
        DataClass(
            "Title 1",
            "Description 1",
            imageNews = Icons.Default.Image
        ),
        DataClass(
            "Title 2",
            "Description 2",
            imageNews = Icons.Default.Image
        ),
        DataClass(
            "Title 3",
            "Description 3",
            imageNews = Icons.Default.Image
        )
    )
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp)
    ) {
        items(newsList) { article ->
            NewsCard(article = article)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun NewsCard(article: DataClass){
    Card(
        modifier = Modifier.fillMaxWidth().background(Color.White),
    ){
            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(1f).padding(16.dp)) {
                    //Title
                    Text(
                        text = article.newsTitle,
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    //Description
                    Text(
                        text = article.newsDescription,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Image(
                    painter = rememberVectorPainter(article.imageNews),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp).padding(16.dp)
                )
            }
        }
}