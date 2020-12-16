package com.gang.module_main

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import com.alibaba.android.arouter.launcher.ARouter
import com.gang.lib_base.LogUtils

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

//        ARouter.openLog();
//        ARouter.openDebug();
//        ARouter.init(this)
        LogUtils.print("MainApp-onCreate")
    }
}

class MainInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(context.applicationContext as Application)
        LogUtils.print("MainInitializer-create")
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }

}