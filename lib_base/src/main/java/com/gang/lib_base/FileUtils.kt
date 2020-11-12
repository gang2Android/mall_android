package com.gang.lib_base

import java.io.File
import java.lang.Exception

object FileUtils {

    fun getFile(filePath: String): File? {

        var file: File? = null
        val isExists = isExists(filePath);
        if (!isExists) {
            return null
        }
        file = File(filePath);
        return file
    }

    fun isExists(filePath: String): Boolean {
        val file = File(filePath) ?: return false
        if (file.exists()) {
            return true
        }
        return false
    }

    fun createDir(file: File): Boolean {
        return if (file.exists()) {
            file.isDirectory
        } else {
            file.mkdirs()
        }
    }

    fun createFile(filePath: String): Boolean {
        val file = File(filePath) ?: return false
        if (file.exists() && !file.delete()) return false
        val pFile = file.parentFile ?: return false
        if (!createDir(pFile)) return false
        return try {
            file.createNewFile()
        } catch (e: Exception) {
            LogUtils.print(e.message.toString(), tag = "" + javaClass.simpleName)
            false
        }
    }

}