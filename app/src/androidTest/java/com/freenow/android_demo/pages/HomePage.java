package com.freenow.android_demo.pages;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.view.Gravity;

import com.freenow.android_demo.R;
import com.freenow.android_demo.activities.MainActivity;

import org.hamcrest.Matchers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;

public class HomePage extends BasePage {

    /**
     * The constructor can be structured to verifies that we are on the correct page
     */
    public HomePage() {
    }

    public boolean isOpened() {
        try {
            onView(withId(R.id.textSearch)).check(matches(isDisplayed()));
            return true;
        } catch (NoMatchingViewException exception) {
            return false;
        }
    }

    public void logout() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.nav_logout));

    }

    public void searchDriver(String parameter) {
        onView(withId(R.id.textSearch)).perform(typeText(parameter));
    }

    public boolean openDriverProfile(String parameter, MainActivity activity) {
        try {
            onView(withText(parameter)).inRoot(withDecorView(Matchers.not(is(activity.getWindow().getDecorView())))).perform(click());
            return true;
        } catch (NoMatchingViewException exception) {
            return false;
        }
    }
}
