package com.vandana.sample;

import org.testng.annotations.Test;
import pages.LogoPage;
import utilities.BaseTest;
import utilities.DriverFactory;


public class LogoPageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyLogoDisplayed() {
        LogoPage logoPage = new LogoPage(DriverFactory.getDriver());
        boolean isDisplayed = logoPage.isLogoDisplayed();
        System.out.println("Logo displayed: " + isDisplayed);
    }
}