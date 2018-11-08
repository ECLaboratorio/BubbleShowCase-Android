package com.elconfidencial.bubbleshowcase

import android.app.Activity
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewTreeObserver
import java.lang.ref.WeakReference
import java.util.ArrayList

/**
 * Created by jcampos on 04/09/2018.
 */
class BubbleShowCaseBuilder{

    internal var mActivity: WeakReference<Activity>? = null
    internal var mImage: Drawable? = null
    internal var mTitle: String? = null
    internal var mSubtitle: String? = null
    internal var mCloseAction: Drawable? = null
    internal var mBackgroundColor: Int? = null
    internal var mTextColor: Int? = null
    internal var mTitleTextSize: Int? = null
    internal var mSubtitleTextSize: Int? = null
    internal var mHighlightMode: BubbleShowCase.HighlightMode? = null
    internal var mDisableTargetClick: Boolean = false
    internal var mDisableCloseAction: Boolean = false
    internal var mShowOnce: String? = null
    internal var mIsFirstOfSequence: Boolean? = null
    internal var mIsLastOfSequence: Boolean? = null
    internal val mArrowPositionList = ArrayList<BubbleShowCase.ArrowPosition>()
    internal var mTargetView: WeakReference<View>? = null
    internal var mBubbleShowCaseListener: BubbleShowCaseListener? = null
    internal var mSequenceShowCaseListener: SequenceShowCaseListener? = null

    private var onGlobalLayoutListenerTargetView: ViewTreeObserver.OnGlobalLayoutListener? = null

    /**
     * Builder constructor. It needs an instance of the current activity to convert it to a weak reference in order to avoid memory leaks
     */
    constructor(activity: Activity){
        mActivity = WeakReference(activity)
    }

    /**
     * Title of the BubbleShowCase. This text is bolded in the view.
     */
    fun title(title: String): BubbleShowCaseBuilder {
        mTitle = title
        return this
    }

    /**
     * Additional description of the BubbleShowCase. This text has a regular format
     */
    fun description(subtitle: String): BubbleShowCaseBuilder {
        mSubtitle = subtitle
        return this
    }

    /**
     * Image drawable to inserted as main image in the BubbleShowCase
     *  - If this param is not passed, the BubbleShowCase will not have main image
     */
    fun image(image: Drawable): BubbleShowCaseBuilder {
        mImage = image
        return this
    }

    /**
     * Image resource id to insert the corresponding drawable as main image in the BubbleShowCase
     *  - If this param is not passed, the BubbleShowCase will not have main image
     */
    fun imageResourceId(resId: Int): BubbleShowCaseBuilder {
        mImage = ContextCompat.getDrawable(mActivity!!.get(), resId)
        return this
    }

    /**
     * Image drawable to be inserted as close icon in the BubbleShowCase.
     *  - If this param is not defined, a default close icon is displayed
     */
    fun closeActionImage(image: Drawable?): BubbleShowCaseBuilder {
        mCloseAction = image
        return this
    }

    /**
     * Image resource id to insert the corresponding drawable as close icon in the BubbleShowCase.
     *  - If this param is not defined, a default close icon is displayed
     */
    fun closeActionImageResourceId(resId: Int): BubbleShowCaseBuilder {
        mCloseAction = ContextCompat.getDrawable(mActivity!!.get(), resId)
        return this
    }


    /**
     * Background color of the BubbleShowCase.
     *  - #3F51B5 color will be set if this param is not defined
     */
    fun backgroundColor(color: Int): BubbleShowCaseBuilder {
        mBackgroundColor = color
        return this
    }

    /**
     * Background color of the BubbleShowCase.
     *  - #3F51B5 color will be set if this param is not defined
     */
    fun backgroundColorResourceId(colorResId: Int): BubbleShowCaseBuilder {
        mBackgroundColor = ContextCompat.getColor(mActivity!!.get(), colorResId)
        return this
    }

    /**
     * Text color of the BubbleShowCase.
     *  - White color will be set if this param is not defined
     */
    fun textColor(color: Int): BubbleShowCaseBuilder {
        mTextColor = color
        return this
    }

    /**
     * Text color of the BubbleShowCase.
     *  - White color will be set if this param is not defined
     */
    fun textColorResourceId(colorResId: Int): BubbleShowCaseBuilder {
        mTextColor = ContextCompat.getColor(mActivity!!.get(), colorResId)
        return this
    }

    /**
     * Title text size in SP.
     * - Default value -> 16 sp
     */
    fun titleTextSize(textSize: Int): BubbleShowCaseBuilder {
        mTitleTextSize = textSize
        return this
    }

    /**
     * Description text size in SP.
     * - Default value -> 14 sp
     */
    fun descriptionTextSize(textSize: Int): BubbleShowCaseBuilder {
        mSubtitleTextSize = textSize
        return this
    }

