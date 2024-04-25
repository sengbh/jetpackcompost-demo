package com.example.jetpackcompost_demo

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

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
                    navController.navigate(route = "home"){
                        popUpTo(navController.graph.startDestinationId){
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
                    navController.navigate("news")
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
                    navController.navigate("resource")
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