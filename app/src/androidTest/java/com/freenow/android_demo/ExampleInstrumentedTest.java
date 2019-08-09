package com.freenow.android_demo;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import android.text.TextUtils;

import com.freenow.android_demo.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.freenow.android_demo", appContext.getPackageName());
    }

    @Test
    public void user_can_enter_username() {
        onView(withId(R.id.edt_username)).perform(typeText("Hello Baby"));
    }

    @Test
    public void user_can_enter_password() {
        onView(withId(R.id.edt_password)).perform(typeText("Password"));
    }

    @Test
    public void user_can_enter_credentials_check_to_confirm_message_is_correct() throws InterruptedException {

        onView(withId(R.id.edt_username)).perform(typeText("Username"));
        onView(withId(R.id.edt_password)).perform(typeText("Password"));
        onView(withId(R.id.btn_login)).perform(click());

        onView(withText(R.string.message_login_fail)).check(matches(isDisplayed()));
    }

}
