package com.example.jetpackcompost_demo

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBarLayout(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomAppBar(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
//        modifier = Modifier.background(MaterialTheme.colorScheme.onBackground)
    ) {
        BottomBarItem(
            currentDestination,
            navController
        )
    }

//    BottomAppBar(
//        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
//        modifier = Modifier.background(MaterialTheme.colorScheme.onBackground)
//    ) {
//        Box(
//            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
//        ) {
//            //Route to home page
//            IconButton(
//                onClick = {
//                    navController.navigate(ScreenPageObject.Home.route) {
//                        popUpTo(navController.graph.startDestinationId) {
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                    }
//                },
//                modifier = Modifier.align(Alignment.CenterStart)
//            ) {
//                Icon(imageVector = Icons.Default.Home, null)
//            }
//
//            //Route to Info/News Page
//            IconButton(
//                onClick = {
//                    navController.navigate(ScreenPageObject.News.route)
//                    {
//                        popUpTo(navController.graph.startDestinationId) {
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                    }
//                },
//                modifier = Modifier.align(Alignment.Center)
//            ) {
//                Icon(imageVector = Icons.Default.Newspaper, null)
//            }
//
//            //Route to Favorite/Resources page
//            IconButton(
//                onClick = {
//                    navController.navigate(ScreenPageObject.Resource.route)
//                    {
//                        popUpTo(navController.graph.startDestinationId) {
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                    }
//                },
//                modifier = Modifier.align(Alignment.CenterEnd)
//            ) {
//                Icon(imageVector = Icons.Default.Info, contentDescription = "Info")
//            }
//        }
//    }
}

@Composable
fun BottomBarItem(
    currentDestination: NavDestination?,
    navController: NavController
) {
    val screens = listOf(
        ScreenPageObjectBottom.Home,
        ScreenPageObjectBottom.News,
        ScreenPageObjectBottom.Resource
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        screens.forEach { screen ->
            val selected = currentDestination?.hierarchy?.any {
                it.route == screen.route
            } == true
            val iconColor =
                if (selected) MaterialTheme.colorScheme.primary else Color.Gray
            val textColor =
                if (selected) MaterialTheme.colorScheme.primary else Color.Gray

            TextButton(
                onClick = {
                    navController.navigate(screen.route)
                },
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = screen.icon,
                        null,
                        tint = iconColor
                    )
                    Text(
                        text = screen.title,
                        color = textColor
                    )
                }
            }
        }
    }

}