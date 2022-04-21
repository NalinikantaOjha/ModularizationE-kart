package com.example.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.common.Status
import com.example.data.network.model.ResponseItem
import com.example.myapplication.R
import com.example.myapplication.ui.adapter.PostAdapter
import com.example.myapplication.viewmodel.ProjectViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val projectViewModel by viewModels<ProjectViewModel>()
    private val responseList = mutableListOf<ResponseItem>()
    private var postAdapter: PostAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        projectViewModel.getProducts()
        projectViewModel.responseliveData.observe(this) {

            when (it.status) {
                Status.SUCCESS -> {
                    responseList.clear()
                    responseList.addAll(it.data!!)
                    setRecyclerAdapter()
                }
                Status.ERROR -> {
              Toast.makeText(this,it.message.toString(),Toast.LENGTH_LONG).show()
                }

            }
        }
    }
    private fun setRecyclerAdapter() {
        postAdapter = PostAdapter()
        postAdapter!!.setData(responseList)
        val layoutManager = GridLayoutManager(this,2)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = postAdapter
        Progressbar.visibility= View.GONE}

}