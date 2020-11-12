package com.gang.lib_base

import java.text.SimpleDateFormat

object TimeFormatUtils {
    fun time2Str(time: Long): String {
        return SimpleDateFormat("YY-MM-DD-hh-mm-ss").format(time)
    }
}