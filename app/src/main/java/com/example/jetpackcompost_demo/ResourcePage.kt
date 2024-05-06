package com.example.jetpackcompost_demo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.runtime.remember
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter



data class ResourceList(val name: String, val description: String, val image: String)

@Composable
fun ResourcePage() {

    LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        item {
            Row(modifier = Modifier.padding(end = 8.dp)) {
                Text("Popular Dapps", style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
            }
        }
        items(
            listOf(
                ResourceList(
                    "ABC",
                    "This ABC dapp is important etc",
                    image = "https://assets.coingecko.com/coins/images/16746/small/PNG_image.png?1643184642"
                ),
                ResourceList(
                    "ABC",
                    "This ABC dapp is important etc",
                    image = "https://assets.coingecko.com/coins/images/16746/small/PNG_image.png?1643184642"
                ),
            )
        ) { resource ->
            ElevatedCard(colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8))) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(resource.name, style = MaterialTheme.typography.labelSmall)
                        Text(
                            resource.description,
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    Image(
                        painter = rememberAsyncImagePainter(resource.image),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                }
            }
        }
        item {
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Text("Crypto for Dummies", style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
            }
        }
    }
}