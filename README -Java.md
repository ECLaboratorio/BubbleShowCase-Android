
# Java 

This is a simplest way use this lib in Java.

## 📚Installation


```bash
  dependencies {
	      implementation 'com.elconfidencial.bubbleshowcase:bubbleshowcase:LATEST_VERSION'
	}
```
    
## 🧰Usage Simplest way:

```javascript
  BubbleShowCaseBuilder builder1 = new BubbleShowCaseBuilder(this);
  builder1  
                .title("FAB Menu") //Any title for the bubble view
                .description("Here you can access ..")
  					 .targetView(findViewById(R.id.View))
                .disableCloseAction(true)
                .show(); //Display the ShowCase
	        
```
## 🧰Usage Listener

```javascript
  BubbleShowCaseBuilder builder1 = new BubbleShowCaseBuilder(this);
   builder1 //Activity instance
                .title("FAB Menu") //Any title for the bubble view
                .description("Here you can access  ...")
                .listener(new BubbleShowCaseListener() {
                    @Override
                    public void onTargetClick(@NonNull BubbleShowCase bubbleShowCase) {
                       

                    }

                    @Override
                    public void onCloseActionImageClick(@NonNull BubbleShowCase bubbleShowCase) {

                    }

                    @Override
                    public void onBackgroundDimClick(@NonNull BubbleShowCase bubbleShowCase) {

                    }

                    @Override
                    public void onBubbleClick(@NonNull BubbleShowCase bubbleShowCase) {

                    }
                })
                .targetView(findViewById(R.id.floatingActionButton))
                .disableCloseAction(true)
                .show(); //Display the ShowCase
	        
```
## BubbleShowCaseSequence sample
``` javascript
 BubbleShowCaseSequence bubbleShowCaseSequence = new BubbleShowCaseSequence();
 bubbleShowCaseSequence.add(builder1);
 bubbleShowCaseSequence.add(builder2);
 ...
 bubbleShowCaseSequence.show();
 ```
## BubbleShowCaseSequence Advanced Way
``` javascript
 
  BubbleShowCaseBuilder builder1 = new BubbleShowCaseBuilder(this);
        ArrayList<BubbleShowCaseBuilder> builders = new ArrayList<>();
        for (int i = 0; i < 9; i++)
            builders.add(new BubbleShowCaseBuilder(this));
 
 builders.get(0).title(" Title 0").description("This 0").targetView(view0);
 ...
 builders.get(8).title(" Title 8").description("This 8").targetView(view8);
 
 
 BubbleShowCaseSequence bubbleShowCaseSequence = new BubbleShowCaseSequence();
 
 for (int i = 1; i < builders.size(); i++)
            bubbleShowCaseSequence.addShowCase(builders.get(i));
 
 bubbleShowCaseSequence.show();
 ```
## Screenshots
No More

## Gifs
 ASAP

## 🚀 About Me
I'm a full stack developer...


## 🛠 Skills
Java, Kotlin, CSS....


## Tech Stack

**Important:** For Gradle 7.2 & jitpack.io Please use this way : https://stackoverflow.com/a/71603699/12272687

**Update:** March 2022


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Mori-hub)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/)
[![Google](https://img.shields.io/badge/My%20Apps-Google%20Play%20Store-green?style=for-the-badge&logo=googleplay)](https://play.google.com/store/search?q=pub:Smart%20rabit&c=apps)

## Feedback

If you have any feedback, please reach out to us at SR-App@outlook.com


## License

[MIT](https://choosealicense.com/licenses/mit/)

