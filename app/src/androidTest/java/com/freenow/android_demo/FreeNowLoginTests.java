package com.freenow.android_demo;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import com.freenow.android_demo.activities.MainActivity;
import com.freenow.android_demo.pages.HomePage;
import com.freenow.android_demo.pages.LoginPage;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class FreeNowLoginTests {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @BeforeClass
    public static void beforeClass() {
    }

    @Test
    public void login_with_valid_credentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("crazydog335", "venture");

        HomePage homePage = new HomePage();
        Assert.assertEquals(true, homePage.isOpened());
        homePage.logout();
    }

    @Test
    public void login_with_wrong_password() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("crazydog335", "wrongpassword");

        Assert.assertEquals(true, loginPage.checkLoginFailMessageDisplayed());
    }

    @Test
    public void login_with_empty_fields() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("", "");

        Assert.assertEquals(true, loginPage.checkLoginFailMessageDisplayed());
    }

    @Test
    public void search_invalid_driver() throws InterruptedException {
        new LoginPage().login("crazydog335", "venture");

        HomePage homePage = new HomePage();
        homePage.searchDriver("jackson");
        Thread.sleep(2000);
        Assert.assertEquals(false, homePage.openDriverProfile("Invalid Driver Name", rule.getActivity()));

        homePage.logout();
    }


    @Test
    public void search_valid_driver_and_open_profile() throws InterruptedException {
        new LoginPage().login("crazydog335", "venture");

        HomePage homePage = new HomePage();
        homePage.searchDriver("jackson");
        Thread.sleep(2000);
        Assert.assertEquals(true, homePage.openDriverProfile("Jackson Lopez", rule.getActivity()));

        homePage.pressBack();

        homePage.logout();
    }
}
