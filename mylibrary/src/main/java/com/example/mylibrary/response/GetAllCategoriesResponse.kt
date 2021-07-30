package com.example.mylibrary.response

import com.example.mylibrary.entity.Category

data class GetAllCategoriesResponse(
    val success: Boolean? = null,
    val data: MutableList<Category>? = null
)