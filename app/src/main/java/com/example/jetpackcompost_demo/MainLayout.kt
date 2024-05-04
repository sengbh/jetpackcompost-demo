package com.example.jetpackcompost_demo

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainLayout() {
    val navigationController = rememberNavController()

    Scaffold(
        topBar = { TopBarLayout(navigationController) },
        bottomBar = { BottomBarLayout(navigationController) },
        content = {
            NavHost(
                navigationController,
                startDestination = ScreenPageObjectBottom.Home.route,
                modifier = Modifier.padding(it)
            ) {
                composable(ScreenPageObjectBottom.Home.route) {
                    HomePage(navigationController)
                }
                composable(ScreenPageObjectBottom.News.route){
                    NewsPage(navigationController)
                }
                composable(ScreenPageObjectBottom.Resource.route){
                    ResourcePage()
                }
                composable(ScreenPageObjectTop.Settings.route){
                    SettingsPage()
                }
            }
        }
    )
}