package com.example.itc362_hw8_ex2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.itc362_hw8_ex2.api.ApodResponse

class ApodAdapter(private val photos: List<ApodResponse>, private val onClick: (ApodResponse) -> Unit) :
    RecyclerView.Adapter<ApodAdapter.ApodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_apod, parent, false)
        return ApodViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApodViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
        holder.itemView.setOnClickListener { onClick(photo) }
    }

    override fun getItemCount() = photos.size

    class ApodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val titleView: TextView = itemView.findViewById(R.id.titleView)

        fun bind(photo: ApodResponse) {
            titleView.text = photo.title
            imageView.load(photo.url)
        }
    }
}