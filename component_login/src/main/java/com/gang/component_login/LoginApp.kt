package com.gang.component_login

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.lib_base.LogUtils

class LoginApp : Application() {
    override fun onCreate() {
        super.onCreate()

//        ARouter.openLog();
//        ARouter.openDebug();
//        ARouter.init(this)
        LogUtils.print("LoginApp-onCreate")
    }
}

class LoginInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(context.applicationContext as Application)
        LogUtils.print("LoginInitializer-create")
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }

}