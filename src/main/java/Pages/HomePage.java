package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    private By serachBar = By.xpath("//input[@placeholder='Search for Products, Brands and More']");
    private By products = By.xpath("//div[@class='gqcSqV YGE0gZ']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void serachForProduct(String productName) {
        WebElement serachBarElement = driver.findElement(serachBar);
        serachBarElement.sendKeys(productName);
        serachBarElement.sendKeys(Keys.ENTER);

    }

    public void selectFirstProducts() {
        WebElement productsElement = driver.findElement(products);
        String mainWindowHandle = driver.getWindowHandle();
        productsElement.click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

    }
}
