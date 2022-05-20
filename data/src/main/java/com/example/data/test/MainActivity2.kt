package com.example.data.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.data.R


class MainActivity2() : AppCompatActivity(){
    var a:Int=0
    val context=this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//       val intent=intent
//       val bundle= intent.getBundleExtra("nalini")
//        val data=bundle?.getInt("nalini")

        Log.d("naliniTestGetNowData",GetData.dataHead.returnName())
//       val c = Class.forName("GetData")
//        val ref: Data = c.newInstance() as Data
//     Log.d("naliniDataInt",ref.doSomething().toString())
    }

//    fun getData(data:ThereIsSomeDataToGet){
//       a=data.doSomething()
//        Log.d("naliniTestGetNowData",a.toString())
//    }



}
