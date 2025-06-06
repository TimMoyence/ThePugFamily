package com.asilidesign.thepugfamilly.features.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asilidesign.thepugfamilly.core.model.Category
import com.asilidesign.thepugfamilly.core.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCategories()
                _categories.value = response.record
            } catch (e: Exception) {
                // Log / handle error
            }
        }
    }
}