package com.freenow.android_demo.pages;

import android.support.test.espresso.action.ViewActions;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;

public class BasePage {

    public void pressBack() {
        onView(isRoot()).perform(ViewActions.pressBack());
    }

}
