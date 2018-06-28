package com.aries.base.compress

import android.graphics.BitmapFactory

/**
 * Author wudaming
 * Created on 2018/6/8
 */
class CompressConfig {

    companion object {
        //        const val DEFAULT_SIZE = 2 * 1024 * 1024
        const val NO_SIZE_COMPRESS = -1
    }

    var maxFileSize = NO_SIZE_COMPRESS
    var targetWidth = 1080
    var tarhetHeight = 806
    /**
     *  压缩后的最低质量
     */
    var minQuality = 10

    val options: BitmapFactory.Options

    constructor(options: BitmapFactory.Options) {
        this.options = options
    }
}