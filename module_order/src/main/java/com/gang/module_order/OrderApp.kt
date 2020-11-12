package com.gang.module_order

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class OrderApp : Application() {
    override fun onCreate() {
        super.onCreate()

        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this)
    }
}