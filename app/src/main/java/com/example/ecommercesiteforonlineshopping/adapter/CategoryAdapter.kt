package com.example.ecommercesiteforonlineshopping.adapter



import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommercesiteforonlineshopping.R
import com.example.ecommercesiteforonlineshopping.db.ProductDB

import com.example.ecommercesiteforonlineshopping.ui.UpdateProductActivity
import com.example.mylibrary.api.ServiceBuilder
import com.example.mylibrary.entity.Category
import com.example.mylibrary.entity.Product
import com.example.mylibrary.response.ProductResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoryAdapter(
    private val context: Context,
) : RecyclerView.Adapter<CategoryAdapter.ProductViewHolder>() {
    private var listData: MutableList<ProductResponse> = ArrayList();


    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvProductName: TextView = view.findViewById(R.id.tvPName)
        val tvPrice: TextView = view.findViewById(R.id.tvPprice)
        val tvSize: TextView = view.findViewById(R.id.tvPsize)
        val pimage: ImageView = view.findViewById(R.id.pimage)
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
            .inflate(R.layout.custom_categories, parent, false)
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

//        holder.btnUpdate.setOnClickListener {
//            val intent = Intent(context, UpdateProductActivity::class.java)
//            intent.putExtra("product", product)
//            context.startActivity(intent)
//        }

//        holder.btnDelete.setOnClickListener {
//
//            val builder = AlertDialog.Builder(context)
//            builder.setTitle("Delete Product")
//            builder.setMessage("Are you sure you want to delete ${product._id} ??")
//            builder.setIcon(android.R.drawable.ic_dialog_alert)
//            builder.setPositiveButton("Yes") { _, _ ->
////                deleteProduct(product)
//                listData.removeAt(position)
//                notifyDataSetChanged()
//            }
//            builder.setNegativeButton("No") { _, _ ->
//                Toast.makeText(context, "Action cancelled", Toast.LENGTH_SHORT).show()
//            }
//            val alertDialog: AlertDialog = builder.create()
//            alertDialog.setCancelable(false)
//            alertDialog.show()
//
//        }

    }


    override fun getItemCount(): Int {
        return listData.size
    }
}