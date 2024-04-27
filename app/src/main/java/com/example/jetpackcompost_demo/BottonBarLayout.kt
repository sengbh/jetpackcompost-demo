package com.example.jetpackcompost_demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun BottomBarLayout(navController: NavController) {

    BottomAppBar(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        modifier = Modifier.background(MaterialTheme.colorScheme.onBackground)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            //Route to home page
            IconButton(
                onClick = {
                    navController.navigate(ScreenPageObject.Home.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(imageVector = Icons.Default.Home, null)
            }

            //Route to Info/News Page
            IconButton(
                onClick = {
                    navController.navigate(ScreenPageObject.News.route)
                    {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.align(Alignment.Center)
            ) {
                Icon(imageVector = Icons.Default.Newspaper, null)
            }

            //Route to Favorite/Resources page
            IconButton(
                onClick = {
                    navController.navigate(ScreenPageObject.Resource.route)
                    {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(imageVector = Icons.Default.Info, null)
            }
        }
    }
}