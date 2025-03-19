package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    char ch;
    private By sizeOfOption = By.xpath("//a[contains(@class,'CDDksN ')]");
    private By colourOptions = By.xpath("//span[contains(text(),'Color')]/following-sibling::div//div");
    private By addToBagButton = By.xpath("//button[contains(text(),'Add to cart')]");
    private By placeOrderButton = By.xpath("//span[contains(text(),'Place Order')]");
    private By productName = By.xpath("//span[contains(@class,'VU-ZEz')]");
    private By products = By.xpath("//div[@class='gqcSqV YGE0gZ']");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectKProducts(int k) {
        List<WebElement> multipleProductsElement = driver.findElements(products);

        for (int i = 0; i < k; i++) {
            String mainWindowHandle = driver.getWindowHandle();
            multipleProductsElement.get(i).click();
            Set<String> windowHandles = driver.getWindowHandles();
            for (String handle : windowHandles) {
                if (!handle.equals(mainWindowHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }
            addToBag();
            wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderButton));
            driver.close();
            driver.switchTo().window(mainWindowHandle);

        }
        driver.navigate().refresh();
    }

    // ToSelectFirstProducts use this function in your testCase
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

    public void selectSize(String size) {
        try {

            WebElement sizeElement = wait.until(ExpectedConditions.presenceOfElementLocated(sizeOfOption));          //driver.findElement(By.xpath(sizeOfOption + "//div[contains(text(),'" + size + "')]"));
            sizeElement.click();
        } catch (Exception e) {
            System.out.println("Size '" + size + "' not available, selecting default size.");
        }
    }

    public void selectColour(String color) {
        try {
            WebElement colorElement = wait.until((ExpectedConditions.presenceOfElementLocated(colourOptions)));                     // driver.findElement(By.xpath(colourOptions + "//a[contains(@title,'" + color + "')]"));
            colorElement.click();
        } catch (Exception e) {
            System.out.println("Color '" + color + "' not available, selecting default color.");
        }

    }

    public String getProductName() {
        WebElement productNameElement = driver.findElement(productName);
        String ProductName = productNameElement.getText().trim();
        return ProductName;
    }

    public void addToBag() {
        selectColour("black");
        selectSize("M");
        WebElement addToBagButtonElement = wait.until(ExpectedConditions.elementToBeClickable(addToBagButton));
        addToBagButtonElement.click();

    }
}
