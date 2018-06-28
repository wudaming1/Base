package com.aries.base.utils

import android.os.Environment
import com.aries.base.BaseApplication
import java.io.File

/**
 * Author wudaming
 * Created on 2018/6/22
 * Android系统下的文件工具类
 *
 */
object FileUtil {

    private val context = BaseApplication.baseInstance


    /**
     *  @param type type为空，读取files目录；不空，在files下新建对应文件名称目录。
     */
    fun getFileDir(type: String): File? {
        return if (hasSDCard()) {
            getExternalFileDir(type)
        } else {
            getInternalFilesDir(type)
        }
    }

    /**
     * @param type type为空，读取cache目录；不空，在cache下新建对应文件名称目录。
     */
    fun getCacheDir(type: String): File {
        return if (hasSDCard()) {
            getExternalCacheDir(type)
        } else {
            getInternalCacheDir(type)
        }
    }

    private fun getExternalFileDir(type: String): File {
        var file = context.getExternalFilesDir(type)
        if (file == null) {
            file = File(Environment.getExternalStorageDirectory(), "Android/data/$context.packageName/files/$type")
        }
        makeDirs(file)
        return file
    }

    private fun getInternalFilesDir(type: String): File {
        val file = if (type.isEmpty()) {
            context.filesDir
        } else {
            File(context.filesDir, type)
        }
        makeDirs(file)
        return file
    }

    private fun getExternalCacheDir(type: String): File {

        val file = if (type.isEmpty()) {
            context.externalCacheDir
        } else {
            File(context.externalCacheDir, type)
        }

        makeDirs(file)

        return file
    }

    private fun getInternalCacheDir(type: String): File {
        if (type.isEmpty()) {
            return context.cacheDir
        }

        val file = File(context.cacheDir, type)
        makeDirs(file)
        return file
    }

    private fun makeDirs(file: File) {
        if (!file.exists() && !file.mkdirs()) {
            throw RuntimeException("无法创建缓存目录：${file.absolutePath}")
        }
    }


    private fun hasSDCard() = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED

}