package com.cricket.cricscore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cricket.cricscore.ui.theme.CricketScoringAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CricketScoringAppTheme {
                // TODO: Add main UI composable here
            }
        }
    }
}
