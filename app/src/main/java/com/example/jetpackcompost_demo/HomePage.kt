package com.example.jetpackcompost_demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp


@Composable
fun HomePage() {
    val newsList = listOf(
        DataClass(
            "Title 1",
            "Description 1. Description 1. Description 1. Description 1. Description 1",
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
    Box(
        modifier = Modifier.fillMaxSize().padding(horizontal = 4.dp, vertical = 8.dp)
    ){
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)
        ) {
            items(newsList) { article ->
                NewsCard(article = article)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun NewsCard(article: DataClass) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
            .fillMaxSize()
            .background(Color.White)
            .padding(8.dp),
    ) {
        Column(modifier = Modifier.fillMaxSize()){
            Row(verticalAlignment = Alignment.CenterVertically){
                //Title
                Text(
                    text = article.newsTitle,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
                )
                Image(
                    painter = rememberVectorPainter(article.imageNews),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit
                )
            }
            //Description
            Text(
                text = article.newsDescription,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .weight(1f)
            )
        }
    }
}