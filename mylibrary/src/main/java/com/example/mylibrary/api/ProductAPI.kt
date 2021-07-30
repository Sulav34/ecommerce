package com.example.mylibrary.api


import com.example.mylibrary.response.ProductAPIresponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface ProductAPI {

    //Login customer
    @GET("api/product/list")
    suspend fun getProduct(

    ): Response<ProductAPIresponse>

//    @Multipart
//    @PUT("/products")
//    suspend fun uploadImage(
//        @Header("Authorization") token: String,
//        @Path("id") id: String,
//        @Part file: MultipartBody.Part
//    ): Response<ImageResponse>
}