package com.asilidesign.thepugfamilly.features.info

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.asilidesign.thepugfamilly.R
import com.asilidesign.thepugfamilly.core.theme.ui.theme.ThePugFamillyTheme

class InfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThePugFamillyTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    InfoScreen { name, email, avatarRes ->
                        val intent = Intent(this, StudentDetailActivity::class.java).apply {
                            putExtra("name", name)
                            putExtra("email", email)
                            putExtra("avatarRes", avatarRes)
                        }
                        startActivity(intent)
                    }
                }
            }
        }
    }
}

@Composable
fun InfoScreen(onStudentClick: (String, String, Int) -> Unit) {
    val colorScheme = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Titre de l'écran
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, colorScheme.primary),
            color = colorScheme.surface,
            tonalElevation = 2.dp
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "👨‍🎓 Liste des étudiants",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorScheme.onSurface
                )
            }
        }

        // Liste des étudiants
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
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.primary,
                    contentColor = colorScheme.onPrimary
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 4.dp)
            ) {
                Text(
                    text = name,
                    style = typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
        }
    }
}