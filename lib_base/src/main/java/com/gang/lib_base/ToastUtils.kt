package com.gang.lib_base

import android.content.Context
import android.widget.Toast

object ToastUtils {
    var toast: Toast? = null
    fun show(context: Context, msg: String) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
            toast?.show()
        } else {
            toast?.let {
//                it.duration = Toast.LENGTH_SHORT
//                it.cancel()
                it.setText(msg)
                it.show()
            }
        }
    }
}
