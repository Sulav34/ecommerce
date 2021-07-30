package com.example.ecommercesiteforonlineshopping


import com.example.mylibrary.entity.Customer
import com.example.mylibrary.repository.RepoCustomer
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class UnitTesting {
    private lateinit var customerRepository: RepoCustomer
    @Test
    fun checkLogin() = runBlocking {
        customerRepository = RepoCustomer()
        val response = customerRepository.loginUser("sulavstha@gmail.com", "123456")
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun registerCustomer() = runBlocking {
        val customer = Customer(
            firstname = "kriti",
            lastname = "joshi",
            email="kriti@gmail.com",
            password = "kriti123",
            address = "Lalitpur",
            phonenumber = "9822424234"
        )
       customerRepository = RepoCustomer()
        val response = customerRepository.registerCustomer(customer)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
     
}