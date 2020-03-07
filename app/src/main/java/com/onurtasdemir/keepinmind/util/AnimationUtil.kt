package com.onurtasdemir.keepinmind.util

import android.widget.ImageView
import com.podcopic.animationlib.library.AnimationType
import com.podcopic.animationlib.library.StartSmartAnimation

infix fun ImageView.extSetRotateInAnimator(duration: Long) =
    StartSmartAnimation.startAnimation(this, AnimationType.FadeIn, duration, 1, true)

infix fun ImageView.extImageChangeAnimator(duration: Long) =
    StartSmartAnimation.startAnimation(this, AnimationType.FlipInY, duration, 1, true)

infix fun ImageView.extFalseChoose(duration: Long) =
    StartSmartAnimation.startAnimation(this, AnimationType.FlipOutY, duration, 1, true)

infix fun ImageView.extImageCorrectAnimator(duration: Long) =
    StartSmartAnimation.startAnimation(this, AnimationType.Tada, duration, 0, false)