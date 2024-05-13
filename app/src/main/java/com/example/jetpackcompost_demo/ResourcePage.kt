package com.example.jetpackcompost_demo

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


data class ResourceList(val name: String, val description: String, val image: String, val url: String?) {
    companion object {
        val url: String? = null
    }
}

@Composable
fun ResourcePage() {
    val context = LocalContext.current
    LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        item {
            Row(modifier = Modifier.padding(end = 8.dp)) {
                Text("Popular Dapps", style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
            }
        }
        items(
            listOf(
                ResourceList(
                    "Coinbase",
                    "This ABC dapp is important etc",
                    image = "https://assets.coingecko.com/markets/images/23/large/Coinbase_Coin_Primary.png?1706864258",
                    url = "https://www.coinbase.com/learn/crypto-basics"
                ),
                ResourceList(
                    "Kraken",
                    "This ABC dapp is important etc",
                    image = "https://assets.coingecko.com/markets/images/29/large/kraken.jpg?1706864265",
                    url = "https://www.kraken.com/"
                ),
            )
        ) { resource ->
            ElevatedCard(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8)),
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(resource.url))
                    context.startActivity(intent)
                }
            ) {
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
            Row(modifier = Modifier.padding(end = 8.dp)) {
                Text("Crypto for Dummies", style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
            }
            Column(modifier = Modifier.padding(top = 8.dp)) {
                LazyRow(
                    contentPadding = PaddingValues(start = 8.dp, top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        listOf(
                            ResourceList(
                                "ABC",
                                "Reward rates are subject to change and compliance with Kraken's terms and conditions. These materials are for general information purposes only and are not investment advice...",
                                image = "https://assets.coingecko.com/coins/images/1/standard/bitcoin.png?1696501400",
                                url = "https://www.coinbase.com/learn/crypto-basics"
                            ),
                            ResourceList(
                                "ABC",
                                "Reward rates are subject to change and compliance with Kraken's terms and conditions. These materials are for general information purposes only and are not investment advice...",
                                image = "https://assets.coingecko.com/coins/images/1/standard/bitcoin.png?1696501400",
                                url = null
                            ),
                            ResourceList(
                                "ABC",
                                "Reward rates are subject to change and compliance with Kraken's terms and conditions. These materials are for general information purposes only and are not investment advice...",
                                image = "https://assets.coingecko.com/coins/images/1/standard/bitcoin.png?1696501400",
                                url = null
                            ),
                            ResourceList(
                                "ABC",
                                "Reward rates are subject to change and compliance with Kraken's terms and conditions. These materials are for general information purposes only and are not investment advice...",
                                image = "https://assets.coingecko.com/coins/images/1/standard/bitcoin.png?1696501400",
                                url = null
                            ),
                        )
                    ) { resource ->
                        Card(
                            modifier = Modifier
                                .width(200.dp)
                                .background(Color(0xFFF8F8F8))
                                .clickable {},
                            elevation = CardDefaults.cardElevation(8.dp)
                        ) {
                            Column() {
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Image(
                                        painter = rememberAsyncImagePainter(resource.image),
                                        contentDescription = null,
                                        modifier = Modifier.size(32.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(resource.name, style = MaterialTheme.typography.labelSmall)
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(Icons.Default.Star, null)
                                }
                                Text(
                                    resource.description,
                                    color = MaterialTheme.colorScheme.primary,
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.padding(8.dp),
//                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }

        item {
            Row(modifier = Modifier.padding(end = 8.dp)) {
                Text("Crypto for Dummies", style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
            }
            Column(modifier = Modifier.padding(top = 8.dp)) {
                LazyRow(
                    contentPadding = PaddingValues(start = 8.dp, top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        listOf(
                            ResourceList(
                                "ABC",
                                "Reward rates are subject to change and compliance with Kraken's terms and conditions. These materials are for general information purposes only and are not investment advice...",
                                image = "https://assets.coingecko.com/coins/images/1/standard/bitcoin.png?1696501400",
                                url = null
                            ),
                            ResourceList(
                                "ABC",
                                "Reward rates are subject to change and compliance with Kraken's terms and conditions. These materials are for general information purposes only and are not investment advice...",
                                image = "https://assets.coingecko.com/coins/images/1/standard/bitcoin.png?1696501400",
                                url = null
                            ),
                            ResourceList(
                                "ABC",
                                "Reward rates are subject to change and compliance with Kraken's terms and conditions. These materials are for general information purposes only and are not investment advice...",
                                image = "https://assets.coingecko.com/coins/images/1/standard/bitcoin.png?1696501400",
                                url = null
                            ),
                            ResourceList(
                                "ABC",
                                "Reward rates are subject to change and compliance with Kraken's terms and conditions. These materials are for general information purposes only and are not investment advice...",
                                image = "https://assets.coingecko.com/coins/images/1/standard/bitcoin.png?1696501400",
                                url = null
                            ),
                        )
                    ) { resource ->
                        Card(
                            modifier = Modifier
                                .width(200.dp)
                                .background(Color(0xFFF8F8F8))
                                .clickable { ResourceList.url },
                            elevation = CardDefaults.cardElevation(8.dp)
                        ) {
                            Column() {
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                                        .background(MaterialTheme.colorScheme.errorContainer),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = rememberAsyncImagePainter(resource.image),
                                        contentDescription = null,
                                        modifier = Modifier.size(32.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(resource.name, style = MaterialTheme.typography.labelSmall)
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(Icons.Default.Star, null)
                                }
                                Text(
                                    resource.description,
                                    color = MaterialTheme.colorScheme.primary,
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.padding(8.dp),
//                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}