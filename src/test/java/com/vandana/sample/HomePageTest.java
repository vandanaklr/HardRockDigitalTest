package com.vandana.sample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.BaseTest;
import utilities.DriverFactory;
import utilities.ScreenshotUtilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class HomePageTest extends BaseTest {

    // WebDriver driver;
    HomePage homePage;
    HomePage homepagelinkedIn;

    //clicking on twitter icon and verifying the URL
    @Test(priority = 1)
    public void clickOnTwitterIcon() throws InterruptedException {
        homePage = new HomePage(DriverFactory.getDriver());
        homePage.clickOnTwitterIcon();
        Thread.sleep(3000);//explicit wait for new tab to open

        //verifying twitter link opened correctly
        ArrayList<String> tabs = new ArrayList<>(DriverFactory.getDriver().getWindowHandles());
        DriverFactory.getDriver().switchTo().window(tabs.get(1));

        String currentUrl = DriverFactory.getDriver().getCurrentUrl();
        System.out.println("Opened URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("https://x.com/HardRockDigital"),
                "Twitter page did not open correctly!"
        );
        //twitter tab closed and cursor switched back to main url
        DriverFactory.getDriver().close();
        System.out.println("Twitter tab closed successfully");
        DriverFactory.getDriver().switchTo().window(tabs.get(0));
        System.out.println("switched back to Hard Rock Digital tab");
    }

    // Click LinkedIn icon and verifying the icon
    @Test(priority = 2)
    public void clicklinkedInicon() throws InterruptedException {
        homepagelinkedIn = new HomePage(DriverFactory.getDriver());
        homepagelinkedIn.clicklinkedInicon();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Opened URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("https://www.linkedin.com/company/hardrockdigital"),
                "LinkedIn page did not open correctly!"
        );
        Thread.sleep(1000);
        //LinkedIn tab closed and cursor switched back to main url
        driver.close();
        System.out.println("LinkedIn tab closed successfully");
        driver.switchTo().window(tabs.get(0));
        System.out.println("switched back to Hard Rock Digital tab");
    }

    @AfterMethod
    public void captureScreenshotIfFailed(ITestResult result) {
        // This method runs after every test
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtilities.capture(driver, result.getName());

        }
    }

}


