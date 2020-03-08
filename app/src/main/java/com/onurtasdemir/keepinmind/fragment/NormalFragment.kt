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
import kotlinx.android.synthetic.main.fragment_normal.*


class NormalFragment : Fragment(R.layout.fragment_normal), View.OnClickListener {
    private var iconArrayList = ArrayList<String>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iconArrayList = arguments?.getStringArrayList("iconArrayList")!!
        iconArrayList = (iconArrayList extArray 7)
        iconArrayList = iconArrayList.shuffle()
        this.onCountDown(arguments!!, Level.NORMAL.toString())
        normalImgView1.setOnClickListener(this)
        normalImgView2.setOnClickListener(this)
        normalImgView3.setOnClickListener(this)
        normalImgView4.setOnClickListener(this)
        normalImgView5.setOnClickListener(this)
        normalImgView6.setOnClickListener(this)
        normalImgView7.setOnClickListener(this)
        normalImgView8.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.normalImgView1 -> iconArrayList.extCheckCard(
                normalImgView1,
                this,
                0,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.normalImgView2 -> iconArrayList.extCheckCard(
                normalImgView2,
                this,
                1,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.normalImgView3 -> iconArrayList.extCheckCard(
                normalImgView3,
                this,
                2,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.normalImgView4 -> iconArrayList.extCheckCard(
                normalImgView4,
                this,
                3,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.normalImgView5 -> iconArrayList.extCheckCard(
                normalImgView5,
                this,
                4,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.normalImgView6 -> iconArrayList.extCheckCard(
                normalImgView6,
                this,
                5,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.normalImgView7 -> iconArrayList.extCheckCard(
                normalImgView7,
                this,
                6,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.normalImgView8 -> iconArrayList.extCheckCard(
                normalImgView8,
                this,
                7,
                arguments!!,
                Level.HARD.toString()
            )
        }
    }
}
