package com.example.ecommercesiteforonlineshopping.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.coroutines.Dispatchers
import androidx.core.content.contentValuesOf


import com.example.ecommercesiteforonlineshopping.R
import com.example.ecommercesiteforonlineshopping.ui.LoginActivity
import com.example.mylibrary.api.ServiceBuilder
import com.example.mylibrary.entity.Customer
import com.example.mylibrary.repository.RepoCustomer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*





class ProfileFragment : Fragment() {

    private lateinit var
            etname:EditText
    private lateinit var etemail:EditText
    private lateinit var etpassword:EditText
    private lateinit var etphone:EditText
    private lateinit var btnprofileupdate:Button

    @SuppressLint("WrongConstant")
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        loadCustomerDetails()
        val view =  inflater.inflate(R.layout.fragment_profile, container, false)

        etname = view!!.findViewById(R.id.Profilename)
        etemail = view!!.findViewById(R.id.Profileemail)
        etpassword = view!!.findViewById(R.id.Profilepassword)
        etphone = view!!.findViewById(R.id.Profilephone)
        btnprofileupdate = view.findViewById(R.id.btnprofileupdate)

        btnprofileupdate.setOnClickListener {
            updateDetails()
        }


        return view
    }

    private fun updateDetails() {

        val fname = etname.text.toString()
        val password = etpassword.text.toString()
        val email =  etemail.text.toString()
        val phone = etphone.text.toString()


        val customer =
            Customer(firstname = fname, password = password, email = email, phonenumber = phone)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val userRepo = RepoCustomer()
                val response = ServiceBuilder.id?.let { userRepo.updateUser(it, customer) }
                if (response != null) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                activity,
                                "Success", Toast.LENGTH_SHORT
                            ).show()


                        }
                    }

            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        activity,
                        "Error : ${ex.toString()}", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


    private fun loadCustomerDetails() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val customerRepo = RepoCustomer()
               val response = customerRepo.getMe(ServiceBuilder.id!!)

                if (response.success == true) {

//                    Log.d("User Id",fName.toString())
                    withContext(Main) {

                        etname.setText(response.data?.firstname)

                        etemail.setText(response.data?.email)
                        etpassword.setText(response.data?.password)
                        etphone.setText(response.data?.phonenumber)

                    }
                }
            } catch (ex: Exception) {
                withContext(Main) {
                    Toast.makeText(
                        activity,
                        "Error : ${ex.toString()}", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}



