package com.aries.base

import android.graphics.BitmapFactory
import com.aries.base.compress.CompressConfig
import com.aries.base.compress.CompressTask
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Author wudaming
 * Created on 2018/6/22
 */

@RunWith(RobolectricTestRunner::class)
class CompressTest {

    @Test
    fun testSingle() {

        val foldPath = "/Users/wudaming/AndroidStudioProjects/AndroidDemos/resources"
        val sourcesPath = "$foldPath/big_image.jpg"
        val targetPath = "$foldPath/target_image.jpg"
        val option = BitmapFactory.Options()
        option.outWidth = 800
        option.outHeight = 480
        val compressConfig = CompressConfig(option)
        val compressTask = CompressTask(sourcesPath, compressConfig)
    }

}