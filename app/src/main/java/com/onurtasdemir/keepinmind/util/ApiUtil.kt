package com.onurtasdemir.keepinmind.util

import com.onurtasdemir.keepinmind.data.ApiClient
import com.onurtasdemir.keepinmind.model.ImageModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private val apiClient by lazy{ApiClient.getApiClient()}
private lateinit var iconArrayList: ArrayList<String>

fun getImages(){
    apiClient.getImages().enqueue(object : Callback<ImageModel> {
        override fun onFailure(call: Call<ImageModel>, t: Throwable) {

        }

        override fun onResponse(call: Call<ImageModel>, response: Response<ImageModel>) {
            if (response.isSuccessful){
                iconArrayList = response.body()?.iconArrayList!!
            }
        }

    })
}