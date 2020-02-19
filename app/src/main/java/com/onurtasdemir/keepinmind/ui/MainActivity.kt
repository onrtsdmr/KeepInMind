package com.onurtasdemir.keepinmind.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.util.extIconWithStartActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var iconArrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iconArrayList = intent.getStringArrayListExtra("iconArrayList")!!
        btn_play.setOnClickListener {
            this.extIconWithStartActivity(LevelActivity::class.java, iconArrayList)
        }
    }
}

