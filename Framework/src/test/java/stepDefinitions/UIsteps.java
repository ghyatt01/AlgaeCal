package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import pages.Mainsite;
import pages.MainsiteFunctional;
import utility.Constant;

public class UIsteps {
    WebDriver driver;
    String ORDERIDMAIN="";
    
    @Given("I navigate to Algaecal.com")
    public void iNavigateToAlgaecalCom() {
        ChromeOptions chOption = new ChromeOptions();
        ChromeDriverService chSvc = new ChromeDriverService.Builder().usingAnyFreePort().build();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chSvc,chOption);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Constant.ProdURL);
        driver.manage().window().maximize();
        //remove ad consent message
//        if(driver.findElements(By.id("adroll_consent_reject")).size()>0) {
//            try {
//                WebElement rejectConsent = driver.findElement(By.id("adroll_consent_reject"));
//                rejectConsent.click();
//
//            } catch (NoSuchElementException e) {
//
//            } catch (ElementNotInteractableException e) {
//
//            }
//        }

        //remove recipe campaign
        if(driver.findElements(By.id("cambridge-NoButtonElement--hWzktMtfM26XvMIKwKkX")).size()>0) {
            try {
                //driver.switchTo().frame("__privateStripeFrame5");
                WebElement closeRecipePopUp = driver.findElement(By.id("cambridge-NoButtonElement--hWzktMtfM26XvMIKwKkX"));
                closeRecipePopUp.click();
            } catch (NoSuchElementException e) {

            } catch (ElementNotInteractableException e) {

            }
        }
    }

    @Given("I navigate to Stage.Algaecal.com")
    public void iNavigateToStageAlgaecalCom() {
       ChromeOptions chOption = new ChromeOptions();
       LoggingPreferences logPerfs = new LoggingPreferences();
       logPerfs.enable(LogType.PERFORMANCE, Level.ALL);
       chOption.setCapability("goog:loggingPrefs", logPerfs);
        WebDriverManager.chromedriver().setup();
        //ChromeDriverService chSvc = new ChromeDriverService.Builder().usingAnyFreePort().build();
       // DesiredCapabilities cap = new DesiredCapabilities();
       // cap.setBrowserName(BrowserType.CHROME);
       // driver = new RemoteWebDriver()
        driver = new ChromeDriver(chOption);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(Constant.StageURL);
        driver.manage().window().maximize();

        //remove ad consent message
//        if(driver.findElements(By.id("adroll_consent_reject")).size()>0) {
//            try {
//                WebElement rejectConsent = driver.findElement(By.id("adroll_consent_reject"));
//                rejectConsent.click();
//
//            } catch (NoSuchElementException e) {
//
//            } catch (ElementNotInteractableException e) {
//
//            }
//        }

        //remove recipe campaign
//        if(driver.findElements(By.id("cambridge-NoButtonElement--hWzktMtfM26XvMIKwKkX")).size()>0) {
//            try {
//                //driver.switchTo().frame("__privateStripeFrame5");
//                WebElement closeRecipePopUp = driver.findElement(By.id("cambridge-NoButtonElement--hWzktMtfM26XvMIKwKkX"));
//                closeRecipePopUp.click();
//            } catch (NoSuchElementException e) {
//
//            } catch (ElementNotInteractableException e) {
//
//            }
//        }

    }

    @Given("I navigate to Stage.Algaecal.com with phone slug {string}")
    public void iNavigateToStageAlgaecalComWithPhoneSlug(String phone_slug) {
        ChromeOptions chOption = new ChromeOptions();
        ChromeDriverService chSvc = new ChromeDriverService.Builder().usingAnyFreePort().build();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chSvc,chOption);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://stage.algaecal.com/?ph="+phone_slug);
        driver.manage().window().maximize();
    }



    @And("I navigate to the products page")
    public void iNavigateToTheProductsPage() {
        Mainsite page = new Mainsite(driver);
        page.selectProductPage();
        page.waitForLoad(driver);
    }

    @And("I select the {string} product")
    public void iSelectTheProduct(String product) {
        Mainsite page = new Mainsite(driver);
        page.selectProduct(product);
        page.waitForLoad(driver);
    }


    @And("I select the supply amount for the {string}")
    public void iSelectTheSupplyAmountForThe(String product) {
        Mainsite page = new Mainsite(driver);
        page.selectSupply(product);
        page.waitForLoad(driver);
    }

    @And("I verify the cart is accurate for {string}")
    public void iVerifyTheCartIsAccurateFor(String product) {
        Mainsite page = new Mainsite(driver);
       // page.VerifyCart(product);
    }


    @Then("I should see the order confirmation page in prod for {string}")
    public void iShouldSeeTheOrderConfirmationPageInProdFor(String productName) throws InterruptedException {
        Mainsite page = new Mainsite(driver);
        page.verifyProdConfirmationPageFromMainSite(productName);

    }

    @Then("I should see the order confirmation page in stage for {string}")
    public void iShouldSeeTheOrderConfirmationPageInStageFor(String productName) throws InterruptedException {
        Mainsite page = new Mainsite(driver);
        page.verifyStageConfirmationPageFromMainSite(productName);
    }

    @And("I should receive a confirmation email")
    public void iShouldReceiveAConfirmationEmail() {
        
    }

    @And("I should see the order reflected in BigCommerce")
    public void iShouldSeeTheOrderReflectedInBigCommerce() {
        Mainsite page = new Mainsite(driver);
       page.getOrderIDAndCheckBigCommerce(Constant.ORDERid);

    }

    @And("I do not select an upsell for {string}")
    public void iDoNotSelectAnUpsellFor(String product) throws InterruptedException {
        Mainsite page = new Mainsite(driver);
        page.skipUpsellAndGoToThankYouPageInStage(product);
    }



    @When("I complete canada checkout and place my order in stage environment")
    public void iCompleteCanadaCheckoutAndPlaceMyOrderInStageEnvironment() throws InterruptedException {
        Mainsite page = new Mainsite(driver);
        page.complete_canada_checkout_and_purchase_stage(5556);
    }

    @When("I complete canada checkout and place my order in production")
    public void iCompleteCanadaCheckoutAndPlaceMyOrderInProduction() throws InterruptedException {
        Mainsite page = new Mainsite(driver);
        page.complete_canada_checkout_and_purchase(4968);
    }

    @When("I complete USA checkout and place my order in stage environment with a test credit card ending in {string}")
    public void iCompleteUSACheckoutAndPlaceMyOrderInStageEnvironment(String cc) throws InterruptedException {
        Mainsite page = new Mainsite(driver);
        page.complete_usa_checkout_and_purchase_stage(5556);
    }

    @When("I complete USA checkout and place my order in production")
    public void iCompleteUSACheckoutAndPlaceMyOrderInProduction() throws InterruptedException {
        Mainsite page = new Mainsite(driver);
        page.complete_usa_checkout_and_purchase(8989);
    }

    @And("I navigate to HCP login page for production")
    public void iNavigateToHCPLoginPageForProduction() {
        Mainsite page = new Mainsite(driver);
        MainsiteFunctional functional = new MainsiteFunctional(driver);
        functional.navigate_to_hcp_page_production();
    }

    @Then("I will see all the correct page links for HCP production")
    public void iWillSeeAllTheCorrectPageLinksForHCPProduction() {
        MainsiteFunctional functional = new MainsiteFunctional(driver);
        functional.verify_hcp_links();
    }

    @After()
    public void after()
    {
        driver.close();
    }


    @And("I set the browser geolocation to an international location")
    public void iSetTheBrowserGeolocationToAnInternationalLocation() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.navigator.geolocation.getCurrentPosition=function(success){" +
                "var position = {\"coords\" : {\"latitude\": \"555\",\"longitude\": \"999\"}};" +
                "success(position);}");

        System.out.println(js.executeScript("var positionStr=\"\";" +
                "window.navigator.geolocation.getCurrentPosition(function(pos){positionStr=pos.coords.latitude+\":\"+pos.coords.longitude});" +
                "return positionStr;"));
    }

    @And("I navigate to HCP login page for stage")
    public void iNavigateToHCPLoginPageForStage() {
        MainsiteFunctional functional = new MainsiteFunctional(driver);
        functional.navigate_to_hcp_page_stage();

    }

    @Then("I will see all the correct page links for HCP Stage")
    public void iWillSeeAllTheCorrectPageLinksForHCPStage() {
        MainsiteFunctional functional = new MainsiteFunctional(driver);
        functional.verify_hcp_links();
    }

    @Then("I will navigate to each webpage and ensure the page loads and no links have a re-direct")
    public void iWillNavigateToEachWebpageAndEnsureThePageLoadsAndNoLinksHaveAReDirect() throws IOException {
        MainsiteFunctional functional = new MainsiteFunctional(driver);
       // functional.verify_links_site_wide_stage();
        functional.verify_links_site_wide_stage();
    }

    @When("I complete canada checkout and place my order in stage environment with sezzle")
    public void iCompleteCanadaCheckoutAndPlaceMyOrderInStageEnvironmentWithSezzle() {
        MainsiteFunctional functional = new MainsiteFunctional(driver);
    }

    @When("I complete canada checkout and place my order in production with sezzle")
    public void iCompleteCanadaCheckoutAndPlaceMyOrderInProductionWithSezzle() {
        MainsiteFunctional functional = new MainsiteFunctional(driver);
    }

    @When("I use phone slug {string} for the homepage in stage")
    public void iUsePhoneSlugForTheHomepageInStage(String phone_slug) {
        MainsiteFunctional functional = new MainsiteFunctional(driver);
        functional.insert_phone_slug_stage_homepage(phone_slug);
    }

    @Then("I will see the correct phone number for phone slug {string} on the homepage")
    public void iWillSeeTheCorrectPhoneNumberForPhoneSlugOnTheHomepage(String phone_slug) {
        MainsiteFunctional functional = new MainsiteFunctional(driver);
        functional.validate_phone_numbers_on_page(phone_slug);
    }

    @And("I will see the correct phone number for phone slug {string} on each product detail page")
    public void iWillSeeTheCorrectPhoneNumberForPhoneSlugOnEachProductDetailPage(String phone_slug) {
        MainsiteFunctional functional = new MainsiteFunctional(driver);
        functional.validate_product_pages_in_stage_for_phone_slugs(phone_slug);

    }

    @And("I will see the correct phone number for phone slug {string} on the cart page")
    public void iWillSeeTheCorrectPhoneNumberForPhoneSlugOnTheCartPage(String phone_slug) {
        MainsiteFunctional functional = new MainsiteFunctional(driver);
        functional.validate_cart_page_in_stage_for_phone_slugs(phone_slug);
    }

    @And("I will see the correct phone number for phone slug {string} on the checkout page")
    public void iWillSeeTheCorrectPhoneNumberForPhoneSlugOnTheCheckoutPage(String phone_slug) {
        MainsiteFunctional functional = new MainsiteFunctional(driver);
        functional.validate_checkout_in_stage_for_phone_slugs(phone_slug);
    }

    @And("I should see correct e-commerce datalayer tracking information for {string} on confirmation page")
    public void iShouldSeeCorrectECommerceDatalayerTrackingInformationForOnConfirmationPage(String product) throws InterruptedException {
        Mainsite page = new Mainsite(driver);
        page.VerifyEcommerceDataLayerTrackingOnCheckout(product);
    }

    @Given("I navigate to Stage.Algaecal.com with phone slug {string} for {string}")
    public void iNavigateToStageAlgaecalComWithPhoneSlugFor(String phoneSlug, String salesPage) {
        ChromeOptions chOption = new ChromeOptions();
        ChromeDriverService chSvc = new ChromeDriverService.Builder().usingAnyFreePort().build();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chSvc,chOption);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        MainsiteFunctional functional = new MainsiteFunctional(driver);
        functional.insert_phone_slug_stage_salesPages(phoneSlug, salesPage);
        driver.manage().window().maximize();
    }

    @Then("I will see the correct phone number for phone slug {string} on the first page I inserted the phone slug")
    public void iWillSeeTheCorrectPhoneNumberForPhoneSlugOnTheFirstPageIInsertedThePhoneSlug(String phone_slug) {
        MainsiteFunctional functional = new MainsiteFunctional(driver);
        functional.validate_phone_numbers_on_page(phone_slug);
    }

    @Given("I navigate to Algaecal.com with phone slug {string} for {string}")
    public void iNavigateToAlgaecalComWithPhoneSlugFor(String phoneSlug, String salesPage) {
        ChromeOptions chOption = new ChromeOptions();
        ChromeDriverService chSvc = new ChromeDriverService.Builder().usingAnyFreePort().build();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chSvc,chOption);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        MainsiteFunctional functional = new MainsiteFunctional(driver);
        functional.insert_phone_slug_stage_salesPages(phoneSlug, salesPage);
        driver.manage().window().maximize();
    }

    @And("I should see the IDK ID returned after the order is submitted for {string} in stage")
    public void iShouldSeeTheIDKIDReturnedAfterTheOrderIsSubmittedForStage(String productName) throws InterruptedException {
        Mainsite page = new Mainsite(driver);
        ApiSteps api = new ApiSteps(driver);
        page.verifyIDKafterOrderSubmission(productName);
        api.CheckIDKidResponseStage(productName);
    }

    @And("I should see the IDK ID returned after the order is submitted for {string} in prod")
    public void iShouldSeeTheIDKIDReturnedAfterTheOrderIsSubmittedForProd(String productName) throws InterruptedException {
        Mainsite page = new Mainsite(driver);
        ApiSteps api = new ApiSteps(driver);
        page.verifyIDKafterOrderSubmission(productName);
        api.CheckIDKidResponseProd(productName);
    }

    @When("I complete {string} checkout and place my order in stage environment with a test credit card ending in {string}")
    public void iCompleteCheckoutAndPlaceMyOrderInStageEnvironmentWithATestCreditCardEndingIn(String location, String creditCardNum) throws InterruptedException{
        Mainsite page = new Mainsite(driver);
        page.complete_checkout_in_stage_and_purchase(location,creditCardNum);


    }
}
