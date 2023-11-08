package com.example.farmersapp.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.farmersapp.DescriptionActivity
import com.example.farmersapp.R
import com.example.farmersapp.models.CropItem

class AboutCropAdapter(private val mList: List<CropItem>) :
    RecyclerView.Adapter<AboutCropAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.crop_card, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]

        Glide.with(holder.itemView.context).load(itemsViewModel.image).into(holder.imageView)

        holder.textView.text = itemsViewModel.name
        holder.item.setOnClickListener { V ->
            val intent = Intent(V.context, DescriptionActivity::class.java)
            intent.putExtra("N", itemsViewModel.N)
            intent.putExtra("P", itemsViewModel.P)
            intent.putExtra("K", itemsViewModel.K)
            intent.putExtra("pesticide", itemsViewModel.pesticide)
            intent.putExtra("season", itemsViewModel.season)
            V.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView2)
        val textView: TextView = itemView.findViewById(R.id.textView5)
        val item: LinearLayout = itemView.findViewById(R.id.cropItem)
    }
}