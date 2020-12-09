package com.gang.module_login

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class LoginApp : Application() {
    override fun onCreate() {
        super.onCreate()

        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this)
    }
}