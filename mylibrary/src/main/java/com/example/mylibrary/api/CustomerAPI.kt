
package com.example.mylibrary.api

import com.example.mylibrary.entity.Customer
import com.example.mylibrary.response.GetCustomerProfileResponse
import com.example.mylibrary.response.LoginResponse
import com.example.mylibrary.response.ProductAPIresponse
import com.example.mylibrary.response.UpdateUserResponse
import retrofit2.Response
import retrofit2.http.*

interface CustomerAPI {
    //register customer
    @POST("customer/register")
    suspend fun registerCustomer(
        @Body customer: Customer
    ): Response<LoginResponse>

    //Login customer
    @FormUrlEncoded
    @POST("customer/login")
    suspend fun checkCustomer(
        @Field("email") email: String,
        @Field ("password") password: String
    ): Response<LoginResponse>

    @GET("/me/{id}")
    suspend fun getMe(
        @Path ("id") id: String,
        @Header ("Authorization") token: String,
    ): Response<GetCustomerProfileResponse>

    @PUT("/update/customer/{id}")
    suspend fun updateUser(
        @Path("id") id: String,
        @Body user: Customer
    ): Response<UpdateUserResponse>

}




