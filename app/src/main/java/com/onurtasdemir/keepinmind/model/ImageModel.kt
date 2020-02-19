package com.onurtasdemir.keepinmind.model

import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("icon")
    val iconArrayList: ArrayList<String>
)