package com.example.mylibrary.response

import com.example.mylibrary.entity.Cart
import com.example.mylibrary.entity.Category

data class GetAllCartResponse(
    val success: Boolean? = null,
    val count: Int? = null,
    val data: MutableList<Cart>? = null
)