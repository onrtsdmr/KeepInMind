package com.onurtasdemir.keepinmind.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.util.extStartActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        object : CountDownTimer(2000,1000){
            override fun onFinish() {
                this@SplashActivity extStartActivity MainActivity::class.java
            }

            override fun onTick(millisUntilFinished: Long) {

            }

        }.start()
    }
}