    /**
     * If an unique id is passed in this function, this BubbleShowCase will only be showed once
     * - ID to identify the BubbleShowCase
     */
    fun showOnce(id: String): BubbleShowCaseBuilder {
        mShowOnce = id
        return this
    }

    /**
     * Target view to be highlighted. Set a TargetView is essential to figure out BubbleShowCase position
     * - If a target view is not defined, the BubbleShowCase final position will be the center of the screen
     */
    fun targetView(targetView: View): BubbleShowCaseBuilder {
        mTargetView = WeakReference(targetView)
        return this
    }

    /**
     * If this variable is true, when user clicks on the target, the showcase will not be dismissed
     *  Default value -> false
     */
    fun disableTargetClick(isDisabled: Boolean): BubbleShowCaseBuilder{
        mDisableTargetClick = isDisabled
        return this
    }

    /**
     * If this variable is true, close action button will be gone
     *  Default value -> false
     */
    fun disableCloseAction(isDisabled: Boolean): BubbleShowCaseBuilder{
        mDisableCloseAction = isDisabled
        return this
    }

    /**
     * Insert an arrowPosition to force the position of the BubbleShowCase.
     * - ArrowPosition enum values: LEFT, RIGHT, TOP and DOWN
     * - If an arrow position is not defined, the BubbleShowCase will be set in a default position depending on the targetView
     */
    fun arrowPosition(arrowPosition: BubbleShowCase.ArrowPosition): BubbleShowCaseBuilder {
        mArrowPositionList.clear()
        mArrowPositionList.add(arrowPosition)
        return this
    }

    /**
     * Insert a set of arrowPosition to force the position of the BubbleShowCase.
     * - ArrowPosition enum values: LEFT, RIGHT, TOP and DOWN
     * - If the number of arrow positions is 0 or more than 1, BubbleShowCase will be set on the center of the screen
     */
    fun arrowPosition(arrowPosition: List<BubbleShowCase.ArrowPosition>): BubbleShowCaseBuilder {
        mArrowPositionList.clear()
        mArrowPositionList.addAll(arrowPosition)
        return this
    }

    /**
     * Highlight mode. It represents the way that the target view will be highlighted
     * - VIEW_LAYOUT: Default value. All the view box is highlighted (the rectangle where the view is contained). Example: For a TextView, all the element is highlighted (characters and background)
     * - VIEW_SURFACE: Only the view surface is highlighted, but not the background. Example: For a TextView, only the characters will be highlighted
     */
    fun highlightMode(highlightMode: BubbleShowCase.HighlightMode): BubbleShowCaseBuilder {
        mHighlightMode = highlightMode
        return this
    }

    /**
     * Add a BubbleShowCaseListener in order to listen the user actions:
     * - onTargetClick -> It is triggered when the user clicks on the target view
     * - onCloseClick -> It is triggered when the user clicks on the close icon
     */
    fun listener(bubbleShowCaseListener: BubbleShowCaseListener): BubbleShowCaseBuilder {
        mBubbleShowCaseListener = bubbleShowCaseListener
        return this
    }

    /**
     * Add a sequence listener in order to know when a BubbleShowCase has been dismissed to show another one
     */
    internal fun sequenceListener(sequenceShowCaseListener: SequenceShowCaseListener): BubbleShowCaseBuilder {
        mSequenceShowCaseListener = sequenceShowCaseListener
        return this
    }

    internal fun isFirstOfSequence(isFirst: Boolean): BubbleShowCaseBuilder{
        mIsFirstOfSequence = isFirst
        return this
    }

    internal fun isLastOfSequence(isLast: Boolean): BubbleShowCaseBuilder{
        mIsLastOfSequence = isLast
        return this
    }

    /**
     * Build the BubbleShowCase object from the builder one
     */
    private fun build(): BubbleShowCase {
        if(mIsFirstOfSequence ==null)
            mIsFirstOfSequence = true
        if(mIsLastOfSequence ==null)
            mIsLastOfSequence = true

        return BubbleShowCase(this)
    }

    /**
     * Show the BubbleShowCase using the params added previously
     */
    fun show(): BubbleShowCase{
        val bubbleShowCase = build()
        if (mTargetView != null) {
            val targetView = mTargetView!!.get()
            if (targetView!!.height == 0 || targetView.width == 0) {
                //If the view is not already painted, we wait for it waiting for view changes using OnGlobalLayoutListener
                onGlobalLayoutListenerTargetView = ViewTreeObserver.OnGlobalLayoutListener {
                    bubbleShowCase.show()
                    targetView.viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListenerTargetView)
                }
                targetView.viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListenerTargetView)
            } else {
                bubbleShowCase.show()
            }
        } else {
            bubbleShowCase.show()
        }
        return bubbleShowCase
    }

}