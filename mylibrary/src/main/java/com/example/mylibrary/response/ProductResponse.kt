package com.example.mylibrary.response

data class ProductResponse(


        val rating: Int,
        val numReviews: Int,
        val _id: String,
        val name: String,
        val price: Int,
        val size: String,
        val image: String,
        val reviews: List<String>,
        val createdAt: String,
        val updatedAt: String,
        val slug: String
)

