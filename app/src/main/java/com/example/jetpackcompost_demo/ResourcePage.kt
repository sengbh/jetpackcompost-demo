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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter


data class ResourceList(val name: String, val description: String, val image: String, val url: String?)

@Composable
fun ResourcePage() {
    val context = LocalContext.current
    LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        item {
            Row(modifier = Modifier.padding(end = 8.dp)) {
                Text("Popular Dapp", style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
            }
            Column(modifier = Modifier.padding(top = 8.dp)) {
                LazyRow(
                    contentPadding = PaddingValues(start = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        listOf(
                            ResourceList(
                                "OpenSea",
                                "OpenSea is a leading marketplace for buying, selling, and trading non-fungible tokens (NFTs). OpenSea offers a user-friendly platform for exploring, discovering, and managing NFTs.",
                                image = "https://pbs.twimg.com/profile_images/1760855147662458880/COJ9xiFz_400x400.png",
                                url = "https://opensea.io/"
                            ),
                            ResourceList(
                                "UNISWAP",
                                "Uniswap is a decentralized exchange on Ethereum that allows users to trade cryptocurrencies directly from their wallets using automated liquidity pools. It enables users to provide liquidity and earn fees, supporting a wide range of Ethereum-based tokens and ensuring users retain control of their funds.",
                                image = "https://assets.coingecko.com/coins/images/12504/standard/uni.jpg?1696512319",
                                url = "https://uniswap.org/"
                            ),
                            ResourceList(
                                "METAMASK",
                                "Metamask is one of the most popular cryptocurrency wallets and browser extensions that allows users to manage Ethereum-based assets and its layers.",
                                image = "https://lcw.nyc3.cdn.digitaloceanspaces.com/production/currencies/64/mask.webp",
                                url = "https://metamask.io/"
                            ),
                            ResourceList(
                                "COINBASE Wallet",
                                "Yet another trusted wallet to manage and interact the crypto assets in the decentralized world.",
                                image = "https://assets.coingecko.com/markets/images/23/large/Coinbase_Coin_Primary.png?1706864258",
                                url = "https://www.coinbase.com/wallet"
                            ),
                            ResourceList(
                                "Phantom Wallet",
                                "The most popular wallet for Solana is Phantom. Phantom is a user-friendly and secure cryptocurrency wallet designed specifically for the Solana blockchain. It allows users to store, send, and receive SOL and other Solana-based tokens.",
                                image = "https://pbs.twimg.com/profile_images/1675202638026252291/4StTDIF4_400x400.jpg",
                                url = "https://phantom.app/"
                            ),
                            ResourceList(
                                "DeBank",
                                "DeBank is a DeFi portfolio tracker that allows users to manage and analyze their decentralized finance activities. It supports multiple blockchains, providing insights into assets, debts, and transaction histories.",
                                image = "https://pbs.twimg.com/profile_images/1414880725921267716/YzVitob7_400x400.jpg",
                                url = "https://debank.com/"
                            ),
                        )
                    ) { resource ->
                        Card(
                            modifier = Modifier
                                .width(200.dp)
                                .height(100.dp)
                                .clickable {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(resource.url))
                                    context.startActivity(intent)
                                },
                            elevation = CardDefaults.cardElevation(8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8))
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
                                    Text(resource.name, style = MaterialTheme.typography.titleSmall)
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(Icons.AutoMirrored.Filled.ArrowForward, null)
                                }
                                Text(
                                    resource.description,
                                    color = MaterialTheme.colorScheme.primary,
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                                )
                            }
                        }
                    }
                }
            }
        }
        item {
            Row(modifier = Modifier.padding(end = 8.dp)) {
                Text("Crypto Social Groups", style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
            }
            Column(modifier = Modifier.padding(top = 8.dp)) {
                LazyRow(
                    contentPadding = PaddingValues(start = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        listOf(
                            ResourceList(
                                "r/Cryptocurrency",
                                "The leading community for cryptocurrency news, discussion, and analysis.",
                                image = "https://styles.redditmedia.com/t5_2wlj3/styles/communityIcon_9d1xp2ewguvc1.png",
                                url = "https://www.reddit.com/r/CryptoCurrency/"
                            ),
                            ResourceList(
                                "r/Dogecoin",
                                "The most amazing place on reddit! A subreddit for sharing, discussing, hoarding and wow'ing about Dogecoins. The much wow innovative crypto-currency.",
                                image = "https://styles.redditmedia.com/t5_2zcp2/styles/communityIcon_gflpzojnfs621.png",
                                url = "https://www.reddit.com/r/dogecoin/"
                            ),
                            ResourceList(
                                "r/ethtrader",
                                "Welcome to /r/EthTrader, a 100% community driven sub. Here you can discuss Ethereum news, memes, investing, trading, miscellaneous market-related subjects and other relevant technology.",
                                image = "https://styles.redditmedia.com/t5_37jgj/styles/communityIcon_e0c2lfrlnhsc1.png",
                                url = "https://www.reddit.com/r/ethtrader/"
                            ),
                            ResourceList(
                                "r/Bitcoin",
                                "Bitcoin is the currency of the Internet: a distributed, worldwide, decentralized digital money.",
                                image = "https://styles.redditmedia.com/t5_2s3qj/styles/communityIcon_0b7iyz6hc6i51.png",
                                url = "https://www.reddit.com/r/Bitcoin/"
                            ),
                        )
                    ) { resource ->
                        Card(
                            modifier = Modifier
                                .width(200.dp)
                                .height(100.dp)
                                .background(Color(0xFFF8F8F8))
                                .clickable {
                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(resource.url))
                                    context.startActivity(intent)
                                },
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
                                    Text(resource.name, style = MaterialTheme.typography.titleSmall)
                                    Spacer(modifier = Modifier.weight(1f))
//                                    Icon(Icons.Default.Star, null)
                                }
                                Text(
                                    resource.description,
                                    color = MaterialTheme.colorScheme.primary,
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
                                )
                            }
                        }
                    }
                }
            }
        }

        item {
            Row(modifier = Modifier.padding(end = 8.dp, top = 8.dp)) {
                Text("Crypto Basics and More", style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
            }
        }
        items(
            listOf(
                ResourceList(
                    "Binance Academy",
                    "Your one-stop guide to all things crypto. Whether you're a rookie trying to understand mining or a veteran looking to develop a trading strategy.",
                    image = "https://assets.coingecko.com/markets/images/52/large/binance.jpg?1706864274",
                    url = "https://academy.binance.com/en"
                ),
                ResourceList(
                    "Coinbase learn",
                    "Learn about Crypto layers, gas fees, smart-contract, mining, meme coins and more.",
                    image = "https://assets.coingecko.com/markets/images/23/large/Coinbase_Coin_Primary.png?1706864258",
                    url = "https://www.coinbase.com/learn/crypto-basics"
                ),
                ResourceList(
                    "Kraken learn",
                    "Dive in further into Blockchain, DeFi, Crypto Trading, and more.",
                    image = "https://assets.coingecko.com/markets/images/29/large/kraken.jpg?1706864265",
                    url = "https://www.kraken.com/learn"
                ),
                ResourceList(
                    "Metamask learn",
                    "The Web3 101 Course where beginners learn more about Web3, Self-Custody, NFTs and more.",
                    image = "https://lcw.nyc3.cdn.digitaloceanspaces.com/production/currencies/64/mask.webp",
                    url = "https://learn.metamask.io/overview"
                ),
                ResourceList(
                    "CoinGecko Learn",
                    "Provides educational content on crypto, including detailed articles and beginner guides.",
                    image = "https://pbs.twimg.com/profile_images/1604796574415978496/SIffz3a6_400x400.jpg",
                    url = "https://www.coingecko.com/learn"
                ),
            )
        ) { resource ->
            ElevatedCard(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8)),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(resource.url))
                        context.startActivity(intent)
                    }
            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        //title
                        Text(resource.name, style = MaterialTheme.typography.titleSmall)

                        //description
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
    }
}