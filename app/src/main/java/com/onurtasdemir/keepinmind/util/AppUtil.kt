package com.onurtasdemir.keepinmind.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import android.widget.TextView
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

private const val timeSixty = 60000L
private const val timeThirty = 30000L
lateinit var gameTimer: CountDownTimer

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

fun Fragment.onCountDown(bundle: Bundle, level: String) {
    val time = if (level == Level.EASY.toString()) timeThirty else timeSixty
    gameTimer = object : CountDownTimer(time, 1000) {
        override fun onFinish() {
            this@onCountDown.extShowDialogLoser(bundle)
        }

        override fun onTick(millisUntilFinished: Long) {
            this@onCountDown.requireActivity().findViewById<TextView>(R.id.txtPlayTime).text =
                (millisUntilFinished / 1000).toString()
        }
    }.start()


}