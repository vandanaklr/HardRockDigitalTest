package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.openqa.selenium.By.*;

public class HomePage {

    WebDriver driver;
    public HomePage(WebDriver driver) {
        WebDriverManager.chromedriver().clearResolutionCache();
        WebDriverManager.chromedriver().setup();
        this.driver = driver;
    }
    //clicking on twitter icon
    public void clickOnTwitterIcon() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    Thread.sleep(1000);
    WebElement twitter = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector(".fa.fa-twitter")
    ));
   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",twitter);
    twitter.click();
}
    //clicking on linkedIn icon
     public void clicklinkedInicon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement linkedIn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".fa.fa-linkedin")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",linkedIn);
        linkedIn.click();
     }

}
