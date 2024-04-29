package com.example.jetpackcompost_demo

sealed class ScreenPageTop(val route: String) {
    data object Settings: ScreenPageTop(route = "settings")
}