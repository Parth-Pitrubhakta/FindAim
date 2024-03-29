package com.example.findaim.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.findaim.R
import com.example.findaim.R.id.itemImage
import com.example.findaim.R.id.itemImages_cardview
import com.example.findaim.data.Imagedata


class ImagesAdapter(var Images_data: List<Imagedata>) : RecyclerView.Adapter<ImagesAdapter.IntViewHolder>() {
    class IntViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val imageView = row.findViewById<ImageView>(itemImage)
        val cardView = row.findViewById<CardView>(itemImages_cardview)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_images,parent,false)
        layout.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_jobDetailsFragment)
        }
        val holder= IntViewHolder(layout)
        return holder
    }

    override fun onBindViewHolder(holder: IntViewHolder, position: Int) {
        holder.cardView.animation = AnimationUtils.loadAnimation(holder.itemView.context,R.anim.example_anims)
        val item=Images_data[position]
        holder.imageView.setBackgroundResource(item.img)
    }

    override fun getItemCount(): Int {
        return Images_data.size

    }
}