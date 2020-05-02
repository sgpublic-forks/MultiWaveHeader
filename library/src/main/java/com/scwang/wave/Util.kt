package com.scwang.wave

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.util.TypedValue
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes

object Util {
    /**
     * 获取颜色
     * @param context 上下文
     * @param colorId 颜色ID
     * @return 颜色
     */
    @ColorInt
    fun getColor(context: Context, @ColorRes colorId: Int): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context.getColor(colorId)
        } else context.resources.getColor(colorId)
    }

    /**
     * dp转px
     * @param dpVal dp 值
     * @return px
     */
    fun dp2px(dpVal: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, Resources.getSystem().displayMetrics)
    }
}