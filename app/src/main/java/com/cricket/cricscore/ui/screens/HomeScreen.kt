package com.cricket.cricscore.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    userName: String = "Cricket Fan",
    onStartMatch: () -> Unit,
    onViewResults: () -> Unit,
    onManageTeams: () -> Unit
) {
    val gradient = Brush.linearGradient(listOf(Color(0xFF43CEA2), Color(0xFF185A9D)))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // AppBar & Greeting
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(gradient)
                .padding(vertical = 40.dp, horizontal = 20.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                Text("🏏 Cricket Score", fontSize = 28.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                Spacer(Modifier.height(8.dp))
                Text("Welcome, $userName!", fontSize = 18.sp, color = Color.White.copy(alpha = 0.9f))
            }
        }

        // Summary Cards
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            HomeStatCard("Live Matches", "2", Color(0xFFC41E3A))
            HomeStatCard("Teams", "8", Color(0xFF667EEA))
            HomeStatCard("Stats", "123", Color(0xFF43CEA2))
        }

        Spacer(Modifier.height(12.dp))

        // Quick Actions
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text("Quick Actions", fontSize = 18.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF185A9D))
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = onStartMatch,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC41E3A))
            ) {
                Text("Start New Match", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(Modifier.height(12.dp))
            OutlinedButton(
                onClick = onViewResults,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("View Results", fontSize = 15.sp)
            }
            Spacer(Modifier.height(12.dp))
            OutlinedButton(
                onClick = onManageTeams,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text("Manage Teams", fontSize = 15.sp)
            }
        }
    }
}

@Composable
private fun HomeStatCard(label: String, value: String, color: Color) {
    Card(
        modifier = Modifier
            .weight(1f)
            .height(80.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.12f))
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(value, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = color)
            Text(label, fontSize = 13.sp, color = color, fontWeight = FontWeight.Medium)
        }
    }
}