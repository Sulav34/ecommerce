package com.example.mylibrary.response

import com.example.mylibrary.entity.User

data class UpdateUserResponse(
    val success: Boolean? = null,
    val data: User? = null
)