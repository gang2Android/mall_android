package com.gang.lib_base

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider

object IntentUtils {
    fun getInstallAppIntent(context: Context, filePath: String): Intent? {
        val isExists = FileUtils.isExists(filePath)
        if (!isExists) {
            return null
        }
        val file = FileUtils.getFile(filePath) ?: return null

        var uri: Uri? = null
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            uri = Uri.fromFile(file)
        } else {
            val authority = context.packageName + ".fileProvider"
            uri = FileProvider.getUriForFile(context, authority, file)
        }
        if (uri == null) return null
        val intent = Intent(Intent.ACTION_VIEW)
        val type = "application/vnd.android.package-archive"
        intent.setDataAndType(uri, type)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION;
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        return intent
    }
}