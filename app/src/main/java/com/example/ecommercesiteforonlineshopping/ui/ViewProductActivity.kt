package com.example.ecommercesiteforonlineshopping.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercesiteforonlineshopping.R
import com.example.ecommercesiteforonlineshopping.adapter.ProductAdapter
import com.example.ecommercesiteforonlineshopping.db.ProductDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewProductActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_product)

        recyclerView = findViewById(R.id.recyclerView)

//        CoroutineScope(Dispatchers.IO).launch {
//            val lstProduct = ProductDB.getInstance(this@ViewProductActivity).getProductDAO().getAllProducts()
//
//            withContext(Dispatchers.Main){
//                recyclerView.adapter = ProductAdapter(this@ViewProductActivity,lstProduct)
//                recyclerView.layoutManager = LinearLayoutManager(this@ViewProductActivity)
//            }
//        }
    }
}
