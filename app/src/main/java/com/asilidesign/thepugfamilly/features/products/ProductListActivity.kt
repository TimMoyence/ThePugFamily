package com.asilidesign.thepugfamilly.features.products

import Product
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.asilidesign.thepugfamilly.core.theme.ui.theme.ThePugFamillyTheme

class ProductListActivity : ComponentActivity() {
    private val viewModel: ProductListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val productsUrl = intent.getStringExtra("products_url") ?: return
        val productCategory = intent.getStringExtra("product_category") ?: return
        viewModel.fetchProducts(productsUrl)

        setContent {
            ThePugFamillyTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ProductListScreen(productCategory, viewModel)
                }
            }
        }
    }
}

@Composable
fun ProductListScreen(
    productCategory: String,
    viewModel: ProductListViewModel,
    modifier: Modifier = Modifier
) {
    val products by viewModel.products.collectAsState()
    val colorScheme = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = productCategory,
            style = typography.titleLarge.copy(color = colorScheme.onBackground),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(products) { product ->
                ProductItem(product)
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    val context = LocalContext.current
    val colorScheme = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                val intent = Intent(context, ProductDetailActivity::class.java).apply {
                    putExtra("name", product.name)
                    putExtra("description", product.description)
                    putExtra("picture_url", product.picture_url)
                }
                context.startActivity(intent)
            },
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 2.dp,
        color = colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = product.picture_url),
                contentDescription = product.name,
                modifier = Modifier
                    .size(100.dp)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.name,
                    style = typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onSurface
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = product.description,
                    style = typography.bodyMedium.copy(
                        color = colorScheme.onSurface
                    ),
                    maxLines = 2
                )
            }
        }
    }
}