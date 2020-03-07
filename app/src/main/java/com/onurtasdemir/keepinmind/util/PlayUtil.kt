package com.onurtasdemir.keepinmind.util

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.onurtasdemir.keepinmind.R
import com.onurtasdemir.keepinmind.enums.Level
import com.onurtasdemir.keepinmind.fragment.EasyFragment
import com.onurtasdemir.keepinmind.fragment.FinishGameFragment
import com.onurtasdemir.keepinmind.fragment.HardFragment
import com.onurtasdemir.keepinmind.fragment.NormalFragment

private var counter: Int = 0
private var counterGameOver: Int = 0
private var statement: Boolean = false
private lateinit var cardOne: ImageButton
private lateinit var cardTwo: ImageButton
private var cardOneTag = String()
private var cardTwoTag = String()

fun ArrayList<String>.extCheckCard(
    imageButton: ImageButton,
    fragment: Fragment,
    index: Int,
    bundle: Bundle,
    level: String
) {
    fragment.context!!.extSetSrc(this[index], imageButton)
    if (counter % 2 == 0) {
        counter++
        cardOne = imageButton
        cardOneTag = this[index]
    } else if (cardOne != this) {
        counter++
        cardTwo = imageButton
        cardTwoTag = this[index]
        checkCard(cardOne, cardTwo, cardOneTag, cardTwoTag, bundle, level, fragment)
    }
}

fun checkCard(
    cardOne: ImageButton,
    cardTwo: ImageButton,
    cardOneTag: String,
    cardTwoTag: String,
    bundle: Bundle,
    level: String,
    fragment: Fragment
) {
    if (cardOne != cardTwo) {
        if (cardOneTag.contentEquals(cardTwoTag)) {
            cardOne extImageCorrectAnimator 1000
            cardTwo extImageCorrectAnimator 1000
            Handler().postDelayed({
                cardOne.visibility = View.INVISIBLE
                cardTwo.visibility = View.INVISIBLE
                counterGameOver++
                if (level.gameOver()){
                    fragment.extShowDialogWinner(bundle, level)
                    counterGameOver = 0
                    statement = false
                }
            }, 1000)
        } else {
            Handler().postDelayed({
                cardOne.setImageResource(R.drawable.ic_question)
                cardTwo.setImageResource(R.drawable.ic_question)
            }, 500)
        }
    }
}

fun String.gameOver(): Boolean {
    when (this) {
        Level.NORMAL.toString() -> if (counterGameOver == 2) statement = true
        Level.HARD.toString() ->  if (counterGameOver == 4) statement = true
        Level.FINISH.toString() ->  if (counterGameOver == 8) statement = true
    }
    return statement
}

fun Fragment.extShowDialogWinner(bundle: Bundle, level: String) {
    MaterialAlertDialogBuilder(this.context)
        .setTitle("Winner :)")
        .setMessage("Congratulations, let's play the other level :)")
        .setPositiveButton("Next Level") { dialog, which ->
            this.extChangeLevel(bundle,level)
            dialog.dismiss()
        }
        .setCancelable(false)
        .show()
}

fun Fragment.extChangeLevel(bundle: Bundle,level: String){
    when(level){
        Level.NORMAL.toString() -> this.extChangeSetLevel(bundle,NormalFragment())
        Level.HARD.toString() -> this.extChangeSetLevel(bundle,HardFragment())
        Level.FINISH.toString() -> this.extChangeSetLevel(bundle,FinishGameFragment())
    }
}

fun Fragment.extChangeSetLevel(bundle: Bundle,nextFragment: Fragment){
    nextFragment.arguments = bundle
    this.requireActivity()
        .supportFragmentManager
        .beginTransaction()
        .replace(R.id.frmPlayContainer,nextFragment)
        .commit()
}

infix fun Fragment.extShowDialogLoser(bundle: Bundle) {
    MaterialAlertDialogBuilder(this.context)
        .setTitle("Loser :)")
        .setMessage("Do you want to play again? :)")
        .setPositiveButton("Play Again") { dialog, which ->
            this.extChangeSetLevel(bundle,EasyFragment())
        }
        .setCancelable(false)
        .show()
}