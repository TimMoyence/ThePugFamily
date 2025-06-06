package com.asilidesign.thepugfamilly.features.info

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asilidesign.thepugfamilly.R
import com.asilidesign.thepugfamilly.core.theme.ui.theme.ThePugFamillyTheme

class StudentDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name = intent.getStringExtra("name") ?: "Unknown"
        val email = intent.getStringExtra("email") ?: "unknown@example.com"
        val avatarRes = intent.getIntExtra("avatarRes", R.drawable.avatar_default)

        setContent {
            ThePugFamillyTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    StudentDetailScreen(name, email, avatarRes)
                }
            }
        }
    }
}

@Composable
fun StudentDetailScreen(name: String, email: String, avatarRes: Int) {
    val colorScheme = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Nom de l'étudiant
        Text(
            text = name,
            style = typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = colorScheme.onBackground
            )
        )

        // Avatar arrondi
        Image(
            painter = painterResource(id = avatarRes),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
        )

        // Label Email
        Text(
            text = "📧 Email",
            style = typography.bodyLarge.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = colorScheme.primary
            )
        )

        // Email réel
        Text(
            text = email,
            style = typography.bodyLarge.copy(
                fontSize = 16.sp,
                color = colorScheme.onBackground
            )
        )
    }
}