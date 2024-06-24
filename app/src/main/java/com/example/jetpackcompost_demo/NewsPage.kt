package com.example.jetpackcompost_demo

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.jetpackcompost_demo.api.ApiData
import com.example.jetpackcompost_demo.api.Results
import com.example.jetpackcompost_demo.api.http
import io.ktor.client.call.*
import io.ktor.client.request.*
import okhttp3.Headers
import kotlin.random.Random


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun NewsPage(navController: NavController) {

    var news by remember { mutableStateOf(emptyList<Results>()) }
    LaunchedEffect(Unit) {
        val url = "https://cryptopanic.com/api/v1/posts/?auth_token=e3a4fea7c08e004ef77f9babb73703d3a985d94e"
        news = http.get(url).body<ApiData>().results
    }
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16f.dp),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {
            items(news) { NewsItem(it) }
        }
    }

//    var justNews by remember { mutableStateOf(emptyList<String>()) }
//
//    val newsUpdates = remember {
//        flow<String> {
//            delay(2000)
//            emit("Big Crypto Update Coming")
//            delay(2000)
//
//            emit("Real Time News")
//            delay(2000)
//
//            emit("Donald Tremp")
//            delay(2000)
//
//            emit("There is no more news today")
//        }
//    }
//
//    LaunchedEffect(Unit) {
//        val collectedNews = mutableListOf<String>()
//        newsUpdates.collect {
//            collectedNews.add(it)
//            justNews = collectedNews.toList()
//        }
//    }
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally
//        ){
//            justNews.forEach {
//                Text(it, modifier = Modifier.padding(8.dp))
//            }
//        }
//    }
}

@Composable
fun NewsItem(news: Results) {
    val small = MaterialTheme.typography.bodySmall.fontSize
    val context = LocalContext.current
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .clickable {
                news.url?.launchUrl(context)
            }
    ) {
        Text(buildAnnotatedString {
            withStyle(
                SpanStyle(fontWeight = FontWeight.Bold)
            ) {
                append(news.title)
            }
            withStyle(
                ParagraphStyle(lineBreak = LineBreak.Simple)
            ) {
                withStyle(
                    SpanStyle(color = Color.Gray, fontSize = small)
                ) {
                    append("${news.source?.domain} • ${Random.nextInt(60)}m")
                }
            }

        }, modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .background(color = MaterialTheme.colorScheme.surface)
                .width(80.dp)
                .height(80.dp)
        ) {
            val apikey = "H8n02HVepdIlsUW+8tCY3w==xtqjj92rXBDoMTrK"
            AsyncImage(
                model = remember {
                    ImageRequest.Builder(context)
                        .data("https://api.api-ninjas.com/v1/randomimage?category=technology")
                        .headers(Headers.headersOf("X-Api-Key", apikey, "Accept", "image/jpg"))
                        .memoryCachePolicy(CachePolicy.DISABLED)
                        .diskCachePolicy(CachePolicy.DISABLED)
                        .build()
                },
                null,
                contentScale = ContentScale.FillBounds,
                alignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

fun String.launchUrl(context: Context){
    context.startActivity(
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse(this)
        )
    )
}
