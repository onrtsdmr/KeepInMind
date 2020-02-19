package com.onurtasdemir.keepinmind.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.util.getImages

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getImages()

    }
}
