package com.example.mylibrary.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (

    val firstname: String? = null,
    val lastname: String? = null,
    val email: String? = null,
    val password: String? = null,
    val phonenumber: String? = null,
    val address: String? = null,
    val photo:String? = null
){
    @PrimaryKey(autoGenerate = true)
    var customer_id: Int = 0
}
