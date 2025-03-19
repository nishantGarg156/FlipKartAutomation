package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    private By serachBar = By.xpath("//input[@placeholder='Search for Products, Brands and More']");
    private By navigateToCartButton = By.xpath("//span[contains(text(),'Cart')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void serachForProduct(String productName) {
        WebElement serachBarElement = driver.findElement(serachBar);
        serachBarElement.sendKeys(productName);
        serachBarElement.sendKeys(Keys.ENTER);

    }

    public void navigateToCart() {
        WebElement navigateToCartButtonElement = driver.findElement(navigateToCartButton);
        navigateToCartButtonElement.click();
    }


}
