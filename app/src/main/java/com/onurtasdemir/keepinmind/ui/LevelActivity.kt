package com.onurtasdemir.keepinmind.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.util.extIconWithStartActivity
import kotlinx.android.synthetic.main.activity_level.*

class LevelActivity : AppCompatActivity(), View.OnClickListener {

    private var iconArrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)
        iconArrayList = intent.getStringArrayListExtra("iconArrayList")!!
        btnEasy.setOnClickListener(this)
        btnNormal.setOnClickListener(this)
        btnHard.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnEasy -> {
                this.extIconWithStartActivity(
                    EasyActivity::class.java
                    ,
                    iconArrayList
                )
            }
            R.id.btnNormal -> {
                this.extIconWithStartActivity(
                    NormalActivity::class.java
                    ,
                    iconArrayList
                )
            }
            R.id.btnHard -> {
                this.extIconWithStartActivity(
                    HardActivity::class.java
                    ,
                    iconArrayList
                )
            }
        }
    }
}
