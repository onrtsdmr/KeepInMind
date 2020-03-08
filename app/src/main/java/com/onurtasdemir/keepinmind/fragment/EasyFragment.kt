package com.onurtasdemir.keepinmind.fragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.enums.Level
import com.onurtasdemir.keepinmind.util.extArray
import com.onurtasdemir.keepinmind.util.extCheckCard
import com.onurtasdemir.keepinmind.util.onCountDown
import com.onurtasdemir.keepinmind.util.shuffle
import kotlinx.android.synthetic.main.fragment_easy.*

class EasyFragment : Fragment(R.layout.fragment_easy), View.OnClickListener {
    private var iconArrayList = ArrayList<String>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iconArrayList = arguments?.getStringArrayList("iconArrayList")!!
        iconArrayList = (iconArrayList extArray 3)
        iconArrayList = iconArrayList.shuffle()
        this.onCountDown(arguments!!, Level.EASY.toString())
        easyImgView1.setOnClickListener(this)
        easyImgView2.setOnClickListener(this)
        easyImgView3.setOnClickListener(this)
        easyImgView4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.easyImgView1 -> iconArrayList.extCheckCard(
                easyImgView1,
                this,
                0,
                arguments!!,
                Level.NORMAL.toString()
            )
            R.id.easyImgView2 -> iconArrayList.extCheckCard(
                easyImgView2,
                this,
                1,
                arguments!!,
                Level.NORMAL.toString()
            )
            R.id.easyImgView3 -> iconArrayList.extCheckCard(
                easyImgView3,
                this,
                2,
                arguments!!,
                Level.NORMAL.toString()
            )
            R.id.easyImgView4 -> iconArrayList.extCheckCard(
                easyImgView4,
                this,
                3,
                arguments!!,
                Level.NORMAL.toString()
            )
        }
    }
}
