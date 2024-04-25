package com.example.jetpackcompost_demo

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainLayout() {
    val navigationController = rememberNavController()
    val selectTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = { TopBarLayout() },
        bottomBar = { BottomBarLayout(navigationController) },
        content = {
            NavHost(
                navigationController,
                "home",
                modifier = Modifier.padding(it).fillMaxSize()
            ) {
                composable(route = "home") {
                    HomePage(navigationController)
                }
                composable(route = "news"){
                    NewsPage(navigationController)
                }
                composable(route = "resource"){
                    ResourcePage()
                }
            }
        }
    )
}