package com.example.onlineshoppingwear

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.app.ActivityCompat
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        linearLayout = findViewById(R.id.linearLayout)
        etemail = findViewById(R.id.etemail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            login()


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
                    startActivity(
                        Intent(
                            this@LoginActivity,
                            MainActivity::class.java
                        )
                    )
                    finish()
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
}