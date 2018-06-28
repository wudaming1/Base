package com.aries.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

fun Context.launch(clazz: Class<out Activity>) {
    val intent = Intent(this, clazz)
    this.startActivity(intent)
}

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
