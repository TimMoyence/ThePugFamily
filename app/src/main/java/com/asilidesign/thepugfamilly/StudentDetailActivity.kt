package com.asilidesign.thepugfamilly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asilidesign.thepugfamilly.ui.theme.ThePugFamillyTheme

class StudentDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent.getStringExtra("name") ?: "Unknown"
        val email = intent.getStringExtra("email") ?: "unknown@example.com"
        val avatarRes = intent.getIntExtra("avatarRes", R.drawable.avatar_default)

        setContent {
            ThePugFamillyTheme {
                StudentDetailScreen(name, email, avatarRes)
            }
        }
    }
}

@Composable
fun StudentDetailScreen(name: String, email: String, avatarRes: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Image(
            painter = painterResource(id = avatarRes),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(150.dp)
        )

        Text("Email", fontSize = 20.sp)
        Text(text = email, fontSize = 16.sp)
    }
}