package com.onurtasdemir.keepinmind.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.enums.Level
import com.onurtasdemir.keepinmind.fragment.EasyFragment
import com.onurtasdemir.keepinmind.fragment.HardFragment
import com.onurtasdemir.keepinmind.fragment.NormalFragment
import java.util.*
import kotlin.collections.ArrayList


fun <T> Context.extStartActivity(cls: Class<T>, bundle: Bundle) =
    startActivity(Intent(this, cls).putExtras(bundle))

fun Context.extSetSrc(stringUrl: String, imgId: ImageView) =
    Glide.with(this)
        .load(stringUrl)
        .fitCenter()
        .into(imgId)

infix fun ArrayList<String>.extArray(size: Int): ArrayList<String> {
    val arrayList = ArrayList<String>()
    for (i in 0..size) {
        arrayList.add(this[i])
    }
    return arrayList
}

fun <T> ArrayList<T>.shuffle(): ArrayList<T> {
    val rng = Random()
    for (index in this.indices) {
        val randomIndex = rng.nextInt(index + 1)
        val temp = this[index]
        this[index] = this[randomIndex]
        this[randomIndex] = temp
    }
    return this
}

infix fun AppCompatActivity.extSetFragmentPlayActivity(fragment: Fragment) {
    try {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frmPlayContainer, fragment)
            .commit()
    } catch (e: Exception) {
        fragment.requireActivity()
            .supportFragmentManager
            .beginTransaction()
            .replace(R.id.frmPlayContainer, fragment)
            .commit()
    }

}

fun AppCompatActivity.extSetLevelFragment(bundle: Bundle, level: String) {
    when (level) {
        Level.EASY.toString() -> {
            val easyFragment = EasyFragment()
            easyFragment.arguments = bundle
            this extSetFragmentPlayActivity easyFragment
        }
        Level.NORMAL.toString() -> {
            val normalFragment = NormalFragment()
            normalFragment.arguments = bundle
            this extSetFragmentPlayActivity normalFragment
        }
        Level.HARD.toString() -> {
            val hardFragment = HardFragment()
            hardFragment.arguments = bundle
            this extSetFragmentPlayActivity hardFragment
        }
    }
}

