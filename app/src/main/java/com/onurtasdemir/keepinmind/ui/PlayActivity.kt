package com.onurtasdemir.keepinmind.ui

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.util.extSetLevelFragment
import kotlinx.android.synthetic.main.activity_play.*

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
        extSetLevelFragment(bundle, level)
        onCountDown()
    }

    private fun onCountDown() {
        object : CountDownTimer(60000, 1000) {
            override fun onFinish() {

            }

            override fun onTick(millisUntilFinished: Long) {
                txtPlayTime.text = (millisUntilFinished / 1000).toString()
            }

        }.start()
    }
}