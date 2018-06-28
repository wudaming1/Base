package com.aries.base

import android.app.Application

/**
 * Created by wudaming on 2018/4/10.
 */
open class BaseApplication : Application() {

    companion object {
        lateinit var baseInstance: BaseApplication
    }


    override fun onCreate() {
        baseInstance = this
        super.onCreate()
    }
}