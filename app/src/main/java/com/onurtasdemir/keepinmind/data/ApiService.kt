package com.onurtasdemir.keepinmind.data

import com.onurtasdemir.keepinmind.model.ImageModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService{
    @GET("$API_CALL/images.json")
    fun getImages(): Call<ImageModel>

    companion object{
        private const val API_CALL = "fruit/icon"
    }
}