package com.example.ecommercesiteforonlineshopping.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercesiteforonlineshopping.R
import com.example.ecommercesiteforonlineshopping.adapter.CartAdapter
import com.example.ecommercesiteforonlineshopping.adapter.ProductAdapter
import com.example.mylibrary.entity.Cart
import com.example.mylibrary.repository.CartRepo
import com.example.mylibrary.repository.RepoProduct
import kotlinx.android.synthetic.main.activity_view_product.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CartFragment : Fragment() {

    private lateinit var recyclerViewCart: RecyclerView
    private lateinit var adapter:CartAdapter

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        loadCartItems()
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        recyclerViewCart = view.findViewById(R.id.recyclerViewCart)
        adapter = CartAdapter( activity!!.applicationContext)
        recyclerViewCart.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        recyclerViewCart.adapter = adapter
        loadCartItems()


        return view
    }

    private fun loadCartItems() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val cartRepo = CartRepo()
                val response = cartRepo.getCartItems()
                response.data?.let { adapter.setList(it) }


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



