package com.example.ecommercesiteforonlineshopping.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.ecommercesiteforonlineshopping.R
import com.example.ecommercesiteforonlineshopping.db.ProductDB

import com.example.mylibrary.entity.Product
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class AddProductActivity : AppCompatActivity() {

    private lateinit var etProductName: TextInputEditText
    private lateinit var etPrice: TextInputEditText
    private lateinit var etSize: TextInputEditText
    private lateinit var etBrand: TextInputEditText
    private lateinit var btnSave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        etProductName = findViewById(R.id.etProductName)
        etPrice = findViewById(R.id.etPrice)
        etSize = findViewById(R.id.etSize)
        etBrand = findViewById(R.id.etBrand)
        btnSave = findViewById(R.id.btnSave)


        btnSave.setOnClickListener {
            saveProduct()
        }


    }

    private fun saveProduct() {
            val ProductName = etProductName.text.toString()
            val Price = etPrice.text.toString().toInt()
            val Size= etSize.text.toString()
            val Brand= etBrand.text.toString()

            val product = Product(ProductName, Price, Size, Brand)
            try {
                CoroutineScope(Dispatchers.IO).launch {
                    ProductDB.getInstance(this@AddProductActivity).getProductDAO().insertProduct(product)
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@AddProductActivity, "Product Added", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (ex: Exception) {
                Toast.makeText(this, "Error ${ex.localizedMessage}", Toast.LENGTH_SHORT).show()
            }

        }
}
