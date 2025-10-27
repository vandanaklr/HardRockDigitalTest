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
import utilities.ScreenshotUtilities;
//import static utilities.DriverFactory.driver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class HomePageTest {

    WebDriver driver;
    HomePage homePage;
    HomePage homepagelinkedIn;

    //opening the browser
    @BeforeClass
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup(); //setup chrome using webdrivermanager
        driver = new ChromeDriver(); //launch chrome
        driver.manage().window().maximize();
        //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//set implicit wait
    }

    //opening the url
    @Test(priority = 1)
    public void openHomePage() {

        driver.get("https://www.hardrockdigital.com/"); //open url
    }

    //clicking on twitter icon
    @Test(priority = 2)
    public void clickOnTwitterIcon() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickOnTwitterIcon();
    }

    //verifying twitter link opened correctly
    @Test(priority = 3)
    public void verifytwitterlink() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Opened URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("https://x.com/HardRockDigital"),
                "Twitter page did not open correctly!"
        );
        //twitter tab closed and cursor switched back to main url
        driver.close();
        System.out.println("Twitter tab closed successfully");
        driver.switchTo().window(tabs.get(0));
        System.out.println("switched back to Hard Rock Digital tab");
    }

    // Click LinkedIn icon
    @Test(priority = 4)
    public void clicklinkedInicon() {
        homepagelinkedIn = new HomePage(driver);
        homepagelinkedIn.clicklinkedInicon();
    }

    //verify LinkedIn icon opens HardRock Digital LinkedIn page
    @Test(priority = 5)
    public void verifylinkedInicon() throws InterruptedException {
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

    //closing the browser
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



