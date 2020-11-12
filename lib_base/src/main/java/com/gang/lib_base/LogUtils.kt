package com.gang.lib_base

import android.util.Log

object LogUtils {
    var IS_DEBUG = true

    fun print(content: String, tag: String = "GLogUtils") {
        if (IS_DEBUG) {
            Log.e(tag, content);
        }
    }

}