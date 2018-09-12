package com.elconfidencial.bubbleshowcase

/**
 * Created by jcampos on 04/09/2018.
 *
 * Listener of user actions in a BubbleShowCase
 */
interface BubbleShowCaseListener {
    /**
     * It is called when the user clicks on the targetView
     */
    fun onTargetClick(bubbleShowCase: BubbleShowCase)

    /**
     * It is called when the user clicks on the close icon
     */
    fun onClose(bubbleShowCase: BubbleShowCase)
}