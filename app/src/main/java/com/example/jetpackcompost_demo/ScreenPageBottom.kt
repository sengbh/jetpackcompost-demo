package com.example.jetpackcompost_demo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenPageBottom(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    data object Home : ScreenPageBottom(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    data object News: ScreenPageBottom(
        route = "news",
        title = "News",
        icon = Icons.Default.Newspaper
    )
    data object Resource: ScreenPageBottom(
        route = "resource",
        title = "Resource",
        icon = Icons.Default.Info
    )
}