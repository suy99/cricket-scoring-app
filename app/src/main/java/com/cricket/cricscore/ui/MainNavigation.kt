package com.cricket.cricscore.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Score
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.cricket.cricscore.ui.screens.CommunityScreen
import com.cricket.cricscore.ui.screens.HomeScreen
import com.cricket.cricscore.ui.screens.ScoresScreen

sealed class Screen(val route: String, val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Scores : Screen("scores", "Scores", Icons.Default.Score)
    object Community : Screen("community", "Community", Icons.Default.People)
}

val bottomNavItems = listOf(Screen.Home, Screen.Scores, Screen.Community)

@Composable
fun MainNavigation(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(bottomNavItems.find { it.route == currentRoute }?.label ?: "Cricket App") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF185A9D),
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF185A9D)) {
                bottomNavItems.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Scores.route) {
                ScoresScreen()
            }
            composable(Screen.Community.route) {
                CommunityScreen()
            }
            // Add other screens here, following the same pattern!
        }
    }
}