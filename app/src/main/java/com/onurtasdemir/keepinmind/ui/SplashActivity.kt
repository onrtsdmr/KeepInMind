package com.onurtasdemir.keepinmind.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.data.ApiClient
import com.onurtasdemir.keepinmind.enums.NetworkType
import com.onurtasdemir.keepinmind.model.ImageModel
import com.onurtasdemir.keepinmind.util.extSetRotateInAnimator
import com.onurtasdemir.keepinmind.util.extStartActivity
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : AppCompatActivity() {
    private val apiClient by lazy { ApiClient.getApiClient() }
    private var iconArrayList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        imgBrainSplash extSetRotateInAnimator 2000
        getImageArray()
    }

    infix fun String.extShowSnackbar(view: View) {
        Snackbar.make(
            view,
            this,
            Snackbar.LENGTH_INDEFINITE
        ).setAction(R.string.reload) {
            getImageArray()
        }
            .show()
    }

    private fun getImageArray() {
        apiClient.getImages().enqueue(object : Callback<ImageModel> {
            override fun onFailure(call: Call<ImageModel>, t: Throwable) {
                splashProgressBar.visibility = View.VISIBLE
                NetworkType.NO_NETWORK.toString() extShowSnackbar (findViewById<View>(R.id.splashFrameLayout))
            }

            override fun onResponse(call: Call<ImageModel>, response: Response<ImageModel>) {
                splashProgressBar.visibility = View.INVISIBLE
                splashCheckView.check()
                iconArrayList = response.body()?.iconArrayList!!
                4000L extCountDownTimer 1000
            }
        })
    }

    infix fun Long.extCountDownTimer(countDownTimer: Long) {
        object : CountDownTimer(this, countDownTimer) {
            override fun onFinish() {
                val bundle = Bundle()
                bundle.putStringArrayList("iconArrayList", iconArrayList)
                this@SplashActivity.extStartActivity(
                    MainActivity::class.java,
                    bundle
                )
                finish()
            }

            override fun onTick(millisUntilFinished: Long) {}
        }.start()
    }
}


