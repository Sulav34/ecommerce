package com.example.mylibrary.api

import com.example.mylibrary.entity.Cart
import com.example.mylibrary.response.AddcartResponse
import com.example.mylibrary.response.DeleteCartResponse
import com.example.mylibrary.response.GetAllCartResponse
import com.example.mylibrary.response.ProductAPIresponse
import retrofit2.Response
import retrofit2.http.*

interface CartAPI {
    @POST("/add/cart")
    suspend fun addItemToCart(
        @Header("Authorization") token: String,
        @Body cart: Cart
    ): Response<AddcartResponse>

    @GET("cart/all")
    suspend fun getCartItems(
        @Header("Authorization") token: String,
    ): Response<GetAllCartResponse>

    @DELETE("delete/{id}")
    suspend fun deleteCartItem(
        @Header ("Authorization") token: String,
        @Path("id") id: String
    ):Response<DeleteCartResponse>
}