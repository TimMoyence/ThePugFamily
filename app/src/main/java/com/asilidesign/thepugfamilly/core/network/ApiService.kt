package com.asilidesign.thepugfamilly.core.network

import ProductResponse
import com.asilidesign.thepugfamilly.core.model.CategoryResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET("b/6760342bacd3cb34a8ba8657")
    suspend fun getCategories(): CategoryResponse

    @GET
    suspend fun getProducts(@Url url: String): ProductResponse
}