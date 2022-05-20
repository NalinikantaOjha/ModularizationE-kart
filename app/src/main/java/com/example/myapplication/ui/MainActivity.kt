package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.common.Status
import com.example.data.network.model.ResponseItem
import com.example.data.test.Data
import com.example.data.test.GetData
import com.example.myapplication.R
import com.example.myapplication.ui.adapter.PostAdapter
import com.example.myapplication.viewmodel.ProjectViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity(),Data {
    private val projectViewModel by viewModels<ProjectViewModel>()
    private val responseList = mutableListOf<ResponseItem>()
    private var postAdapter: PostAdapter? = null
//    lateinit var  listner:ThereIsSomeDataToGet
    val context=this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        var navCom=object:ThereIsSomeDataToGet {
//            override fun doSomething(): Int {
//                return 5
//            }
//        }

        btnTestIntent.setOnClickListener {
                    GetData(this)

            try{
                val intent = Intent()
                intent.setClassName(this, "com.example.data.test.MainActivity2")
                startActivity(intent)
        } catch (e: ClassNotFoundException) {
                e.printStackTrace()
                Log.d("naliniTestIntent",e.toString())
            }
        }

        projectViewModel.getProducts("nalini")
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
        if (postAdapter!=null){
            postAdapter!!.setData(responseList)
            val layoutManager = GridLayoutManager(this,2)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = postAdapter
            Progressbar.visibility= View.GONE
        }
        }

    override fun returnAge(): Int {
return 5
    }

    override fun returnName(): String {
return "Bharathi"   }

    override fun returnCategory(): String {
      return "Android Developer"
    }


}