package com.gang.module_main

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this)
    }
}