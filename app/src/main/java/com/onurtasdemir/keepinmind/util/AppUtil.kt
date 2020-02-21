package com.onurtasdemir.keepinmind.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.enums.Level
import com.onurtasdemir.keepinmind.fragment.EasyFragment
import com.onurtasdemir.keepinmind.fragment.HardFragment
import com.onurtasdemir.keepinmind.fragment.NormalFragment
import com.podcopic.animationlib.library.AnimationType
import com.podcopic.animationlib.library.StartSmartAnimation
import java.util.*
import kotlin.collections.ArrayList


fun <T> Context.extStartActivity(cls: Class<T>, bundle: Bundle) {
    startActivity(Intent(this, cls).putExtras(bundle))
}

infix fun ImageView.extSetRotateInAnimator(duration: Long) {
    StartSmartAnimation.startAnimation(this, AnimationType.FadeIn, duration, 1, true)
}

fun Context.extSetSrc(stringUrl: String, imgId: ImageView) {
    Glide.with(this)
        .load(stringUrl)
        .into(imgId)
}

infix fun ArrayList<String>.extArray(size: Int): ArrayList<String> {
    val arrayList = ArrayList<String>()
    for (i in 0..size) {
        arrayList.add(this[i])
    }
    return arrayList
}

fun <T> Array<T>.shuffle(): Array<T> {
    val rng = Random()
    for (index in this.indices) {
        val randomIndex = rng.nextInt(index + 1)
        val temp = this[index]
        this[index] = this[randomIndex]
        this[randomIndex] = temp
    }
    return this
}

infix fun String.extToastShow(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

infix fun AppCompatActivity.extSetFragmentPlayActivity(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .replace(R.id.frmPlayContainer, fragment)
        .commit()
}
infix fun AppCompatActivity.extSetLevelFragment(level: String){
    when (level) {
        Level.EASY.toString() -> {
            this extSetFragmentPlayActivity EasyFragment()
        }
        Level.NORMAL.toString() -> {
            this extSetFragmentPlayActivity NormalFragment()
        }
        Level.HARD.toString() -> {
            this extSetFragmentPlayActivity HardFragment()
        }
    }
}

