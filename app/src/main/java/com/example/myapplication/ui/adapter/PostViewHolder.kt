package com.example.myapplication.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.data.network.model.ResponseItem
import kotlinx.android.synthetic.main.item_layout.view.*

class PostViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    fun setData(responseClass: ResponseItem) {

        itemView.apply {



            tvTitle.text = responseClass.title

            Glide.with(this)
                .load(responseClass.image)
                .into(ivImageView2)


            tvPrice.text = " ₹ "+responseClass.price.toString() + ""

        }


    }
}