package com.onurtasdemir.keepinmind.fragment

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.ui.MainActivity
import com.onurtasdemir.keepinmind.util.extStartActivity
import kotlinx.android.synthetic.main.fragment_finish_game.*

class FinishGameFragment : Fragment(R.layout.fragment_finish_game) {
    private var bundle = Bundle()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().findViewById<LinearLayout>(R.id.layout_statistic).visibility = View.GONE
        bundle.putStringArrayList(
            "iconArrayList",
            this.arguments!!.getStringArrayList("iconArrayList")!!
        )
        btn_finish.setOnClickListener {
            this.requireActivity().extStartActivity(MainActivity::class.java, bundle)
        }
    }
}