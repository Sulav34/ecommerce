package com.example.mylibrary.repository

import com.example.mylibrary.api.CategoryAPI
import com.example.mylibrary.api.MyApiRequest
import com.example.mylibrary.api.ServiceBuilder
import com.example.mylibrary.response.GetAllCategoriesResponse

class CategoryRepo: MyApiRequest() {
    private val categoryAPI = ServiceBuilder.buildService(CategoryAPI::class.java)

    suspend fun getAllCategories(): GetAllCategoriesResponse {
        return apiRequest {
            categoryAPI.getAllCategories(ServiceBuilder.token!!)
        }
    }

}