package com.gang.lib_base

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

object AppUtils {

    fun getVersionName(context: Context): String {
        val info = context.packageManager.getPackageInfo(context.packageName, 0)
        return info.versionName
    }

    fun getVersionCode(context: Context): Long {
        val info = context.packageManager.getPackageInfo(context.packageName, 0)
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            info.longVersionCode
        } else {
            info.versionCode.toLong()
        }
    }

    fun copyText(context: Context, txt: String) {
        val cm = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val cd = ClipData.newPlainText("Label", txt)
        cm.setPrimaryClip(cd)
    }
}