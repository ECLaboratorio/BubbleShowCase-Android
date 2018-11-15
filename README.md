# BubbleShowCase - Android
 [ ![Download](https://api.bintray.com/packages/laboratorioec/Laboratorio-apps/BubbleShowCase/images/download.svg) ](https://bintray.com/laboratorioec/Laboratorio-apps/BubbleShowCase/_latestVersion)
 [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-BubbleShowCase-green.svg?style=flat )]( https://android-arsenal.com/details/1/7119 )

BubbleShowCase is an elegant and simple framework developed in Kotlin (usable also in Java) that let you to use informative bubbles to help your users pointing out different features of your application or in your App onboarding. The basic use of the framework consists on a target element passed as input which will be highlighted over a translucent background and pointed out by a customizable bubble.

<img src="resources/usage_sample.gif" alt="GIF" height="700"/>

## Getting started

Add the library into your proyect is really easy, you just need to add this line in dependencies block in your app Gradle:
```groovy
implementation 'com.elconfidencial.bubbleshowcase:bubbleshowcase:LATEST_VERSION'
```
**NOTE:** You can check the LATEST_VERSION in the version badge at the top of this file.

## Usage
### Basic sample

Create a new BubbleShowCase is pretty straightforward. It is only needed an instance of the current activity and the target view to carry it out.
```kotlin
BubbleShowCaseBuilder(this) //Activity instance
                .title("foo") //Any title for the bubble view
                .targetView(view) //View to point out
                .show() //Display the ShowCase
```
**NOTE:** If the target is not passed as input, the bubble will be located by default in the middle of the screen without arrows.

### Custom BubbleShowCase

Below it is showed an example of a BubbleShowCase will all possible input params which can be custom.

```kotlin
BubbleShowCaseBuilder(this) //Activity instance
                .title("foo") //Any title for the bubble view
                .description("bar") //More detailed description
                .arrowPosition(BubbleShowCase.ArrowPosition.RIGHT) //You can force the position of the arrow to change the location of the bubble.
                .backgroundColor(Color.GREEN) //Bubble background color
                .textColor(Color.BLACK) //Bubble Text color
                .titleTextSize(17) //Title text size in SP (default value 16sp)
                .descriptionTextSize(15) //Subtitle text size in SP (default value 14sp)
                .image(imageDrawable) //Bubble main image
                .closeActionImage(CloseImageDrawable) //Custom close action image
                .showOnce("BUBBLE_SHOW_CASE_ID") //Id to show only once the BubbleShowCase
                .listener(listener(object : BubbleShowCaseListener{ //Listener for user actions
                    override fun onTargetClick(bubbleShowCase: BubbleShowCase) {
                        //Called when the user clicks the target
                    }
                    override fun onCloseActionImageClick(bubbleShowCase: BubbleShowCase) {
                        //Called when the user clicks the close button
                    }
                    override fun onBubbleClick(bubbleShowCase: BubbleShowCase) {
                        //Called when the user clicks on the bubble
                    }

                    override fun onBackgroundDimClick(bubbleShowCase: BubbleShowCase) {
                        //Called when the user clicks on the background dim
                    }
                })
                .targetView(view) //View to point out
                .show() //Display the ShowCase
```

**NOTE:** Set more than one arrow position is allowed. For that case, the arrows will be painted and the bubble will be located in the middle of the screen. It could be useful to indicate a swipe or a scroll movement.

### BubbleShowCaseSequence sample

It has been also implemented a BubbleShowCaseSequence object in order to chain more than one BubbleShowCase. It could be useful when it is desired to point out several things at the same moment.
```kotlin
BubbleShowCaseSequence()
                .addShowCase(firstShowCaseBuilder) //First BubbleShowCase to show
                .addShowCase(secondShowCaseBuilder) // This one will be showed when firstShowCase is dismissed
                .addShowCase(thirdShowCaseBuilder) // This one will be showed when secondShowCase is dismissed
                .show() //Display the ShowCaseSequence
```

For more information and examples, please check our [sample app](/app).
If you have any issues or feedback, please visit [issue section](https://github.com/ECLaboratorio/BubbleShowCase-Android/issues).
Please feel free to collaborate with us making this framework as best as possible.

## License

`BubbleShowCase-Android` is available under the MIT license. See the [LICENSE](/LICENSE) file for more info.
