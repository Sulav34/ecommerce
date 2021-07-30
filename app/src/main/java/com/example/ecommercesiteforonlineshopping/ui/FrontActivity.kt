package com.example.ecommercesiteforonlineshopping.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ecommercesiteforonlineshopping.R

class FrontActivity : AppCompatActivity() {
    private lateinit var btnloginfront:Button
    private lateinit var btnregistrationfront:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front)

        btnloginfront = findViewById(R.id.btnloginfront)
        btnregistrationfront = findViewById(R.id.btnregistrationfront)

        btnloginfront.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btnregistrationfront.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}