package com.onurtasdemir.keepinmind.ui

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.data.ApiClient
import com.onurtasdemir.keepinmind.model.ImageModel
import com.onurtasdemir.keepinmind.util.extIconWithStartActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SplashActivity : AppCompatActivity() {
    private val apiClient by lazy { ApiClient.getApiClient() }
    private var iconArrayList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        apiClient.getImages().enqueue(object : Callback<ImageModel> {
            override fun onFailure(call: Call<ImageModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<ImageModel>, response: Response<ImageModel>) {
                iconArrayList = response.body()?.iconArrayList!!
                object : CountDownTimer(1500, 1000) {
                    override fun onFinish() {
                        this@SplashActivity.extIconWithStartActivity(
                            MainActivity::class.java,
                            iconArrayList
                        )
                        finish()
                    }

                    override fun onTick(millisUntilFinished: Long) {

                    }
                }.start()
            }
        })
    }
}
