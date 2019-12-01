DOCUMENTATION:

Assignment was done using:

1. Mac PC
2. Android Studio
3. Java programming language
4. Espresso API to write Android UI tests
5. Git

Pre-requisites:

• Android SDK 29 • Java v8 JDK and/or higher versions

Creating a local copy of project
1. Navigate to the repository https://github.com/MariaSkvortcova/reference_android, click Clone or Download button to download the assignment as a project
2. Copy GitHub URL displayed
3. Launch terminal on macOS or command prompt on Windows PC.
4. Navigate to the folder where project is to be saved locally by typing this command cd , for example
5. Create an actual local copy of the project by running git clone , where URL is the link from Step 2

Launching Project
1. Launch Android Studio
2. Click File on the menu
3. Click Open
4. Navigate to folder where project was cloned/downloaded (i.e. project directory)
5. Select project folder
6. Click Open

Running Tests and Test report

Tests can be run with Android JUnit Runner from command line with command:

./gradlew connectedAndroidTest

The results of tests run can be found in files
reference_android/app/build/reports/androidTests/connected/index.html 
and 
reference_android/app/build/outputs/androidTest-results/connected/*.xml

I added to project AndroidUITestsRunReport.html file from my tests run. You can find it in repository folder.

ABOUT TEST PROJECT

Test Approach

I use Espresso API for creating UI Instrumented tests for Android App.
As far as it is open assignment without specific requirements, I have implemented test cases that check availability and behavior of Android App components.

Assumptions

I verify the correctness of elements values and behavior based on the values displayed in the Android App UI assuming them as the correct ones.

Structure

UITest class contains UI instrumented tests for Android App that make checks of UI Views (elements) and their behavior correctness.

There are following test cases:

whenAppIsLaunchedTheAppNameIsShown()
* Test checks the displayed name of the App Title is correct, assume “ReferenceAndroid” is correct value

whenClickOnOptionsMenuItHasSettingsMenuItem()
* Test checks the App Options Menu opens menu with item “Settings”, assume “Settings” is correct value

whenAppIsLaunchedItDispalysTextOnTheScreen()
* Test checks the text “Hello World!” is displayed on the screen, assume “Hello World!” is correct value

whenFloatingButtonClickedTheSnackbarMesssageIsShown()
* Test checks the click on floating button shows the snackbar with text, assume “Replace with your own action” is correct value

Further enhancements

If it is needed to run tests on several different Android devices and emulators I would recommend to use Spoon (http://square.github.io/spoon/) for creating test reports that contain screenshots for every test on every device.
To use Spoon Runner and Spoon Client (to make and save screenshots) external Jars needed to be added to project:

• spoon-runner-1.7.1-jar-with-dependencies.jar 
• spoon-client-1.7.1.jar

Plus add extra permissions to AndroidManifest.xml to be able to save screenshots to the files:

android:name="android.permission.READ_EXTERNAL_STORAGE"
android:name="android.permission.WRITE_EXTERNAL_STORAGE"

To run tests from command line with Spoon Runner use the following command:

java -jar spoon-runner-1.7.1-jar-with-dependencies.jar  --apk app.apk  --test-apk app-androidTest.apk --sdk /Users/username/Library/Android/sdk

Test run results and reports can be found in /spoon-output folder

