package com.onurtasdemir.keepinmind.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.enums.Level
import com.onurtasdemir.keepinmind.util.extStartActivity
import kotlinx.android.synthetic.main.activity_level.*

class LevelActivity : AppCompatActivity(), View.OnClickListener {

    private var iconArrayList = ArrayList<String>()
    private val bundle = Bundle()
    private val TAG = "LEVEL"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level)
        iconArrayList = intent.getStringArrayListExtra("iconArrayList")!!
        bundle.putStringArrayList("iconArrayList",iconArrayList)
        btnEasy.setOnClickListener(this)
        btnNormal.setOnClickListener(this)
        btnHard.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnEasy -> { this extStartPlayActivity Level.EASY.toString() }
            R.id.btnNormal -> { this extStartPlayActivity Level.NORMAL.toString() }
            R.id.btnHard -> { this extStartPlayActivity Level.HARD.toString() }
        }
    }
    private infix fun Context.extStartPlayActivity(level: String){
        bundle.putString(TAG,level)
        this.extStartActivity(
            PlayActivity::class.java,
            bundle
        )
    }
}