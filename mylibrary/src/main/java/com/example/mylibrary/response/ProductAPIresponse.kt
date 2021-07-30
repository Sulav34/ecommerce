package com.example.mylibrary.response

data class  ProductAPIresponse (

val success: Boolean? = null,
val length : Int,
val productsList : List<ProductResponse>
)
