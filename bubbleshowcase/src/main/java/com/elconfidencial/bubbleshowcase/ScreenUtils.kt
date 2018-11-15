package com.elconfidencial.bubbleshowcase

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.graphics.Point
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.Window.ID_ANDROID_CONTENT



/**
 * Created by jcampos on 05/09/2018.
 */
object ScreenUtils {

    fun getScreenHeight(context: Context): Int {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.y
    }

    fun getScreenWidth(context: Context): Int {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size.x
    }

    fun getAxisXpositionOfViewOnScreen(targetView: View): Int {
        val locationTarget = IntArray(2)
        targetView.getLocationOnScreen(locationTarget)
        return locationTarget[0]
    }

    fun getAxisYpositionOfViewOnScreen(targetView: View): Int {
        val locationTarget = IntArray(2)
        targetView.getLocationOnScreen(locationTarget)
        return locationTarget[1]
    }

    fun getVerticalScreenOffset(activity: Activity): Int{
        val viewRoot = getViewRoot(activity)
        return getScreenHeight(activity) - viewRoot.height
    }

    fun getHorizontalScreenOffset(activity: Activity): Int{
        val viewRoot = getViewRoot(activity)
        return getScreenWidth(activity) - viewRoot.width
    }

    private fun getViewRoot(activity: Activity): ViewGroup {
        val androidContent = activity.findViewById<ViewGroup>(android.R.id.content)
        return androidContent.parent.parent as ViewGroup
    }

    fun getStatusBarHeight(context: Context): Int {
        var result = 0
        val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    fun pxToDp(px: Int): Int {
        val metrics = Resources.getSystem().displayMetrics
        return Math.round(px / (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT))
    }

    fun dpToPx(dp: Int): Int {
        val metrics = Resources.getSystem().displayMetrics
        return Math.round(dp * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT))
    }

    fun isViewLocatedAtHalfTopOfTheScreen(activity: Activity, targetView: View): Boolean{
        val screenHeight = getScreenHeight(activity)
        val positionTargetAxisY = getAxisYpositionOfViewOnScreen(targetView)
        return screenHeight/2 > positionTargetAxisY
    }

    fun isViewLocatedAtHalfLeftOfTheScreen(activity: Activity, targetView: View): Boolean{
        val screenWidth = getScreenWidth(activity)
        val positionTargetAxisX = getAxisXpositionOfViewOnScreen(targetView)
        return screenWidth/2 > positionTargetAxisX
    }
}