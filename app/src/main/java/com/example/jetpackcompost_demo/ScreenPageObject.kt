package com.example.jetpackcompost_demo

sealed class ScreenPageObject(val route: String) {
    data object Home: ScreenPageObject(route = "home")
    data object News: ScreenPageObject(route = "news")
    data object Resource: ScreenPageObject(route = "resource")
}