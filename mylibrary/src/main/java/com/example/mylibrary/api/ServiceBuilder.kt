package com.example.mylibrary.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val BASE_URL =

  "http://10.0.2.2:90"
//"http://192.168.0.105:90/"

    //    private const val BASE_URL =
// "http://localhost:90/"
    var token: String? = null
    var id: String? = null

    private val okHttp =
        OkHttpClient.Builder()

    //create retrofit builder
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //create retrofit instance
    private val retrofit = retrofitBuilder.build()

    //generic function
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

    // Load image path in Service Builder class
    fun loadImagePath(): String {
        val arr = BASE_URL.split("/").toTypedArray()
        return arr[0] + "/" + arr[1] + arr[2] + "/"
    }
}