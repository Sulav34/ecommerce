package com.example.mylibrary.response

import com.example.mylibrary.entity.Customer

class GetCustomerProfileResponse (
    val success: Boolean? = null,
    val data: Customer? = null,
    val id: String? = null
)