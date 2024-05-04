package com.example.jetpackcompost_demo

sealed class ScreenPageObjectTop(val route: String) {
    data object Settings: ScreenPageObjectTop(route = "settings")
}