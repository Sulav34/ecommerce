package com.example.ecommercesiteforonlineshopping.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercesiteforonlineshopping.R
import com.example.ecommercesiteforonlineshopping.adapter.CategoryAdapter
import com.example.ecommercesiteforonlineshopping.adapter.ProductAdapter
import com.example.mylibrary.entity.Category
import com.example.mylibrary.repository.CategoryRepo
import com.example.mylibrary.repository.RepoProduct
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CategoriesFragment : Fragment() {



    private lateinit var recyclerView: RecyclerView
    private lateinit var viewOfLayout: View
    private lateinit var adapter: CategoryAdapter


    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_categories, container, false)

        recyclerView = view.findViewById(R.id.recyclercategory)
        adapter = CategoryAdapter( activity!!.applicationContext)
        recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext, OrientationHelper.HORIZONTAL, false)
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

                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        activity,
                        ex.toString(), Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }


}