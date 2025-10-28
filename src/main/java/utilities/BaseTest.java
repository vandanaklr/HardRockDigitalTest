package utilities;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    protected WebDriver driver;

    //Browser opens before each test method
    @BeforeMethod
    public void initializeDriver() {
        driver = DriverFactory.getDriver(); // assign first ✅
        driver.get("https://www.hardrockdigital.com/"); // then open site
        System.out.println("Navigated to Hard Rock Digital homepage.");
    }

    //Browser closes after each test method
    @AfterMethod
    public void tearDownMethod() {
        DriverFactory.quitDriver();
        System.out.println("Closed the browser after test method.");
    }


    @BeforeClass
    public void setup() {
        System.out.println("Setting up the test environment...");
        // later we’ll add WebDriver initialization here
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Cleaning up after tests...");
        if (driver != null) {
            driver.quit();
        }
    }



}