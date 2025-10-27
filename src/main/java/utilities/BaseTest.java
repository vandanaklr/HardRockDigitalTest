package utilities;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    protected WebDriver driver;

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