package bindings;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

import pages.AlgaeCal;

public class StepDefinition_UI {
    WebDriver driver;


    @Given("^I enter AlgaeCal\\.com$")
    public void iEnterAlgaeCalCom() {
        ChromeOptions chOption = new ChromeOptions();
        ChromeDriverService chSvc = new ChromeDriverService.Builder().usingAnyFreePort().build();
        driver = new ChromeDriver(chSvc,chOption);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.algaecal.com");
        driver.manage().window().maximize();
    }

    @And("^I navigate to the bone builder packs page$")
    public void iNavigateToTheBoneBuilderPacksPage() {
        AlgaeCal page = new AlgaeCal(driver);
        page.go_to_bundle_products_page();
        
    }

    @When("^I select the add to cart button for (\\d+) monthly supply$")
    public void iSelectTheAddToCartButtonForMonthlySupply(int arg0) throws InterruptedException {
        AlgaeCal page = new AlgaeCal(driver);
        page.select_add_to_cart_button();
    }

    @Then("^I will see that I am on the cart page$")
    public void iWillSeeThatIAmOnTheCartPage() {
        AlgaeCal page = new AlgaeCal(driver);
        page.assert_cart_page_URL();
        
    }

    @And("^I will see the bundle adding to the cart$")
    public void iWillSeeTheBundleAddingToTheCart() {
        AlgaeCal page = new AlgaeCal(driver);
        page.assert_bundle_in_cart();
        driver.quit();
    }
}
