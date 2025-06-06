package com.asilidesign.thepugfamilly.features.products

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.asilidesign.thepugfamilly.core.theme.ui.theme.ThePugFamillyTheme

class ProductDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = intent.getStringExtra("name") ?: "Produit inconnu"
        val description = intent.getStringExtra("description") ?: "Aucune description"
        val imageUrl = intent.getStringExtra("picture_url") ?: ""

        setContent {
            ThePugFamillyTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ProductDetailScreen(name, description, imageUrl)
                }
            }
        }
    }
}

@Composable
fun ProductDetailScreen(name: String, description: String, imageUrl: String) {
    val scrollState = rememberScrollState()
    val colorScheme = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Titre du produit
        Text(
            text = name,
            style = typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = colorScheme.onBackground
            )
        )

        // Image du produit
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            shape = RoundedCornerShape(12.dp),
            tonalElevation = 4.dp,
            color = colorScheme.surface
        ) {
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Description
        Text(
            text = description,
            style = typography.bodyLarge.copy(
                fontSize = 16.sp,
                color = colorScheme.onBackground
            )
        )
    }
}