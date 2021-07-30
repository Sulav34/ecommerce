package com.example.mylibrary.response

import com.example.mylibrary.entity.Cart
import com.example.mylibrary.entity.Product

data class AddcartResponse (
    val success: Boolean? = null,
    val data: Cart? = null
)