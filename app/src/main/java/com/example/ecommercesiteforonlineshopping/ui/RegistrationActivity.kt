package com.example.ecommercesiteforonlineshopping.ui

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.ecommercesiteforonlineshopping.ui.LoginActivity
import com.example.ecommercesiteforonlineshopping.R
import com.example.mylibrary.entity.Customer
import com.example.mylibrary.repository.RepoCustomer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RegistrationActivity : AppCompatActivity() {
    private lateinit var firstname: EditText
    private lateinit var lastname: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cnfpassword: EditText
    private lateinit var phone: EditText
    private lateinit var add: EditText
    private lateinit var btnregister: Button
    private lateinit var tvsignin: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        firstname = findViewById(R.id.etfname)
        lastname = findViewById(R.id.etLname)
        email = findViewById(R.id.etEmail)
        password = findViewById(R.id.etPassword)
        cnfpassword = findViewById(R.id.etCnfpassword)
        add = findViewById(R.id.etAddress)
        phone = findViewById(R.id.etContact)

        btnregister = findViewById(R.id.btnregister)
        tvsignin = findViewById(R.id.tvSignin)

        tvsignin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            //    intent.putExtra("customerName", firstname.text.toString())
            startActivity(intent)
        }

        btnregister.setOnClickListener {


            val fname = firstname.text.toString()
            val lname = lastname.text.toString()
            val email = email.text.toString()
            val pass = password.text.toString()
            val cPassword = cnfpassword.text.toString()
            val address = add.text.toString()
            val phonenumber = phone.text.toString()

            if (pass != cPassword) {
                password.error = "Password does not match"
                password.requestFocus()
                return@setOnClickListener
            } else {
                val customer = Customer(
                    firstname = fname,
                    lastname = lname,
                    email = email,
                    password = pass,
                    phonenumber = phonenumber,
                    address = address
                )

                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val customerRepository = RepoCustomer()
                        val response = customerRepository.registerCustomer(customer)
                        if (response.success == true) {

                            //response (List<Product>)
                            //adapter.setValue(response)
//                            ServiceBuilder.token = "Bearer ${response.token}"
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@RegistrationActivity,
                                    "User Registered", Toast.LENGTH_SHORT
                                ).show()
                                showHighPriorityNotification()

                            }
                        }

                    } catch (ex: Exception) {
                        withContext(Main) {
                            Toast.makeText(
                                this@RegistrationActivity,
                                ex.toString(), Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            }
        }
    }

    private fun showHighPriorityNotification() {
        val notificationManager = NotificationManagerCompat.from(this)
        val notificationChannels = NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.CHANNEL_1)
            .setSmallIcon(R.drawable.notification)
            .setContentInfo("High priority notification")
            .setContentText("You have been registered as user in SMBK Wears!!")
            .setColor(Color.BLUE)
            .build()
        notificationManager.notify(1, notification)
    }
}


