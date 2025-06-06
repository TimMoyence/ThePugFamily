package com.asilidesign.thepugfamilly.features.products

import Product
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asilidesign.thepugfamilly.core.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    fun fetchProducts(url: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getProducts(url)
                _products.value = response.record
            } catch (e: Exception) {
                // handle error
            }
        }
    }
}