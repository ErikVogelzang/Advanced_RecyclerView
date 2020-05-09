package com.example.advancedrecyclerview.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.advancedrecyclerview.R
import com.example.advancedrecyclerview.model.ColorItem
import kotlinx.android.synthetic.main.item_color.view.*

class ColorAdapter(val colorList: List<ColorItem>, private val onClick: (ColorItem) -> Unit) :
    RecyclerView.Adapter<ColorAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_color, parent, false)
        )
    }


    override fun getItemCount(): Int = colorList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(colorList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClick(colorList[adapterPosition]) }
        }
        fun bind(colorItem: ColorItem) {
            Glide.with(context).load(colorItem.getImageUrl()).into(itemView.ivColor)
        }
    }
}