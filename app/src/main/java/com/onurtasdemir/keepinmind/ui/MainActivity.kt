package com.onurtasdemir.keepinmind.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onurtasdemir.keepinmind.R

class MainActivity : AppCompatActivity() {

    private var iconArrayList: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iconArrayList = intent.getStringArrayListExtra("iconArrayList")

    }
}

