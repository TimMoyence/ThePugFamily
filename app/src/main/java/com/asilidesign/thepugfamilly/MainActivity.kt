package com.asilidesign.thepugfamilly

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asilidesign.thepugfamilly.ui.theme.ThePugFamillyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThePugFamillyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        onInfoClick = {
                            startActivity(Intent(this, InfoActivity::class.java))
                        },
                        onProductsClick = {
                            startActivity(Intent(this, ProductsActivity::class.java))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onInfoClick: () -> Unit,
    onProductsClick: () -> Unit
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Home",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp),
            shape = RoundedCornerShape(4.dp),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text("Epsi", fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onInfoClick,
            modifier = Modifier
                .size(120.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
        ) {
            Text("Info", fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = onProductsClick,
            modifier = Modifier
                .size(120.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
        ) {
            Text("Products", fontWeight = FontWeight.Bold)
        }
    }
}