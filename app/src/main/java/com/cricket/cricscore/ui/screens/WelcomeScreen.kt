package com.cricket.cricscore.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(
    onSignUp: () -> Unit,
    onSignIn: () -> Unit
) {
    // Gradient colors
    val gradient = Brush.linearGradient(
        colors = listOf(Color(0xFF667EEA), Color(0xFF764BA2))
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
            .padding(40.dp)
    ) {
        // Decorative background circles
        Box(modifier = Modifier
            .size(200.dp)
            .align(Alignment.TopEnd)
            .offset(x = 40.dp, y = (-100).dp)
            .clip(CircleShape)
            .background(Color.White.copy(alpha = 0.1f))
        )
        Box(modifier = Modifier
            .size(160.dp)
            .align(Alignment.BottomStart)
            .offset(x = (-80).dp, y = 80.dp)
            .clip(CircleShape)
            .background(Color.White.copy(alpha = 0.1f))
        )
        // Main content
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Animated logo
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.2f))
                    .blur(10.dp)
                    .border(
                        width = 2.dp,
                        color = Color.White.copy(alpha = 0.3f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "\uD83C\uDFCF", // 🏏
                    fontSize = 48.sp,
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.height(40.dp))

            // App name
            Text(
                "CricketScore Pro",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                letterSpacing = (-1).sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Tagline
            Text(
                "Your Ultimate Cricket Companion",
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.9f),
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Description
            Text(
                "Score matches, join tournaments, connect with players worldwide",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.8f),
                lineHeight = 20.sp,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            // Features preview
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                FeatureIcon("⚡", "Live Scoring")
                FeatureIcon("🏆", "Tournaments")
                FeatureIcon("👥", "Community")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Action buttons
            Button(
                onClick = onSignUp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White.copy(alpha = 0.9f),
                    contentColor = Color(0xFF667EEA)
                )
            ) {
                Text("🚀 Get Started", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                onClick = onSignIn,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 2.dp, color = Color.White.copy(alpha = 0.5f))
            ) {
                Text("Already have an account? Sign In", fontWeight = FontWeight.Medium, fontSize = 16.sp)
            }
        }
    }
}

@Composable
private fun FeatureIcon(icon: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.2f))
                .blur(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(icon, fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(label, fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
    }
}