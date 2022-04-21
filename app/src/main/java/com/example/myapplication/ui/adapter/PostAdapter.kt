package com.example.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.data.network.model.ResponseItem
import com.example.myapplication.R

class PostAdapter(): RecyclerView.Adapter<PostViewHolder>() {
    private var responseClassList: MutableList<ResponseItem> =ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val responseClass = responseClassList[position]
        holder.setData(responseClass)    }

    override fun getItemCount(): Int {
    return responseClassList.size
    }

    fun setData(newList:MutableList<ResponseItem>){
        val diffUtil= EkartDiffUtil(responseClassList,newList)
        val diffResult=DiffUtil.calculateDiff(diffUtil)
        responseClassList=newList
        diffResult.dispatchUpdatesTo(this)

    }
}