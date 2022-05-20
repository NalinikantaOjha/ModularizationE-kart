package com.example.data.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.data.R

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        android.util.Log.d("naliniTestGetNowData",GetData.dataHead.returnCategory())

    }
}