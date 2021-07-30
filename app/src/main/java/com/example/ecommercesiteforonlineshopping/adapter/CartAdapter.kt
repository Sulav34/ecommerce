package com.example.ecommercesiteforonlineshopping.adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommercesiteforonlineshopping.R
import com.example.mylibrary.entity.Cart
import com.example.mylibrary.repository.CartRepo
import com.example.mylibrary.response.ProductResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CartAdapter(
    private val context: Context,
)
    : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private var listData: MutableList<Cart> = ArrayList();
    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.Pname)
        val price: TextView = view.findViewById(R.id.Pprice)
        val size: TextView = view.findViewById(R.id.Psize)
       val delete: ImageButton = view.findViewById(R.id.delete)
    }

    fun setList(list: List<Cart>) {

        this.listData.addAll(list)
        notifyDataSetChanged();
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_cart, parent, false)
        return CartViewHolder(view)

    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val cart = listData[position]
        holder.name.text = cart.ProductName
        holder.price.text = cart.ProductPrice.toString()
        holder.size.text= cart.ProductSize

        holder.delete.setOnClickListener {

            Toast. makeText(context,"Item deleted",Toast. LENGTH_SHORT)
//            val builder = AlertDialog.Builder(context)
//            builder.setTitle("Delete student")
//            builder.setMessage("Are you sure you want to delete ${cart.ProductName} ?")
//            builder.setIcon(android.R.drawable.ic_delete)
//            builder.setPositiveButton("Yes") { _, _ ->
//
//                CoroutineScope(Dispatchers.IO).launch {
//                    try {
//                        val cartRepo = CartRepo()
//                        val response = cartRepo.deleteCartItem(cart._id!!)
//                        if (response.success == true) {
//                            withContext(Dispatchers.Main) {
//                                Toast.makeText(
//                                    context,
//                                    "${cart.ProductName} deleted from Cart!!",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            }
//                            withContext(Dispatchers.Main) {
//                                listData.remove(cart)
//                                notifyDataSetChanged()
//                            }
//                        }
//                    } catch (ex: Exception) {
//                        withContext(Dispatchers.Main) {
//                            Toast.makeText(
//                                context,
//                                ex.toString(),
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }
//                    }
//                }
//            }
//            builder.setNegativeButton("No") { _, _ ->
//            }
//            val alertDialog: AlertDialog = builder.create()
//            alertDialog.setCancelable(false)
//
//            alertDialog.show()
//        }
        }
    }


    override fun getItemCount(): Int {
        return listData.size
    }
}
