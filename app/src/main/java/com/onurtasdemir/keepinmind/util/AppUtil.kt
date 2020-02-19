package com.onurtasdemir.keepinmind.util

import android.content.Context
import android.content.Intent
import android.widget.Toast

infix fun Context.extStartActivity(intent: Intent){
    startActivity(intent)
}
infix fun String.extToastShow(context: Context){
       Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
}

