package com.asilidesign.thepugfamilly.core.model

data class CategoryResponse(
    val record: List<Category>
)


data class Category(
    val category_id: String,
    val title: String,
    val products_url: String
)