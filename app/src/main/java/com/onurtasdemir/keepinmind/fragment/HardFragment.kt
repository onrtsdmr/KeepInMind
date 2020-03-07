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
import kotlinx.android.synthetic.main.fragment_hard.*

class HardFragment : Fragment(), View.OnClickListener {
    private var iconArrayList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iconArrayList = arguments?.getStringArrayList("iconArrayList")!!
        iconArrayList = (iconArrayList extArray 15)
        iconArrayList = iconArrayList.shuffle()
        hardImgView1.setOnClickListener(this)
        hardImgView2.setOnClickListener(this)
        hardImgView3.setOnClickListener(this)
        hardImgView4.setOnClickListener(this)
        hardImgView5.setOnClickListener(this)
        hardImgView6.setOnClickListener(this)
        hardImgView7.setOnClickListener(this)
        hardImgView8.setOnClickListener(this)
        hardImgView9.setOnClickListener(this)
        hardImgView10.setOnClickListener(this)
        hardImgView11.setOnClickListener(this)
        hardImgView12.setOnClickListener(this)
        hardImgView13.setOnClickListener(this)
        hardImgView14.setOnClickListener(this)
        hardImgView15.setOnClickListener(this)
        hardImgView16.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.hardImgView1 -> iconArrayList.extCheckCard(
                hardImgView1,
                view!!.context,
                0,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView2 -> iconArrayList.extCheckCard(
                hardImgView2,
                view!!.context,
                1,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView3 -> iconArrayList.extCheckCard(
                hardImgView3,
                view!!.context,
                2,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView4 -> iconArrayList.extCheckCard(
                hardImgView4,
                view!!.context,
                3,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView5 -> iconArrayList.extCheckCard(
                hardImgView5,
                view!!.context,
                4,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView6 -> iconArrayList.extCheckCard(
                hardImgView6,
                view!!.context,
                5,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView7 -> iconArrayList.extCheckCard(
                hardImgView7,
                view!!.context,
                6,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView8 -> iconArrayList.extCheckCard(
                hardImgView8,
                view!!.context,
                7,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView9 -> iconArrayList.extCheckCard(
                hardImgView9,
                view!!.context,
                8,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView10 -> iconArrayList.extCheckCard(
                hardImgView10,
                view!!.context,
                9,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView11 -> iconArrayList.extCheckCard(
                hardImgView11,
                view!!.context,
                10,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView12 -> iconArrayList.extCheckCard(
                hardImgView12,
                view!!.context,
                11,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView13 -> iconArrayList.extCheckCard(
                hardImgView13,
                view!!.context,
                12,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView14 -> iconArrayList.extCheckCard(
                hardImgView14,
                view!!.context,
                13,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView15 -> iconArrayList.extCheckCard(
                hardImgView15,
                view!!.context,
                14,
                arguments!!,
                Level.HARD.toString()
            )
            R.id.hardImgView16 -> iconArrayList.extCheckCard(
                hardImgView16,
                view!!.context,
                15,
                arguments!!,
                Level.HARD.toString()
            )
        }
    }
}
