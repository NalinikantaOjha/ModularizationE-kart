package com.example.myapplication.ui.adapter

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import com.example.data.network.model.ResponseItem

class EkartDiffUtil(private val oldList:MutableList<ResponseItem>, private val newList:MutableList<ResponseItem>):DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
return newList.size   }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        Log.d("check","areItemsTheSame call")
return oldList[oldItemPosition].id==newList[newItemPosition].id
  }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        Log.d("check","areContentsTheSame ")

        return oldList[oldItemPosition].id==newList[newItemPosition].id

    }
}