package com.onurtasdemir.keepinmind.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.util.extStartActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var iconArrayList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iconArrayList = intent.getStringArrayListExtra("iconArrayList")!!
        val bundle = Bundle()
        btn_play.setOnClickListener {
            bundle.putStringArrayList("iconArrayList",iconArrayList)
            this.extStartActivity(LevelActivity::class.java,bundle)
        }
    }

    override fun onBackPressed() {
        dialogExit()
    }
    private fun dialogExit(){
        MaterialAlertDialogBuilder(this)
            .setTitle("Çıkış")
            .setMessage("Gerçekten çıkış yapmak istiyor musun ? :'(")
            .setPositiveButton("Evet") { dialog, which ->
                this.finishAffinity()
            }
            .setNegativeButton("Hayır") { dialog, which ->

            }
            .setCancelable(false)
            .show()
    }

}