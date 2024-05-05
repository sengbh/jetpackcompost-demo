package com.example.jetpackcompost_demo


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarLayout(navController: NavController) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    var title = remember { mutableStateOf("") }

    //update title based on current destination
    LaunchedEffect(currentDestination){
        title.value = when(currentDestination?.route){
            ScreenPageObjectBottom.Home.route -> "Home"
            ScreenPageObjectBottom.News.route -> "News"
            ScreenPageObjectBottom.Resource.route -> "Resource"
            else -> "Crypto Market"
        }
    }
    TopAppBar(
        title = {
            Text(
                text = title.value,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer),
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Person, null)
            }
        },
        actions = {
            IconButton(
                onClick = { navController.navigate(ScreenPageObjectTop.Settings.route) }
            ) {
                Icon(imageVector = Icons.Default.Settings, null)
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}