package com.onurtasdemir.keepinmind.util

import android.content.Context
import android.content.Intent
import android.widget.Toast

infix fun <ClassName> Context.extStartActivity(cls:Class<ClassName>){
    startActivity(Intent(this,cls))
}
infix fun String.extToastShow(context: Context){
       Toast.makeText(context,this,Toast.LENGTH_SHORT).show()
}