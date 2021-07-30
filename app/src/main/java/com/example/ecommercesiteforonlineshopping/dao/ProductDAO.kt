package com.example.ecommercesiteforonlineshopping.dao

import androidx.room.*

import com.example.mylibrary.entity.Product

@Dao
interface ProductDAO {
    @Insert
    suspend fun insertProduct(product: Product)

    @Query("SELECT * FROM Product")
    suspend fun getAllProducts() : List<Product>

    @Update
    suspend fun updateProduct(product : Product)

    @Delete
    suspend fun deleteProduct(product : Product)
}