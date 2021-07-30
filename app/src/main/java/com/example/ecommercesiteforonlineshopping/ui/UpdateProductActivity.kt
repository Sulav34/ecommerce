package com.example.ecommercesiteforonlineshopping.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.ecommercesiteforonlineshopping.R
import com.example.ecommercesiteforonlineshopping.db.ProductDB

import com.example.mylibrary.entity.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateProductActivity : AppCompatActivity() {
    private lateinit var etProductName : EditText
    private lateinit var etPrice : EditText
    private lateinit var btnUpdate : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_product)
        etProductName = findViewById(R.id.etProductName)
        etPrice = findViewById(R.id.etPrice)
        btnUpdate = findViewById(R.id.btnUpdate)

        val intent = intent.getParcelableExtra<Product>("product")
        if (intent != null) {
            etProductName.setText(intent.ProductName)
            etPrice.setText(intent.Price.toString())
        }

        btnUpdate.setOnClickListener {
            val product = Product(ProductName = etProductName.text.toString(),Price = etPrice.text.toString().toInt())
            product.PId = intent!!.PId

            CoroutineScope(Dispatchers.IO).launch {
                ProductDB.getInstance(this@UpdateProductActivity).getProductDAO().updateProduct(product)
//                withContext(Main){
                startActivity(Intent(this@UpdateProductActivity,ViewProductActivity::class.java))
//                }
            }
        }

    }
}