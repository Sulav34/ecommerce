package com.example.ecommercesiteforonlineshopping.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercesiteforonlineshopping.R
import com.example.ecommercesiteforonlineshopping.adapter.ProductAdapter
import com.example.mylibrary.entity.Product
import com.example.mylibrary.repository.RepoCustomer
import com.example.mylibrary.repository.RepoProduct
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {



    private lateinit var recyclerView: RecyclerView
    private lateinit var viewOfLayout: View
    private lateinit var adapter:ProductAdapter



    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home2, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        adapter = ProductAdapter( activity!!.applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        recyclerView.adapter = adapter
        loadProductList()


        return view
    }


    private fun loadProductList() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val ProductRepository = RepoProduct()
                val response = ProductRepository.getProduct()
                adapter.setList(response.productsList);


            } catch (ex: Exception) {

                withContext(Main) {
                    Toast.makeText(
                        activity,
                        ex.toString(), Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


}