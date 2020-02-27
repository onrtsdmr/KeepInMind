package com.onurtasdemir.keepinmind.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.util.extArray
import com.onurtasdemir.keepinmind.util.extCheckCard
import com.onurtasdemir.keepinmind.util.shuffle
import kotlinx.android.synthetic.main.fragment_easy.*

class EasyFragment : Fragment(), View.OnClickListener {
    private var iconArrayList = ArrayList<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_easy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iconArrayList = arguments?.getStringArrayList("iconArrayList")!!
        iconArrayList = (iconArrayList extArray 3)
        iconArrayList = iconArrayList.shuffle()
        easyImgView1.setOnClickListener(this)
        easyImgView2.setOnClickListener(this)
        easyImgView3.setOnClickListener(this)
        easyImgView4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.easyImgView1 -> iconArrayList.extCheckCard(easyImgView1, view!!.context, 0)
            R.id.easyImgView2 -> iconArrayList.extCheckCard(easyImgView2, view!!.context, 1)
            R.id.easyImgView3 -> iconArrayList.extCheckCard(easyImgView3, view!!.context, 2)
            R.id.easyImgView4 -> iconArrayList.extCheckCard(easyImgView4, view!!.context, 3)
        }
    }
}
