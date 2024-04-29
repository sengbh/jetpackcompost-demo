package com.example.jetpackcompost_demo

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBarLayout(navController: NavController) {
    val screens = listOf(
        ScreenPageBottom.Home,
        ScreenPageBottom.News,
        ScreenPageBottom.Resource
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.inversePrimary //bottom bar background color
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
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
fun RowScope.AddItem(
    screen: ScreenPageBottom,
    currentDestination: NavDestination?,
    navController: NavController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon,
            "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } ==  true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route)
        }
    )
}