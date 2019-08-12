package com.freenow.android_demo.pages;

import android.support.test.espresso.NoMatchingViewException;
import com.freenow.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/*
    @author: Ahmet Izgi
 */
public class LoginPage extends BasePage{

    /**
     * The constructor can be structured to verifies that we are on the correct page
     */
    public LoginPage() {
    }

    public boolean checkLoginFailMessageDisplayed() {
        try {
            onView(withText(R.string.message_login_fail)).check(matches(isDisplayed()));
            return true;
        } catch (NoMatchingViewException exception) {
            return false;
        }
    }

    /**
     * Perform the login
     *
     * @param userName Name of the user to login
     * @param password Password of the user to login
     */
    public void login(String userName, String password) {
        onView(withId(R.id.edt_username)).perform(typeText(userName));
        onView(withId(R.id.edt_password)).perform(typeText(password), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
    }
}
