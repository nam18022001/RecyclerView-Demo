package com.example.recycleviewdemo

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

class ExampleAdapter(private val exampleList: ArrayList<ExampleItem>) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgView = itemView.image_view
        val txtName = itemView.txtName
        val txtTuoi = itemView.txtTuoi

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val imgView = LayoutInflater.from(parent.context).inflate(R.layout.example_item, parent, false)


        return ExampleViewHolder(imgView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = exampleList[position]

        holder.imgView.setImageResource(currentItem.img)
        holder.txtName.text = currentItem.name
        holder.txtTuoi.text = currentItem.tuoi


    }

    override fun getItemCount() = exampleList.size
}