package com.example.mylibrary.repository

import com.example.mylibrary.api.MyApiRequest
import com.example.mylibrary.api.ProductAPI
import com.example.mylibrary.api.ServiceBuilder

import com.example.mylibrary.response.ProductAPIresponse
import okhttp3.MultipartBody

class RepoProduct: MyApiRequest() {
    private val ProductAPI = ServiceBuilder.buildService(ProductAPI::class.java)
    suspend fun getProduct(): ProductAPIresponse {
        return  apiRequest {
            ProductAPI.getProduct()
        }
    }
//    suspend fun uploadImage(id: String, body: MultipartBody.Part)
//            : ImageResponse {
//        return apiRequest {
//            ProductAPI.uploadImage(ServiceBuilder.token!!, id, body)
//        }
//    }
}