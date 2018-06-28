package com.aries.base.compress

import android.graphics.Bitmap
import android.graphics.BitmapFactory

/**
 * Author wudaming
 * Created on 2018/6/14
 */
class CompressTask {
    private val filePath: String
    private val compressConfig: CompressConfig
    private val bitmap: Bitmap

    constructor(filePath: String, compressConfig: CompressConfig) {
        this.filePath = filePath
        this.bitmap = decodeFile(filePath)
        this.compressConfig = compressConfig
    }


    /**
     *  对外暴露的命令接口
     */
    fun execute() {

    }


    /**
     *  图片的长宽尺寸压缩
     */
    fun imageSizeCompress() {
    }

    /**
     *  图片采样率压缩
     */
    fun sampleCompress() {}

    /**
     *  bitmap质量压缩，使用系统native方法，可能失真。
     */
    fun qualityCompress() {}


    private fun decodeFile(filePath: String): Bitmap {

        return BitmapFactory.decodeFile(filePath, compressConfig.options)
                ?: throw RuntimeException("无法解码$filePath")
    }
}