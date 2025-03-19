package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BagPage {
    WebDriver driver;
    WebDriverWait wait;
    private By bagProductsName = By.xpath("//a[@class='T2CNXf QqLTQ-']");
    private By cartItems = By.xpath("//div[@class='eGXlor pk3Guc']");

    public BagPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getBagProductName() {
        return driver.findElement(bagProductsName).getText().trim();
    }

    public int bagItemCount() {
        //  wait.until(ExpectedConditions.elementToBeClickable(cartItems));
        return driver.findElements(cartItems).size();
    }
}
