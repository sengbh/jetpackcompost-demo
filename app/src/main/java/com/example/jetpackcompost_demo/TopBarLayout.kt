package com.example.jetpackcompost_demo


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarLayout(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                "Crypto Market",
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
                onClick = { navController.navigate(ScreenPageTop.Settings.route) }
            ) {
                Icon(imageVector = Icons.Default.Settings, null)
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}