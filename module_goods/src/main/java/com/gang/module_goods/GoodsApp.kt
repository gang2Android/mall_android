package com.gang.module_goods

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class GoodsApp : Application() {
    override fun onCreate() {
        super.onCreate()

        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this)
    }
}