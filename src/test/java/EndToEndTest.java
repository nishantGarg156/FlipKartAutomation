import Pages.BagPage;
import Pages.BasePage;
import Pages.HomePage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BasePage {
    HomePage homePage;
    ProductPage productPage;
    BagPage bagPage;

    @Test
    public void verifyProductaddedToCart() {
        getDriver().get("https://www.flipkart.com/");
        homePage = new HomePage(getDriver());
        productPage = new ProductPage(getDriver());
        bagPage = new BagPage(getDriver());
        homePage.serachForProduct("shirt");
        productPage.selectKProducts(3);
        homePage.navigateToCart();
        Assert.assertEquals(bagPage.bagItemCount(), 3, "Expected 3 item in the cart!");
    }


}
