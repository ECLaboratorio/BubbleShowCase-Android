package com.elconfidencial.bubbleshowcase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.appcompat.view.menu.ActionMenuItemView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpListeners()
    }

    private fun setUpListeners(){
        buttonSimpleShowCase.setOnClickListener { getSimpleShowCaseBuilder().show() }
        buttonColorShowCase.setOnClickListener { getCustomColorShowCaseBuilder().show() }
        buttonTextSizeShowCase.setOnClickListener { getTextSizeShowCaseBuilder().show() }
        buttonArrowLeftShowCase.setOnClickListener { getArrowLeftShowCaseBuilder().show() }
        buttonArrowRightShowCase.setOnClickListener { getArrowRightShowCaseBuilder().show() }
        buttonEventListener.setOnClickListener { getListenerShowCaseBuilder().show() }
        buttonSequence.setOnClickListener { getSequence().show() }
    }

    //SHOW CASES GETTERS

    private fun getSimpleShowCaseBuilder(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
                .title("Welcome!!!")
                .description("This is a simple BubbleShowCase with default values.")
                .targetView(buttonSimpleShowCase)
    }

    private fun getCustomColorShowCaseBuilder(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
                .title("Custom your bubble style!")
                .description("It is possible to change the text color, background ... and you can even add an image into your bubble.")
                .backgroundColor(ContextCompat.getColor(this, R.color.colorBlueGray))
                .image(ContextCompat.getDrawable(this, R.drawable.ic_color)!!)
                .closeActionImage(ContextCompat.getDrawable(this, R.drawable.ic_close_black)!!)
                .textColor(ContextCompat.getColor(this, R.color.colorBlack))
                .targetView(buttonColorShowCase)
    }

    private fun getTextSizeShowCaseBuilder(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
                .title("Change text sizes!")
                .description("You can also choose the best text size for you.")
                .backgroundColor(ContextCompat.getColor(this, R.color.colorTeal))
                .image(ContextCompat.getDrawable(this, R.drawable.ic_format_size)!!)
                .titleTextSize(18)
                .descriptionTextSize(16)
                .closeActionImage(null)
                .targetView(buttonTextSizeShowCase)
    }

    private fun getArrowLeftShowCaseBuilder(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
                .title("Force the position of the bubble!")
                .description("You only have to specify in which side you want the arrow, and the bubble will be located depending on it.")
                .arrowPosition(BubbleShowCase.ArrowPosition.LEFT)
                .backgroundColor(ContextCompat.getColor(this, R.color.colorRed))
                .targetView(buttonArrowLeftShowCase)
    }

    private fun getArrowRightShowCaseBuilder(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
                .title("Arrow set on right side this time :)")
                .arrowPosition(BubbleShowCase.ArrowPosition.RIGHT)
                .backgroundColor(ContextCompat.getColor(this, R.color.colorPink))
                .targetView(buttonArrowRightShowCase)
    }


    private fun getListenerShowCaseBuilder(): BubbleShowCaseBuilder{
        return BubbleShowCaseBuilder(this)
                .title("Listen user actions!")
                .description("You can detect when the user interacts with the different view elements to act consequently.")
                .backgroundColor(ContextCompat.getColor(this, R.color.colorOrange))
                .image(ContextCompat.getDrawable(this, R.drawable.ic_sentiment_satisfied)!!)
                .listener(object : BubbleShowCaseListener{
                    override fun onBubbleClick(bubbleShowCase: BubbleShowCase) {
                        Toast.makeText(this@MainActivity, "OnBubbleClick", Toast.LENGTH_SHORT).show()
                    }

                    override fun onBackgroundDimClick(bubbleShowCase: BubbleShowCase) {
                        Toast.makeText(this@MainActivity, "OnBackgroundDimClick", Toast.LENGTH_SHORT).show()
                    }

                    override fun onTargetClick(bubbleShowCase: BubbleShowCase) {
                        Toast.makeText(this@MainActivity, "OnTargetClick", Toast.LENGTH_SHORT).show()
                    }

                    override fun onCloseActionImageClick(bubbleShowCase: BubbleShowCase) {
                        Toast.makeText(this@MainActivity, "OnClose", Toast.LENGTH_SHORT).show()
                    }
                })
                .targetView(buttonEventListener)
    }

    private fun getSequence(): BubbleShowCaseSequence{
        return BubbleShowCaseSequence().addShowCases(listOf(
                getSimpleShowCaseBuilder(),
                getCustomColorShowCaseBuilder(),
                getTextSizeShowCaseBuilder(),
                getArrowLeftShowCaseBuilder(),
                getArrowRightShowCaseBuilder(),
                getListenerShowCaseBuilder()
        ))
    }

}
