package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BagPage {
    WebDriver driver;
    private By bagProductsName = By.xpath("//a[@class='T2CNXf QqLTQ-']");
    private By cartItems = By.xpath("//div[@class='eGXlor pk3Guc']");

    public BagPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getBagProductName() {
        return driver.findElement(bagProductsName).getText().trim();
    }

    public int bagItemCount() {
        return driver.findElements(cartItems).size();
    }
}
