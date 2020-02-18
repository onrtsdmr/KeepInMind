package com.onurtasdemir.keepinmind.util

import android.content.Context
import android.content.Intent

infix fun <ClassName> Context.extStartActivity(cls:Class<ClassName>){
    startActivity(Intent(this,cls))
}