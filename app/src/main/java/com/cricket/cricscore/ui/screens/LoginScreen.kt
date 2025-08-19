package com.cricket.cricscore.ui.screens

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
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLogin: () -> Unit,
    onSignUp: () -> Unit
) {
    // State
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }

    val gradient = Brush.linearGradient(listOf(Color(0xFFC41E3A), Color(0xFFE74C3C)))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header Gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(gradient)
                .padding(top = 60.dp, bottom = 40.dp, start = 20.dp, end = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.2f))
                        .blur(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🏏", fontSize = 32.sp)
                }
                Spacer(Modifier.height(24.dp))
                Text("Welcome Back!", fontSize = 28.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                Spacer(Modifier.height(8.dp))
                Text("Sign in to continue your cricket journey", fontSize = 16.sp, color = Color.White.copy(alpha = 0.9f))
            }
        }

        // Login Form
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
        ) {
            Spacer(Modifier.height(20.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Address") },
                leadingIcon = { Text("📧", fontSize = 20.sp) },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = { Text("🔒", fontSize = 20.sp) },
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Text(if (passwordVisible) "🙈" else "👁️", fontSize = 20.sp)
                    }
                },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
            )

            Spacer(Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = { rememberMe = it }
                    )
                    Text("Remember me", fontSize = 14.sp, color = Color(0xFF495057))
                }
                TextButton(onClick = { /* TODO: forgot password */ }) {
                    Text("Forgot Password?", color = Color(0xFFC41E3A), fontWeight = FontWeight.SemiBold)
                }
            }

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = onLogin,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC41E3A),
                    contentColor = Color.White
                )
            ) {
                Text("🏏 Sign In to Cricket", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }

            Spacer(Modifier.height(16.dp))

            // Social Login Buttons
            Column {
                Text(
                    "Or continue with",
                    fontSize = 14.sp,
                    color = Color(0xFF7f8c8d),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(Modifier.height(12.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    SocialButton("🔵")
                    SocialButton("📱")
                    SocialButton("🍎")
                }
            }

            Spacer(Modifier.height(24.dp))

            // Sign Up Link
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text("Don't have an account? ", fontSize = 14.sp, color = Color(0xFF7f8c8d))
                TextButton(onClick = onSignUp) {
                    Text("Sign Up", color = Color(0xFFC41E3A), fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }
        }
    }
}

@Composable
private fun SocialButton(icon: String) {
    OutlinedButton(
        onClick = { /* TODO: social login */ },
        modifier = Modifier
            .weight(1f)
            .height(48.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(icon, fontSize = 20.sp)
    }
}