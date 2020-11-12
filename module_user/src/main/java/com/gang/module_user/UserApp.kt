package com.gang.module_user

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class UserApp : Application() {
    override fun onCreate() {
        super.onCreate()

        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this)
    }
}