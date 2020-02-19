package com.onurtasdemir.keepinmind.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.util.extEasyArray
import com.onurtasdemir.keepinmind.util.extSetBackground
import com.onurtasdemir.keepinmind.util.extToastShow
import kotlinx.android.synthetic.main.activity_easy.*

class EasyActivity : AppCompatActivity(), View.OnClickListener {

    private var iconArrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy)
        iconArrayList = intent.getStringArrayListExtra("iconArrayList")!!
        easyTime.setOnClickListener(this)
        imgView1.setOnClickListener(this)
        imgView2.setOnClickListener(this)
        imgView3.setOnClickListener(this)
        imgView4.setOnClickListener(this)
        iconArrayList = iconArrayList.extEasyArray()
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.imgView1->{
                imgView1 extSetBackground iconArrayList[0]
            }
            R.id.imgView2->{
                imgView2 extSetBackground iconArrayList[1]
            }
            R.id.imgView3->{
                imgView3 extSetBackground iconArrayList[2]
            }
            R.id.imgView4->{
                imgView4 extSetBackground iconArrayList[3]
            }
        }
    }
}
