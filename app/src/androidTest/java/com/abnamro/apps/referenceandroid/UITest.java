package com.abnamro.apps.referenceandroid;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import android.widget.TextView;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4.class)

@LargeTest
/* UITest class contains UI instrumented tests for Android App
that make checks of UI Views (elements) and their behavior correctness
 */
public class UITest {

    public static final String APP_NAME = "ReferenceAndroid";
    public static final String ACTION_SETTINGS_MENU_ITEM = "Settings";
    public static final String DISPLAYED_TEXT = "Hello World!";
    public static final String SNACKBAR_TEXT = "Replace with your own action";

    @Rule public ActivityScenarioRule<MainActivity> activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    // Test checks that displayed title is the App name
    // assuming “ReferenceAndroid” is correct value
    public void whenAppIsLaunchedTheAppNameIsShown() {
        onView(allOf(instanceOf(TextView.class), withParent(withId(R.id.toolbar))))
                .check(matches(withText(APP_NAME)));
    }

    @Test
    // Test checks the App Options Menu opens menu with item “Settings”
    // assuming “Settings” is correct value
    public void whenClickOnOptionsMenuItHasSettingsMenuItem() {
        openContextualActionModeOverflowMenu();
        onView(withText(ACTION_SETTINGS_MENU_ITEM))
                .perform(click());
    }

    @Test
    // Test checks the text “Hello World!” is displayed on the screen
    // assuming “Hello World!” is correct value
    public void whenAppIsLaunchedItDispalysTextOnTheScreen() {
        onView(withText(DISPLAYED_TEXT)).check(matches(isDisplayed()));
    }

    @Test
    // Test checks the click on floating button shows the snackbar with text
    // assuming “Replace with your own action” is correct value
    public void whenFloatingButtonClickedTheSnackbarMesssageIsShown() {
        onView(withId(R.id.fab)).perform(click());
        onView(withId(com.google.android.material.R.id.snackbar_text))
                .check(matches(withText(SNACKBAR_TEXT)));
    }
}
