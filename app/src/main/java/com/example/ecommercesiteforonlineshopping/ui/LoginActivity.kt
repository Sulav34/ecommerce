package com.example.ecommercesiteforonlineshopping.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.ecommercesiteforonlineshopping.R
import com.example.mylibrary.api.ServiceBuilder
import com.example.mylibrary.repository.RepoCustomer
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {


    private lateinit var linearLayout: LinearLayout
    private lateinit var etemail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvsignup: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        linearLayout = findViewById(R.id.linearLayout)
        etemail = findViewById(R.id.etLoginEmail)
        etPassword = findViewById(R.id.etLoginPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvsignup = findViewById(R.id.tvSignup)
        btnLogin.setOnClickListener {
            login()


        }
        tvsignup.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }






    private fun login() {
        val email = etemail.text.toString()
        val password = etPassword.text.toString()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = RepoCustomer()
                val response = repository.loginUser(email, password)
                if (response.success == true) {
                    ServiceBuilder.token = "Bearer " + response.token
                    ServiceBuilder.id = response.id
                    startActivity(
                            Intent(
                                    this@LoginActivity,
                                   DashboardActivity::class.java
                            )
                    )
                    finish()
                    showLowPriorityNotification()
                } else {
                    withContext(Dispatchers.Main) {
                        val snack =
                                Snackbar.make(
                                        linearLayout,
                                        "Invalid credentials",
                                        Snackbar.LENGTH_LONG
                                )
                        snack.setAction("OK", View.OnClickListener {
                            snack.dismiss()
                        })
                        snack.show()
                    }
                }

            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                            this@LoginActivity,
                            ex.toString(), Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    private fun showLowPriorityNotification() {
        val notificationManager = NotificationManagerCompat.from(this)
        val notificationChannels = NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.CHANNEL_2)
            .setSmallIcon(R.drawable.notification)
            .setContentInfo("Low priority notification")
            .setContentText("You have logged in into your account!")
            .setColor(Color.BLUE)
            .build()
        notificationManager.notify(2, notification)

    }

}