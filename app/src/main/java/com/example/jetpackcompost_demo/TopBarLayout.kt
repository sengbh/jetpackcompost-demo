package com.example.jetpackcompost_demo


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarLayout() {
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
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Menu, null)
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}