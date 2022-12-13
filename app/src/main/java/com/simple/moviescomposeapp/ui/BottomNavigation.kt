package com.simple.moviescomposeapp.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        BottomNavItem.Search,
        BottomNavItem.Events,
        BottomNavItem.Home,
        BottomNavItem.History,
        BottomNavItem.About,
    )

    BottomNavigation(
        modifier = Modifier
            .wrapContentSize(align = Alignment.BottomCenter)
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null,
                        modifier = if (currentRoute == item.route) {
                            Modifier
                                .border(1.dp, Color.White, CircleShape)
                                .padding(12.dp)
                        } else {
                            Modifier
                        }
                    )
                },
                modifier = Modifier.wrapContentSize(),
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        //If there is a destination selected we popUpTo it
                        //Else if there is no destination selected then we popUpTo the home destination
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }

                        //At most one copy of a given destination on the top of the back stack
                        launchSingleTop = true

                        //Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem(
        route = "home_screen",
        icon = Icons.Rounded.Home
    )

    object Search : BottomNavItem(
        route = "movies_list_screen",
        icon = Icons.Rounded.Search
    )

    object Events : BottomNavItem(
        //TODO: Create screen
        route = "event_screen",
        icon = Icons.Rounded.DateRange
    )

    object History : BottomNavItem(
        //TODO: Create screen
        route = "history_screen",
        icon = Icons.Rounded.Favorite
    )

    object About : BottomNavItem(
        //TODO: Create screen
        route = "about_screen",
        icon = Icons.Rounded.Info
    )
}