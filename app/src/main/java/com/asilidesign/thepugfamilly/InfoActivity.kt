package com.asilidesign.thepugfamilly

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asilidesign.thepugfamilly.ui.theme.ThePugFamillyTheme

class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThePugFamillyTheme {
                InfoScreen { name, email, avatarRes ->
                    val intent = Intent(this, StudentDetailActivity::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("email", email)
                    intent.putExtra("avatarRes", avatarRes)
                    startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun InfoScreen(onStudentClick: (String, String, Int) -> Unit) {
    val blackColor = colorResource(id = R.color.black)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, blackColor),
            color = Color.Transparent
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text("Infos", fontSize = 18.sp)
            }
        }

        listOf(
            Triple("Student 1", "student1@epsi.fr", R.drawable.avatar_1),
            Triple("Student 2", "student2@epsi.fr", R.drawable.avatar_2),
            Triple("Student 3", "student3@epsi.fr", R.drawable.avatar_3)
        ).forEach { (name, email, avatarRes) ->
            Button(
                onClick = { onStudentClick(name, email, avatarRes) },
                modifier = Modifier
                    .width(200.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE0E0E0))
            ) {
                Text(name, fontWeight = FontWeight.Bold)
            }
        }
    }
}