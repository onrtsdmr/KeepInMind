package com.onurtasdemir.keepinmind.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
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

private var counter: Int = 0
private lateinit var cardOne: ImageButton
private lateinit var cardTwo: ImageButton
private var cardOneTag = String()
private var cardTwoTag = String()

fun <T> Context.extStartActivity(cls: Class<T>, bundle: Bundle) {
    startActivity(Intent(this, cls).putExtras(bundle))
}

infix fun ImageView.extSetRotateInAnimator(duration: Long) {
    StartSmartAnimation.startAnimation(this, AnimationType.FadeIn, duration, 1, true)
}

infix fun ImageView.extImageChangeAnimator(duration: Long) {
    StartSmartAnimation.startAnimation(this, AnimationType.FlipInY, duration, 1, true)
}

infix fun ImageView.extFalseChoose(duration: Long) {
    StartSmartAnimation.startAnimation(this, AnimationType.FlipOutY, duration, 1, true)
}

infix fun ImageView.extImageCorrectAnimator(duration: Long) {
    StartSmartAnimation.startAnimation(this, AnimationType.Tada, duration, 0, false)
}

fun Context.extSetSrc(stringUrl: String, imgId: ImageView) {
    Glide.with(this)
        .load(stringUrl)
        .fitCenter()
        .into(imgId)
}

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

infix fun String.extToastShow(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

infix fun AppCompatActivity.extSetFragmentPlayActivity(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .replace(R.id.frmPlayContainer, fragment)
        .commit()
}

fun AppCompatActivity.extSetLevelFragment(bundle: Bundle, level: String) {
    when (level) {
        Level.EASY.toString() -> {
            val easyFragment = EasyFragment()
            easyFragment.arguments = bundle
            this extSetFragmentPlayActivity easyFragment
        }
        Level.NORMAL.toString() -> {
            NormalFragment().arguments = bundle
            this extSetFragmentPlayActivity NormalFragment()
        }
        Level.HARD.toString() -> {
            HardFragment().arguments = bundle
            this extSetFragmentPlayActivity HardFragment()
        }
    }
}

fun ArrayList<String>.extCheckCard(imageButton: ImageButton, context: Context, index: Int) {
    context.extSetSrc(this[index], imageButton)
    if (counter % 2 == 0) {
        counter++
        cardOne = imageButton
        cardOneTag = this[index]
    } else if (cardOne != this) {
        counter++
        cardTwo = imageButton
        cardTwoTag = this[index]
        checkCard(cardOne, cardTwo, cardOneTag, cardTwoTag)
    }
}

fun checkCard(cardOne: ImageButton, cardTwo: ImageButton, cardOneTag: String, cardTwoTag: String) {
    if (cardOne != cardTwo) {
        if (cardOneTag.contentEquals(cardTwoTag)) {
            cardOne extImageCorrectAnimator 1000
            cardTwo extImageCorrectAnimator 1000
            Handler().postDelayed({
                cardOne.visibility = View.INVISIBLE
                cardTwo.visibility = View.INVISIBLE
            }, 1000)
        } else {
            Handler().postDelayed({
                cardOne.setImageResource(R.drawable.ic_question)
                cardTwo.setImageResource(R.drawable.ic_question)
            }, 500)
        }
    }
}
