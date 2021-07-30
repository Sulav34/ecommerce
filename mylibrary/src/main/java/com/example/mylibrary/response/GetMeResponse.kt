package com.example.mylibrary.response

import com.example.mylibrary.entity.User

class GetMeResponse (
    val success: Boolean? = null,
    val data: MutableList<User>? = null
)