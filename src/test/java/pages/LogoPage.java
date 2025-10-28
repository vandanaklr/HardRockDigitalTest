package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static utilities.DriverFactory.driver;

public class LogoPage {

    WebDriver driver;

    // Constructor to receive driver from test
    public LogoPage(WebDriver driver) {
        this.driver = driver;
    }

    // LogoPage implementation goes here
    //Verifying if logo is displayed on the page
    public boolean isLogoDisplayed() {
        // Implementation to check if logo is displayed
        WebElement logo=driver.findElement(By.cssSelector(".starting-logo.skip-lazy.default-logo"));
        boolean isDisplayed=logo.isDisplayed();
        Assert.assertTrue(isDisplayed,"Logo is not displayed");
      return isDisplayed; // Placeholder return value
    }
}
