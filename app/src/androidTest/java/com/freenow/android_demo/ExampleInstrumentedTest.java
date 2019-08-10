package com.freenow.android_demo;

import android.app.UiAutomation;
import android.content.Context;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import com.freenow.android_demo.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
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

//    @Before
//    public void grantPermission() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            UiAutomation.grantRuntimePermission().
//            getInstrumentation().getUiAutomation().executeShellCommand(
//                    "pm grant " + getTargetContext().getPackageName()
//                            + " android.permission.ACCESS_FINE_LOCATION");
//
//            Log.e("Notify", "Permission >> Granted");
//        }
//    }

//    @Test
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = getTargetContext();
//
//        assertEquals("com.freenow.android_demo", appContext.getPackageName());
//    }

//    @Test
//    public void user_can_enter_username() {
//        onView(withId(R.id.edt_username)).perform(typeText("Hello Baby"));
//    }

//    @Test
//    public void user_can_enter_password() {
//        onView(withId(R.id.edt_password)).perform(typeText("Password"));
//    }

    @Test
    public void user_can_enter_credentials_check_to_confirm_message_is_correct() {

        onView(withId(R.id.edt_username)).perform(typeText("Username"));
        onView(withId(R.id.edt_password)).perform(typeText("Password"));
        onView(withId(R.id.btn_login)).perform(click());

        onView(withText(R.string.message_login_fail)).check(matches(isDisplayed()));
    }

}
