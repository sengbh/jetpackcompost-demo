package com.example.jetpackcompost_demo

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
                startDestination = ScreenPageBottom.Home.route,
//                modifier = Modifier.padding(it).fillMaxSize()
            ) {
                composable(ScreenPageBottom.Home.route) {
                    HomePage(navigationController)
                }
                composable(ScreenPageBottom.News.route){
                    NewsPage(navigationController)
                }
                composable(ScreenPageBottom.Resource.route){
                    ResourcePage()
                }
                composable(ScreenPageTop.Settings.route){
                    SettingsPage()
                }
            }
        }
    )
}