package com.scwang.wave

import android.graphics.Path
import kotlin.math.max

/**
 * 水波对象
 * Created by SCWANG on 2017/12/11.
 */
class Wave /*extends View*/( /*Context context, */
        var offsetX: Float, var offsetY: Float, var velocity: Float, //水平拉伸比例
        private val scaleX: Float, //竖直拉伸比例
        private val scaleY: Float, //波幅（振幅）
        var wave: Int) {
    var path //水波路径
            : Path = Path()
    var width //画布宽度（2倍波长）
            = 0
    private var curWave = 0

    //    /*
    //     * 根据 波长度、中轴线高度、波幅 绘制水波路径
    //     */
    //    public Wave(Context context) {
    //        this(context, null, 0);
    //    }
    //
    //    public Wave(Context context, @Nullable AttributeSet attrs) {
    //        this(context, attrs, 0);
    //    }
    //
    //    public Wave(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    //        super(context, attrs, defStyleAttr);
    //
    //        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Wave);
    //
    ////        startColor = ta.getColor(R.styleable.Wave_mwhStartColor, 0);
    ////        closeColor = ta.getColor(R.styleable.Wave_mwhCloseColor, 0);
    ////        alpha = ta.getFloat(R.styleable.Wave_mwhColorAlpha, 0f);
    //        scaleX = ta.getFloat(R.styleable.Wave_mwScaleX, 1);
    //        scaleY = ta.getFloat(R.styleable.Wave_mwScaleY, 1);
    //        offsetX = ta.getDimensionPixelOffset(R.styleable.Wave_mwOffsetX, 0);
    //        offsetY = ta.getDimensionPixelOffset(R.styleable.Wave_mwOffsetY, 0);
    //        velocity = ta.getDimensionPixelOffset(R.styleable.Wave_mwVelocity, Util.dp2px(10));
    //        wave = ta.getDimensionPixelOffset(R.styleable.Wave_mwWaveHeight, 0) / 2;
    //
    //        ta.recycle();
    //    }
    fun updateWavePath(w: Int, h: Int, waveHeight: Int, fullScreen: Boolean, progress: Float) {
        wave = waveHeight
        width = (2 * scaleX * w).toInt() //画布宽度（2倍波长）
        path = buildWavePath(width, h, fullScreen, progress)
    }

    fun updateWavePath(w: Int, h: Int, progress: Float) {
        var wave = (scaleY * wave).toInt() //计算拉伸之后的波幅
        val maxWave = h * Math.max(0f, 1 - progress)
        if (wave > maxWave) {
            wave = maxWave.toInt()
        }
        if (curWave != wave) {
            width = (2 * scaleX * w).toInt() //画布宽度（2倍波长）
            path = buildWavePath(width, h, true, progress)
        }
    }

    fun buildWavePath(width: Int, height: Int, fullScreen: Boolean, progress: Float): Path {
        var DP = Util.dp2px(1f) //一个dp在当前设备表示的像素量（水波的绘制精度设为一个dp单位）
        if (DP < 1) {
            DP = 1F
        }
        var wave = (scaleY * wave).toInt() //计算拉伸之后的波幅
        if (fullScreen) {
            val maxWave = height * max(0f, 1 - progress)
            if (wave > maxWave) {
                wave = maxWave.toInt()
            }
        }
        curWave = wave

//        Path path = new Path();
        path.reset()
        path.moveTo(0f, 0f)
        path.lineTo(0f, height - wave.toFloat())
        if (wave > 0) {
            var x = DP
            while (x < width) {
                path.lineTo(x.toFloat(), height - wave - wave * Math.sin(4.0 * Math.PI * x / width).toFloat())
                x += DP
            }
        }
        path.lineTo(width.toFloat(), height - wave.toFloat())
        path.lineTo(width.toFloat(), 0f)
        path.close()
        return path
    }
    //    int startColor;     //开始颜色
    //    int closeColor;     //结束颜色
    //    float alpha;        //颜色透明度
}