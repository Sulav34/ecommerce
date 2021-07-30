package com.example.ecommercesiteforonlineshopping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommercesiteforonlineshopping.R

import com.example.mylibrary.api.ServiceBuilder
import com.example.mylibrary.entity.Cart
import com.example.mylibrary.repository.CartRepo
import com.example.mylibrary.response.ProductResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductAdapter(
    private val context: Context,




) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var listData: MutableList<ProductResponse> = ArrayList();

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvProductName: TextView = view.findViewById(R.id.tvPName)
        val tvPrice: TextView = view.findViewById(R.id.tvPprice)
        val tvSize: TextView = view.findViewById(R.id.tvPsize)
        val pimage: ImageView = view.findViewById(R.id.pimage)
        val btnaddcart: Button = view.findViewById(R.id.btnaddcart)
//        val btnUpdate: ImageButton = view.findViewById(R.id.btnUpdate)
//        val btnDelete: ImageButton = view.findViewById(R.id.btnDelete)
    }

    //override fun setProduct(List<Product> listOfProduct){
    //lstProduts=listOfProduct
    //notifiy dataset hange
    fun setList(list: List<ProductResponse>) {

        this.listData.addAll(list)
        notifyDataSetChanged();

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_layout, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = listData[position]
        holder.tvProductName.text = product.name
        holder.tvPrice.text = product.price.toString()
        holder.tvSize.text = product.size


        val imagePath = ServiceBuilder.loadImagePath() + product.image
        if (!product.image.equals("no-photo.jpg")) {
            Glide.with(context)
                .load(imagePath)
                .fitCenter()
                .into(holder.pimage)
        }
            holder.btnaddcart.setOnClickListener {
                val carts = Cart(
                    ProductName = product.name,
                    ProductPrice = product.price.toString(),
                    ProductSize = product.size
                )

                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val cartRepo = CartRepo()
                        val response = cartRepo.addItemToCart(carts)
                        if (response.success == true) {

                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    context,
                                    "${product.name} Added to Cart", Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                context,
                                ex.toString(), Toast.LENGTH_LONG
                            ).show()

                    }
                }
            }

        }


    }
        override fun getItemCount(): Int {
            return listData.size
        }
    }