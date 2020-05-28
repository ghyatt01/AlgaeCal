package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AlgaeCal {
    WebDriver driver;

    public AlgaeCal(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.CSS, using = ".d-none:nth-child(2) div:nth-child(2) .ac-button:nth-child(2)")
    private WebElement add_to_cart_button;

    @FindBy(how = How.CSS, using = ".product-name > strong")
    private WebElement bundle_product;


    public void go_to_bundle_products_page() {
       driver.navigate().to("https://www.algaecal.com/product/bone-builder-packs/");
    }

    public void select_add_to_cart_button() throws InterruptedException {
        try{
            add_to_cart_button.click();
            } catch (NoSuchElementException e)
        {System.out.println("Button Not Found");}
    }

    public void assert_cart_page_URL(){
        waitForPageLoaded(driver);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://www.algaecal.com/cart/" );
    }

    public void assert_bundle_in_cart(){
            Assert.assertEquals(bundle_product.getText(),"Bone Builder Pack 6 Month Supply");

    }

    public void waitForPageLoaded(WebDriver driver) {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }


}
