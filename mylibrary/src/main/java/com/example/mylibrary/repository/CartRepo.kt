package com.example.mylibrary.repository

import com.example.mylibrary.api.CartAPI
import com.example.mylibrary.api.MyApiRequest
import com.example.mylibrary.api.ServiceBuilder
import com.example.mylibrary.entity.Cart
import com.example.mylibrary.response.AddcartResponse
import com.example.mylibrary.response.DeleteCartResponse
import com.example.mylibrary.response.GetAllCartResponse
import com.example.mylibrary.response.ProductAPIresponse

class CartRepo: MyApiRequest() {

    private val cartAPI = ServiceBuilder.buildService(CartAPI::class.java)

    suspend fun addItemToCart(cart: Cart): AddcartResponse {
        return apiRequest {
            cartAPI.addItemToCart(
                ServiceBuilder.token!!, cart
            )
        }
    }


    suspend fun getCartItems(): GetAllCartResponse {
        return apiRequest {
            cartAPI.getCartItems(ServiceBuilder.token!!)
        }
    }

    suspend fun deleteCartItem(id: String): DeleteCartResponse {
        return apiRequest {
            cartAPI.deleteCartItem(ServiceBuilder.token!!, id)
        }
    }
}

