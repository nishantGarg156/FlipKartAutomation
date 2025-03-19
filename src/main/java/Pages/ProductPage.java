package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    char ch;
    private By sizeOfOption = By.xpath("//a[contains(@class,'CDDksN ')]");
    private By colourOptions = By.xpath("//span[contains(text(),'Color')]/following-sibling::div//div");
    private By addToBagButton = By.xpath("//button[contains(text(),'Add to cart')]");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectSize(String size) {
        try {
            WebElement sizeElement = driver.findElement(By.xpath(sizeOfOption + "//div[contains(text(),'" + size + "')]"));
            sizeElement.click();
        } catch (Exception e) {
            System.out.println("Size '" + size + "' not available, selecting default size.");
        }
    }

    public void selectColour(String color) {
        try {
            WebElement colorElement = driver.findElement(By.xpath(colourOptions + "//a[contains(@title,'" + color + "')]"));
            colorElement.click();
        } catch (Exception e) {
            System.out.println("Color '" + color + "' not available, selecting default color.");
        }

    }

    public void addToBag() {
        WebElement addToBagButtonElement = driver.findElement(addToBagButton);
        addToBagButtonElement.click();

    }
}
