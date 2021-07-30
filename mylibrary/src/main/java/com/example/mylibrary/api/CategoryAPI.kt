package com.example.mylibrary.api

import com.example.mylibrary.response.GetAllCategoriesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface CategoryAPI {
    @GET("category/all")
    suspend fun getAllCategories(
        @Header("Authorization") token: String,
    ): Response<GetAllCategoriesResponse>
}