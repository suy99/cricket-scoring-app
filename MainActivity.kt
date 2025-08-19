package com.cricket.cricscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.cricket.cricscore.ui.MainNavigation
import com.cricket.cricscore.ui.theme.CricketScoringAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CricketScoringAppTheme {
                val navController = rememberNavController()
                MainNavigation(navController)
            }
        }
    }
}