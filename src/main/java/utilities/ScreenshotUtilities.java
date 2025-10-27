package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utilities.DriverFactory.driver;

public class ScreenshotUtilities {

    public static void capture(WebDriver driver, String name) {

    }

    public void takeScreenshot(String testName) {
        // Timestamp for unique screenshot names
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "screenshot_" + testName + "_" + timestamp + ".png";

        // Save under project directory → screenshots/
        String filePath = System.getProperty("user.dir") + "/screenshots/" + fileName;

        try {
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots"));
            Files.copy(srcFile.toPath(), Paths.get(filePath));
            System.out.println("📸 Screenshot captured: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
