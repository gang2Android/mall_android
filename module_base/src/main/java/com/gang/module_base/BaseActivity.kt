package com.gang.module_base

import android.content.Intent
import android.os.Bundle
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import com.gang.lib_base.LogUtils

abstract class BaseActivity : AppCompatActivity() {

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        var str = ""
        str = intent?.toString() ?: "intent=null"
        LogUtils.print("onNewIntent: $str", tag = javaClass.simpleName)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.print("onCreate", tag = javaClass.simpleName)

        initDBVM()

    }

    override fun onStart() {
        super.onStart()
        LogUtils.print("onStart", tag = javaClass.simpleName)
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.print("onRestart", tag = javaClass.simpleName)
    }

    override fun onResume() {
        super.onResume()
        LogUtils.print("onResume", tag = javaClass.simpleName)
    }

    override fun onPause() {
        super.onPause()
        LogUtils.print("onPause", tag = javaClass.simpleName)
    }

    override fun onStop() {
        super.onStop()
        LogUtils.print("onStop", tag = javaClass.simpleName)
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.print("onDestroy", tag = javaClass.simpleName)
    }

    /**
     * init DataBinding and ViewModel
     */
    abstract fun initDBVM()

    /**
     * 设置状态栏颜色及透明度
     * @param color 背景色
     * @param statusBarAlpha 透明度 0~255
     */
    fun setStatusBar(@ColorInt color: Int, statusBarAlpha: Int) {
        StatusBarUtils.setColor(this, color, statusBarAlpha)
    }

}