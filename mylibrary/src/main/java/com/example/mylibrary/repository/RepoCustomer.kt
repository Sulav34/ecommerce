package com.example.mylibrary.repository

import com.example.mylibrary.api.CustomerAPI
import com.example.mylibrary.api.MyApiRequest
import com.example.mylibrary.api.ServiceBuilder
import com.example.mylibrary.entity.Customer
import com.example.mylibrary.response.GetCustomerProfileResponse
import com.example.mylibrary.response.LoginResponse
import com.example.mylibrary.response.UpdateUserResponse


class RepoCustomer : MyApiRequest() {
    private val CustomerAPI = ServiceBuilder.buildService(CustomerAPI::class.java)

    //Register User
    suspend fun registerCustomer(customer: Customer): LoginResponse {
        return apiRequest {
            CustomerAPI.registerCustomer(customer)

        }
    }

    //Login User
    suspend fun loginUser(email: String, password:String): LoginResponse {
        return apiRequest {
            CustomerAPI.checkCustomer(email, password)
        }
    }

    suspend fun updateUser(id:String, user: Customer): UpdateUserResponse {
        return apiRequest {
            CustomerAPI.updateUser(id, user)
        }
    }

        suspend fun getMe(id:String): GetCustomerProfileResponse {
            return apiRequest {
                CustomerAPI.getMe(id,ServiceBuilder.token!!)
            }
        }




}






