package com.onurtasdemir.keepinmind.util

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList


fun <T> Array<T>.shuffle(): Array<T> {
    val rng = Random()
    for (index in this.indices) {
        val randomIndex = rng.nextInt(index)
        val temp = this[index]
        this[index] = this[randomIndex]
        this[randomIndex] = temp
    }
    return this
}

fun <T>Context.extIconWithStartActivity(cls: Class<T>,data: ArrayList<String>){
    startActivity(Intent(this,cls).putStringArrayListExtra("iconArrayList",data))
}

infix fun String.extToastShow(context: Context){
    Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
}

fun ArrayList<String>.extEasyArray(): ArrayList<String>{
    val arrayList = ArrayList<String>()
    for (i in 0..3){
        arrayList.add(this[i])
    }
    arrayList.shuffle()
    return arrayList
}
fun ArrayList<String>.extNormalArray(): ArrayList<String>{
    val arrayList = ArrayList<String>()
    for (i in 0..8){
        arrayList.add(this[i])
    }
    arrayList.shuffle()
    return arrayList
}
fun ArrayList<String>.extHardArray(): ArrayList<String>{
    val arrayList = ArrayList<String>()
    for (i in 0..size){
        arrayList.add(this[i])
    }
    arrayList.shuffle()
    return arrayList
}

infix fun ImageView.extSetBackground(stringUrl: String) {
    Picasso.get()
        .load(stringUrl)
        .fit()
        .into(this)
}