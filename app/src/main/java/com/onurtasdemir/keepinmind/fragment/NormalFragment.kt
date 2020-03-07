package com.onurtasdemir.keepinmind.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.enums.Level
import com.onurtasdemir.keepinmind.util.extArray
import com.onurtasdemir.keepinmind.util.extCheckCard
import com.onurtasdemir.keepinmind.util.shuffle
import kotlinx.android.synthetic.main.fragment_normal.*


class NormalFragment : Fragment(), View.OnClickListener {
    private var iconArrayList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_normal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iconArrayList = arguments?.getStringArrayList("iconArrayList")!!
        iconArrayList = (iconArrayList extArray 7)
        iconArrayList = iconArrayList.shuffle()
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
                view!!.context,
                0,
                arguments!!,
                Level.NORMAL.toString()
            )
            R.id.normalImgView2 -> iconArrayList.extCheckCard(
                normalImgView2,
                view!!.context,
                1,
                arguments!!,
                Level.NORMAL.toString()
            )
            R.id.normalImgView3 -> iconArrayList.extCheckCard(
                normalImgView3,
                view!!.context,
                2,
                arguments!!,
                Level.NORMAL.toString()
            )
            R.id.normalImgView4 -> iconArrayList.extCheckCard(
                normalImgView4,
                view!!.context,
                3,
                arguments!!,
                Level.NORMAL.toString()
            )
            R.id.normalImgView5 -> iconArrayList.extCheckCard(
                normalImgView5,
                view!!.context,
                4,
                arguments!!,
                Level.NORMAL.toString()
            )
            R.id.normalImgView6 -> iconArrayList.extCheckCard(
                normalImgView6,
                view!!.context,
                5,
                arguments!!,
                Level.NORMAL.toString()
            )
            R.id.normalImgView7 -> iconArrayList.extCheckCard(
                normalImgView7,
                view!!.context,
                6,
                arguments!!,
                Level.NORMAL.toString()
            )
            R.id.normalImgView8 -> iconArrayList.extCheckCard(
                normalImgView8,
                view!!.context,
                7,
                arguments!!,
                Level.NORMAL.toString()
            )
        }
    }
}
