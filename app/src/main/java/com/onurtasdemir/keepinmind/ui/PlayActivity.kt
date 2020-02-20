package com.onurtasdemir.keepinmind.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.util.extArray

class PlayActivity : AppCompatActivity() {

    private var iconArrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        iconArrayList = intent.getStringArrayListExtra("iconArrayList")!!
        iconArrayList = (iconArrayList extArray 1)
    }

}
