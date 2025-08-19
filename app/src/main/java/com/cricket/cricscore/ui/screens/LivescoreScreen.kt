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
fun LivescoreScreen(
    matchTitle: String = "Team A vs Team B",
    scoreA: Int = 156,
    wicketsA: Int = 4,
    oversA: Float = 17.3f,
    scoreB: Int = 0,
    wicketsB: Int = 0,
    oversB: Float = 0f,
    isTeamABatting: Boolean = true,
    onRefresh: () -> Unit = {},
    onViewDetails: () -> Unit = {}
) {
    val gradient = Brush.linearGradient(listOf(Color(0xFF43CEA2), Color(0xFF185A9D)))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(gradient)
                .padding(vertical = 36.dp, horizontal = 20.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                Text("🏏 Live Score", fontSize = 26.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                Spacer(Modifier.height(6.dp))
                Text(matchTitle, fontSize = 16.sp, color = Color.White.copy(alpha = 0.9f))
            }
        }

        // Score Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF43CEA2).copy(alpha = 0.07f))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(18.dp)
            ) {
                Text(
                    text = if (isTeamABatting) "Team A Batting" else "Team B Batting",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF185A9D)
                )
                Spacer(Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TeamScoreSummary(
                        teamName = "Team A",
                        score = scoreA,
                        wickets = wicketsA,
                        overs = oversA,
                        isBatting = isTeamABatting
                    )
                    Spacer(Modifier.width(34.dp))
                    TeamScoreSummary(
                        teamName = "Team B",
                        score = scoreB,
                        wickets = wicketsB,
                        overs = oversB,
                        isBatting = !isTeamABatting
                    )
                }
            }
        }

        Spacer(Modifier.height(10.dp))

        // Actions
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(
                onClick = onRefresh,
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF185A9D))
            ) {
                Text("Refresh", fontWeight = FontWeight.Bold)
            }
            OutlinedButton(
                onClick = onViewDetails,
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("View Details")
            }
        }

        Spacer(Modifier.height(20.dp))

        // Placeholder for Ball-by-ball, Player stats, etc.
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Ball-by-ball updates and player stats coming soon!",
                    fontSize = 15.sp,
                    color = Color(0xFF7f8c8d)
                )
            }
        }
    }
}

@Composable
private fun TeamScoreSummary(
    teamName: String,
    score: Int,
    wickets: Int,
    overs: Float,
    isBatting: Boolean
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(teamName, fontWeight = FontWeight.Bold, fontSize = 17.sp)
        Text("$score/$wickets", fontWeight = FontWeight.Bold, fontSize = 23.sp, color = if (isBatting) Color(0xFFC41E3A) else Color(0xFF185A9D))
        Text("${overs} ov", fontSize = 15.sp, color = Color(0xFF495057))
        if (isBatting)
            Text("Batting", fontSize = 13.sp, color = Color(0xFF43CEA2), fontWeight = FontWeight.Medium)
    }
