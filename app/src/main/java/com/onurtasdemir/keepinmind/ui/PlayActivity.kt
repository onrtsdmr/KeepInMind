package com.onurtasdemir.keepinmind.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.util.extSetLevelFragment

class PlayActivity : AppCompatActivity() {
    private var iconArrayList = ArrayList<String>()
    private var level: String = String()
    private val TAG = "LEVEL"
    private val bundle = Bundle()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        level = intent.getStringExtra(TAG)!!
        iconArrayList = intent.getStringArrayListExtra("iconArrayList")!!
        bundle.putStringArrayList("iconArrayList", iconArrayList)
        this.extSetLevelFragment(bundle, level)
    }
}