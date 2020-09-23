package pages;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import static junit.framework.TestCase.assertTrue;
import static utility.Constant.IDK_id;

import stepdefs.ApiSteps;
import utility.Constant;

public class Mainsite {

    public WebDriver driver;

    public Mainsite(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Select Product
    @FindBy(how = How.ID, using = "menu-item-80216")
    private WebElement productPageLink;

    @FindBy(how = How.XPATH, using = "//a[@href='/product/bone-builder-packs/']")
    private WebElement BoneBuilderPack;

    @FindBy(how = How.XPATH, using = "//a[@href='/product/algaecal-plus/']")
    private WebElement AlgaeCalPlus;

    @FindBy(how = How.XPATH, using = "//a[@href='/product/strontium-boost/']")
    private WebElement StrontiumBoost;

    @FindBy(how = How.XPATH, using = "//a[@href='/product/algaecal-basic/']")
    private WebElement AlgaeCalBasic;

    @FindBy(how = How.XPATH, using = "//a[@href='/product/triple-omega3-fish-oil/']")
    private WebElement TripleOmega;

    @FindBy(how = How.XPATH, using = "//a[@href='/product/omegatest/']")
    private WebElement OmegaTest;

    //Select Supply

    //6 Month Supply
    @FindBy(how = How.XPATH, using = "//button[@data-bc-product-id='100367']")
    private WebElement BoneBuilderPacksupply;

    //6 Month Supply
    @FindBy(how = How.XPATH, using = "//button[@data-bc-product-id='115']")
    private WebElement AlgaeCalPlussupply;

    //6 Month Supply
    @FindBy(how = How.XPATH, using = "//button[@data-bc-product-id='118']")
    private WebElement StrontiumBoostsupply;

    //6 Bottle Supply
    @FindBy(how = How.XPATH, using = "//button[@data-bc-product-id='124']")
    private WebElement AlgaeCalBasicsupply;

    //6 Month Supply
    @FindBy(how = How.XPATH, using = "//button[@data-bc-product-id='127']")
    private WebElement TripleOmegasupply;

    //50 Per Kit
    @FindBy(how = How.XPATH, using = "//button[@data-bc-product-id='128']")
    private WebElement OmegaTestsupply;

    //Cart

    //ProductName
    @FindBy(how = How.XPATH, using = "//td[@class='product-name']")
    private WebElement CartProductName;

    @FindBy(how = How.XPATH, using = "//td[@class='heavy product-price d-md-none d-lg-table-cell']")
    private WebElement PricePerUnit;

    @FindBy(how = How.XPATH, using = "//td[@class='heavy product-subtotal text-primary Price-amount amount usd']")
    private WebElement CartSubtotal;

    //Checkout
    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary btn-lg btn-locked btn-block js-checkout-button']")
    private WebElement Checkout_button;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Checkout')]")
    private WebElement Checkout_button2;

    @FindBy(how = How.ID, using = "billing_first_name")
    private WebElement firstName_Billing;

    @FindBy(how = How.CSS, using = "input[name='first-name']")
    private WebElement firstName_Billing2;

    @FindBy(how = How.ID, using = "billing_last_name")
    private WebElement lastName_Billing;

    @FindBy(how = How.ID, using = "billing_email")
    private WebElement eMail_Billing;

    @FindBy(how = How.ID, using = "billing_phone_field")
    private WebElement phone_Billing;

    @FindBy(how = How.ID, using = "billing_country")
    private WebElement country_Billing;

    @FindBy(how = How.ID, using = "billing_address_1")
    private WebElement streetAdress_Billing;

    @FindBy(how = How.ID, using = "billing_city")
    private WebElement city_Billing;

    @FindBy(how = How.ID, using = "billing_state")
    private WebElement state_Billing;

    @FindBy(how = How.ID, using = "billing_postcode")
    private WebElement zip_Billing;

    //Credit Card
    @FindBy(how = How.XPATH, using = "//div[@class='CardNumberField-input-wrapper']")
    private WebElement cc_Billing;

    @FindBy(how = How.XPATH, using = "//input[@name='exp-date']")
    private WebElement expireDate_Billing;

    @FindBy(how = How.XPATH, using = "//input[@name='cvc']")
    private WebElement cvc_Billing;

    //Upsell Pages
    @FindBy(how = How.XPATH, using = "//div[@id='main-container']/article/div[2]/div[2]/button[2]")
    private WebElement noThankYouBB;

    @FindBy(how = How.XPATH, using = "//div[@id='main-container']/article/div[8]/button")
    private WebElement noThankYouAP;

    @FindBy(how = How.XPATH, using = "//div[@id='main-container']/article/div[2]/div[2]/button")
    private WebElement noThankYouSB;

    @FindBy(how = How.XPATH, using = "//div[@id='main-container']/article/div[2]/div[2]/button")
    private WebElement noThankYouAB;

    @FindBy(how = How.XPATH, using = "//div[@id='main-container']/article/div[8]/button")
    private WebElement noThankYouTFO;

    //DataLayer
    @FindBy(how = How.XPATH, using = "//td[@class='product-name']")
    private WebElement CartProductName2;


    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }


    public void selectProductPage() {
        productPageLink.click();
    }

    public String getOrderIDAndCheckBigCommerce (String order){

        Assert.assertNotNull(order);
        Assert.assertEquals(order.length(),6);
        System.out.println("ORDER ID = "+order);
        CheckOrderIDBigCommerceAPIprod(order);

        return order;
    }

    public String selectProduct(String product) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].click();", BoneBuilderPack);

        if (product.equalsIgnoreCase("Bone Builder Pack")) {
            js.executeScript("arguments[0].click();", BoneBuilderPack);
        }

        if (product.equalsIgnoreCase("AlgaeCal Plus")) {
            js.executeScript("arguments[0].click();", AlgaeCalPlus);
        }

        if (product.equalsIgnoreCase("Strontium Boost")) {
            js.executeScript("arguments[0].click();", StrontiumBoost);
        }

        if (product.equalsIgnoreCase("AlgaeCal Basic")) {
            js.executeScript("arguments[0].click();", AlgaeCalBasic);
        }

        if (product.equalsIgnoreCase("Triple Power Omega 3 Fish Oil")) {
            js.executeScript("arguments[0].click();", TripleOmega);
        }

        if (product.equalsIgnoreCase("Omega 3 Blood Test Kit")) {
            js.executeScript("arguments[0].click();", OmegaTest);
        }

        return product;
    }

    public String selectSupply(String product) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (product.equalsIgnoreCase("Bone Builder Pack")) {
            js.executeScript("arguments[0].click();", BoneBuilderPacksupply);
        }

        if (product.equalsIgnoreCase("AlgaeCal Plus")) {
            js.executeScript("arguments[0].click();", AlgaeCalPlussupply);
        }

        if (product.equalsIgnoreCase("Strontium Boost")) {
            js.executeScript("arguments[0].click();", StrontiumBoostsupply);
        }

        if (product.equalsIgnoreCase("AlgaeCal Basic")) {
            js.executeScript("arguments[0].click();", AlgaeCalBasicsupply);
        }

        if (product.equalsIgnoreCase("Triple Power Omega 3 Fish Oil")) {
            js.executeScript("arguments[0].click();", TripleOmegasupply);
        }

        if (product.equalsIgnoreCase("Omega 3 Blood Test Kit")) {
            js.executeScript("arguments[0].click();", OmegaTestsupply);
        }
        return product;
    }

    public String VerifyCart(String product) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Causing a Stale Element exception Here. Need to find a different way to pull text
        String productName = CartProductName.getText();
        String CartPricePerUnit = PricePerUnit.getText();
        String Subtotal = CartSubtotal.getText();

        if (product.equalsIgnoreCase("Bone Builder Pack")) {
            //6 Month Supply Cart
            assertTrue(productName.contains("Bone Builder Pack 6 Month Supply"));
            assertTrue(CartPricePerUnit.contains("$33"));
            assertTrue(Subtotal.contains("$396"));
        }

        if (product.equalsIgnoreCase("AlgaeCal Plus")) {
            //6 Month Supply Cart
            assertTrue(productName.contains("AlgaeCal Plus 6 Month Supply"));
            assertTrue(CartPricePerUnit.equalsIgnoreCase("$49"));
            assertTrue(Subtotal.equalsIgnoreCase("$294"));
        }

        if (product.equalsIgnoreCase("Strontium Boost")) {
            //6 Month Supply
            assertTrue(productName.contains("Strontium Boost 6 Month Supply"));
            assertTrue(CartPricePerUnit.equalsIgnoreCase("$22"));
            assertTrue(Subtotal.equalsIgnoreCase("$132"));
        }

        if (product.equalsIgnoreCase("AlgaeCal Basic")) {
            //6 Bottles Supply
            assertTrue(productName.contains("AlgaeCal Basic 6 Bottles"));
            assertTrue(CartPricePerUnit.equalsIgnoreCase("$33"));
            assertTrue(Subtotal.equalsIgnoreCase("$198"));
        }

        if (product.equalsIgnoreCase("Triple Power Omega 3 Fish Oil")) {
            //6 Bottle Pack
            assertTrue(productName.contains("Triple Power - 6 Bottle Pack"));
            assertTrue(CartPricePerUnit.equalsIgnoreCase("$37"));
            assertTrue(Subtotal.equalsIgnoreCase("$222"));
        }

        if (product.equalsIgnoreCase("Omega 3 Blood Test Kit")) {
            //50 Per Kit
            assertTrue(productName.contains("Omega 3 Blood Test 1 Kit"));
            assertTrue(CartPricePerUnit.equalsIgnoreCase("$50"));
            assertTrue(Subtotal.equalsIgnoreCase("$50"));
        }

        return product;
    }

    public void searchForAdConsentMessage(){
        if(driver.findElements(By.id("adroll_consent_reject")).size()>0) {
            try {
                WebElement rejectConsent = driver.findElement(By.id("adroll_consent_reject"));
                rejectConsent.click();

            } catch (NoSuchElementException e) {

            } catch (ElementNotInteractableException e) {

            }
        }
    }

    public void searchForRecipiePopUp(){
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


    public void select_checkout_button_at_cart(){
        for(int i=1 ; i<=5 ; i++)
        {
            try{
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", Checkout_button);
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        waitForLoad(driver);
    }

    public void click_place_my_order() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'Place My Order')]")).click();
            wait_for_progress_bar();
            waitForLoad(driver);
        //Thread.sleep(24000);
    }

    public void wait_for_progress_bar() throws InterruptedException{
        int i = 0;
        while(i < 10){
            if(driver.findElements(By.className("box")).size()>0){
                Thread.sleep(2000);
                i++;
            }
          if(driver.findElements(By.className("box")).size()==0){
                i = 10;
            }
        }
    }


    public String complete_checkout_in_stage_and_purchase(String location, String CreditCardNum) throws InterruptedException {
        select_checkout_button_at_cart();
        int card_number = Integer.parseInt(CreditCardNum);
        if (location.equalsIgnoreCase("canada")) {
            fill_in_checkout_form_canada_stage(card_number);
        }
        if(location.equalsIgnoreCase("usa")){
            fill_in_checkout_form_canada_stage(card_number);
        }
        if(location.equalsIgnoreCase("international")){
            //Insert Interational address checkout here
        }
        checkIDKeventonCheckout();
        click_place_my_order();

        return location;
    }

    public int complete_canada_checkout_and_purchase(int card_number) throws InterruptedException {

        select_checkout_button_at_cart();
        fill_in_checkout_form_canada(card_number);
        checkIDKeventonCheckout();
        click_place_my_order();
        return card_number;

    }

    public int complete_canada_checkout_and_purchase_stage(int card_number) throws InterruptedException {

        select_checkout_button_at_cart();
        fill_in_checkout_form_canada_stage(card_number);
        checkIDKeventonCheckout();
        click_place_my_order();
        return card_number;

    }

    public int complete_usa_checkout_and_purchase(int card_number) throws InterruptedException {

        select_checkout_button_at_cart();
        fill_in_checkout_form_USA(card_number);
        checkIDKeventonCheckout();
        click_place_my_order();
        return card_number;
    }

    public int complete_usa_checkout_and_purchase_stage(int card_number) throws InterruptedException {

        select_checkout_button_at_cart();
        fill_in_checkout_form_USA_stage(card_number);
        checkIDKeventonCheckout();
        click_place_my_order();
        return card_number;

    }

    public int fill_in_checkout_form_canada_stage(int card) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        fill_in_name_address_canada_stage();
        enter_Credit_Card_Stage(card);
        return card;
    }


    public int fill_in_checkout_form_canada(int card) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        fill_in_name_address_canada();
        enter_Credit_Card(card);
        return card;
    }

    public int fill_in_checkout_form_USA_stage(int card) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        fill_in_name_address_usa_stage();
        enter_Credit_Card_Stage(card);
        return card;
    }


    public int fill_in_checkout_form_USA(int card) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        fill_in_name_address_usa();
        enter_Credit_Card(card);
        return card;
    }

    public String checkIDKeventonCheckout() throws InterruptedException{
        JavascriptExecutor jsDataLayerIDKObject = (JavascriptExecutor) driver;

        EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
        //analyzeLogENTRIES();
        Thread.sleep(3000);
        //<input type="hidden" name="idk" :value="getIdk">

        Object result = jsDataLayerIDKObject.executeScript("return $nuxt.$store.getters['checkout/getIdk']");
        String resultstring = result.toString();
        //System.out.println("IDK response= "+resultstring);
        IDK_id = resultstring;
        return IDK_id;
    }

    public void fill_in_name_address_canada_stage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //FirstName
        firstName_Billing2.sendKeys("AutoTest");
        //Last Name
        driver.findElement(By.cssSelector("input[name='last-name']")).sendKeys("AutomationTest");
        //Email
        driver.findElement(By.cssSelector("input[name='email-address']")).sendKeys("automated_user_1@algaecal.com");
        //Phone
        driver.findElement(By.cssSelector("input[name='phone-number']")).sendKeys("1111111111");
        //Country
        Select drpCountry = new Select(driver.findElement(By.cssSelector("select[name='address-country']")));
        drpCountry.selectByValue("Canada");
        //Street Address
        driver.findElement(By.cssSelector("input[name='street-address']")).sendKeys("#300 - 22 5th Ave. E.");
        //City
        driver.findElement(By.cssSelector("input[name='address-locality']")).sendKeys("Vancouver");
        //State
        Select drpState = new Select(driver.findElement(By.cssSelector("select[name='address-state']")));
        drpState.selectByValue("British Columbia");
    }

    public void fill_in_name_address_canada(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //FirstName
        firstName_Billing2.sendKeys("AutoTest");
        //Last Name
        driver.findElement(By.cssSelector("input[name='last-name']")).sendKeys("AutomationTest");
        //Email
        driver.findElement(By.cssSelector("input[name='email-address']")).sendKeys("automated_user_1@algaecal.com");
        //Phone
        driver.findElement(By.cssSelector("input[name='phone-number']")).sendKeys("1111111111");
        //Country
        Select drpCountry = new Select(driver.findElement(By.cssSelector("select[name='address-country']")));
        drpCountry.selectByValue("Canada");
        //Street Address
        driver.findElement(By.cssSelector("input[name='street-address']")).sendKeys("#300 - 22 5th Ave. E.");
        //City
        driver.findElement(By.cssSelector("input[name='address-locality']")).sendKeys("Vancouver");
        //State
        Select drpState = new Select(driver.findElement(By.cssSelector("select[name='address-state']")));
        drpState.selectByValue("British Columbia");
    }

    public void fill_in_name_address_usa(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //FirstName
        firstName_Billing2.sendKeys("AutoTest");
        //Last Name
        driver.findElement(By.cssSelector("input[name='last-name']")).sendKeys("AutomationTest");
        //Email
        driver.findElement(By.cssSelector("input[name='email-address']")).sendKeys("automated_user_1@algaecal.com");
        //Phone
        driver.findElement(By.cssSelector("input[name='phone-number']")).sendKeys("1111111111");
        //Country
        Select drpCountry = new Select(driver.findElement(By.cssSelector("select[name='address-country']")));
        drpCountry.selectByValue("United States");
        //Street Address
        driver.findElement(By.cssSelector("input[name='street-address']")).sendKeys("5348 Vegas Drive");
        //City
        driver.findElement(By.cssSelector("input[name='address-locality']")).sendKeys("Las Vegas");
        //State
        Select drpState = new Select(driver.findElement(By.cssSelector("select[name='address-state']")));
        drpState.selectByValue("Nevada");
    }

    public void fill_in_name_address_usa_stage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //FirstName
        firstName_Billing2.sendKeys("AutoTest");
        //Last Name
        driver.findElement(By.cssSelector("input[name='last-name']")).sendKeys("AutomationTest");
        //Email
        driver.findElement(By.cssSelector("input[name='email-address']")).sendKeys("automated_user_1@algaecal.com");
        //Phone
        driver.findElement(By.cssSelector("input[name='phone-number']")).sendKeys("1111111111");
        //Country
        Select drpCountry = new Select(driver.findElement(By.cssSelector("select[name='address-country']")));
        drpCountry.selectByValue("United States");
        //Street Address
        driver.findElement(By.cssSelector("input[name='street-address']")).sendKeys("5348 Vegas Drive");
        //City
        driver.findElement(By.cssSelector("input[name='address-locality']")).sendKeys("Las Vegas");
        //State
        Select drpState = new Select(driver.findElement(By.cssSelector("select[name='address-state']")));
        drpState.selectByValue("Nevada");
    }


    public int enter_Credit_Card(int card_number) throws InterruptedException {

        if (card_number == 4968) {
            //Postal Code for Card
            driver.findElement(By.cssSelector("input[name='postal-code']")).sendKeys("V5T 1G8");
            //Credit Card
            driver.switchTo().frame("__privateStripeFrame5");
            //driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4514");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0300");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0646");
            Thread.sleep(1000);
            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4968");
            Thread.sleep(1000);
            String ccnum4968 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
           // System.out.println(ccnum4968);
            if (ccnum4968.equalsIgnoreCase("4514 0300 0646 4968")) {
                System.out.println("CC-OK");
            } else {
                for (int i = 0; i < 5; i++) {
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).clear();
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4514");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0300");
                    Thread.sleep(1000);
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0646");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4968");
                    Thread.sleep(1000);
                    String ccnum24968 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                    if (ccnum24968.equalsIgnoreCase("4514 0300 0646 4968")) {
                        i = i + 5;
                    } else {
                        i++;
                    }
                }
            }

                //Expire Date
                driver.switchTo().defaultContent();
                driver.switchTo().frame("__privateStripeFrame6");
                driver.findElement(By.cssSelector("input[name='exp-date']")).sendKeys("0223");

                //CVC
                driver.switchTo().defaultContent();
                driver.switchTo().frame("__privateStripeFrame7");
                driver.findElement(By.cssSelector("input[name='cvc']")).sendKeys("726");
                driver.switchTo().defaultContent();
                Thread.sleep(1000);
            }

            if (card_number == 8989) {
                //Postal Code For Card
                driver.findElement(By.cssSelector("input[name='postal-code']")).sendKeys("89108");

                //Credit Card
                driver.switchTo().frame("__privateStripeFrame5");
                driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4900");
                Thread.sleep(1000);
                driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("8020");
                Thread.sleep(1000);
                driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0141");
                Thread.sleep(1000);
                driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("8989");
                Thread.sleep(1000);
                String ccnum8989 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                //System.out.println(ccnum8989);
                if (ccnum8989.equalsIgnoreCase("4900 8020 0141 8989")) {
                    System.out.println("CC-OK");
                } else {
                    for (int i = 0; i < 5; i++) {
                        driver.findElement(By.cssSelector("input[name='cardnumber']")).clear();
                        driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                        driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4900");
                        driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("8020");
                        Thread.sleep(1000);
                        driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0141");
                        driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("8989");
                        Thread.sleep(1000);
                        String ccnum28989 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                        if (ccnum28989.equalsIgnoreCase("4900 8020 0141 8989")) {
                            i = i + 5;
                        } else {
                            i++;
                        }
                    }
                }

                    //Expire Date
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame("__privateStripeFrame6");
                    driver.findElement(By.cssSelector("input[name='exp-date']")).sendKeys("0422");

                    //CVC
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame("__privateStripeFrame7");
                    driver.findElement(By.cssSelector("input[name='cvc']")).sendKeys("705");
                    driver.switchTo().defaultContent();
                    Thread.sleep(1000);

                }
                if (card_number == 5556) {
                    //4000056655665556 Test Stripe VISA

                    //Postal Code for Card
                    driver.findElement(By.cssSelector("input[name='postal-code']")).sendKeys("V6B 1C6");
                    //Credit Card
                    driver.switchTo().frame("__privateStripeFrame5");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4000");
                    Thread.sleep(1000);
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0566");
                    Thread.sleep(1000);
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5566");
                    Thread.sleep(1000);
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5556");
                    Thread.sleep(1000);
                    String ccnum5556 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                    System.out.println(ccnum5556);
                    if (ccnum5556.equalsIgnoreCase("4000 0566 5566 5556")) {
                        System.out.println("CC-OK");
                    } else {
                        for (int i = 0; i < 5; i++) {
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).clear();
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4000");
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0566");
                            Thread.sleep(1000);
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5566");
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5556");
                            Thread.sleep(1000);
                            String ccnum25556 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                            if (ccnum25556.equalsIgnoreCase("4000 0566 5566 5556")) {
                                i = i + 5;
                            } else {
                                i++;
                            }
                        }
                    }

                        //Expire Date
                        driver.switchTo().defaultContent();
                        driver.switchTo().frame("__privateStripeFrame6");
                        driver.findElement(By.cssSelector("input[name='exp-date']")).sendKeys("0223");

                        //CVC
                        driver.switchTo().defaultContent();
                        driver.switchTo().frame("__privateStripeFrame7");
                        driver.findElement(By.cssSelector("input[name='cvc']")).sendKeys("726");
                        driver.switchTo().defaultContent();
                        Thread.sleep(1000);
                    }

        return card_number;
        }

            public int enter_Credit_Card_Stage ( int card_number) throws InterruptedException {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                if (card_number == 4968) {
                    //Postal Code for Card
                    driver.findElement(By.cssSelector("input[name='postal-code']")).sendKeys("V6B 1C6");

                    //Credit Card
                    driver.switchTo().frame("__privateStripeFrame5");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4514");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0300");
                    Thread.sleep(1000);
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0646");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4968");
                    Thread.sleep(1000);
                    String ccnum4968 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                   // System.out.println(ccnum4968);
                    if (ccnum4968.equalsIgnoreCase("4514 0300 0646 4968")) {
                        System.out.println("CC-OK");
                    } else {
                        for (int i = 0; i < 5; i++) {
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).clear();
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4514");
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0300");
                            Thread.sleep(1000);
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0646");
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4968");
                            Thread.sleep(1000);
                            String ccnum24968 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                            if (ccnum24968.equalsIgnoreCase("4514 0300 0646 4968")) {
                                i = i + 5;
                            } else {
                                i++;
                            }
                        }

                    }


                    //Expire Date
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame("__privateStripeFrame6");
                    driver.findElement(By.cssSelector("input[name='exp-date']")).sendKeys("0223");

                    //CVC
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame("__privateStripeFrame7");
                    driver.findElement(By.cssSelector("input[name='cvc']")).sendKeys("726");
                    driver.switchTo().defaultContent();
                    Thread.sleep(1000);
                }

                if (card_number == 8989) {
                    //Postal Code For Card
                    driver.findElement(By.cssSelector("input[name='postal-code']")).sendKeys("89108");

                    //Credit Card
                    driver.switchTo().frame("__privateStripeFrame5");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4900");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("8020");
                    Thread.sleep(1000);
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0141");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("8989");
                    Thread.sleep(1000);
                    String ccnum8989 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                    System.out.println(ccnum8989);
                    if (ccnum8989.equalsIgnoreCase("4900 8020 0141 8989")) {
                        System.out.println("CC-OK");
                    } else {
                        for (int i = 0; i < 5; i++) {
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).clear();
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4900");
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("8020");
                            Thread.sleep(1000);
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0141");
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("8989");
                            Thread.sleep(1000);
                            String ccnum28989 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                            if (ccnum28989.equalsIgnoreCase("4900 8020 0141 8989")) {
                                i = i + 5;
                            } else {
                                i++;
                            }
                        }

                    }

                    //Expire Date
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame("__privateStripeFrame6");
                    driver.findElement(By.cssSelector("input[name='exp-date']")).sendKeys("0422");

                    //CVC
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame("__privateStripeFrame7");
                    driver.findElement(By.cssSelector("input[name='cvc']")).sendKeys("705");
                    driver.switchTo().defaultContent();
                    Thread.sleep(1000);

                }
                if (card_number == 5556) {
                    //Test Stripe VISA

                    //Postal Code for Card
                    driver.findElement(By.cssSelector("input[name='postal-code']")).sendKeys("V6B 1C6");
                    //Credit Card
                    driver.switchTo().frame("__privateStripeFrame5");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4000");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0566");
                    Thread.sleep(1000);
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5566");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5556");
                    Thread.sleep(1000);
                    String ccnum5556 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                   // System.out.println(ccnum5556);
                    if (ccnum5556.equalsIgnoreCase("4000 0566 5566 5556")) {
                        System.out.println("CC-OK");
                    } else {
                        for (int i = 0; i < 5; i++) {
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).clear();
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4000");
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("0566");
                            Thread.sleep(1000);
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5566");
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5556");
                            Thread.sleep(1000);
                            String ccnum25556 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                            if (ccnum25556.equalsIgnoreCase("4000 0566 5566 5556")) {
                                i = i + 5;
                            } else {
                                i++;
                            }
                        }

                    }

                    //Expire Date
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame("__privateStripeFrame6");
                    driver.findElement(By.cssSelector("input[name='exp-date']")).sendKeys("0223");

                    //CVC
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame("__privateStripeFrame7");
                    driver.findElement(By.cssSelector("input[name='cvc']")).sendKeys("726");
                    driver.switchTo().defaultContent();
                    Thread.sleep(1000);
                }
                if (card_number == 4444) {
                    //Test Stripe MASTERCARD

                    //Postal Code for Card
                    driver.findElement(By.cssSelector("input[name='postal-code']")).sendKeys("V6B 1C6");
                    //Credit Card
                    driver.switchTo().frame("__privateStripeFrame5");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5555");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5555");
                    Thread.sleep(1000);
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5555");
                    driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4444");
                    Thread.sleep(1000);
                    String ccnum4444 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                    //System.out.println(ccnum4444);
                    if (ccnum4444.equalsIgnoreCase("5555 5555 5555 4444")) {
                        System.out.println("CC-OK");
                    } else {
                        for (int i = 0; i < 5; i++) {
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).clear();
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).click();
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5555");
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5555");
                            Thread.sleep(1000);
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("5555");
                            driver.findElement(By.cssSelector("input[name='cardnumber']")).sendKeys("4444");
                            Thread.sleep(1000);
                            String ccnum2444 = driver.findElement(By.cssSelector("input[name='cardnumber']")).getAttribute("value");
                            if (ccnum2444.equalsIgnoreCase("5555 5555 5555 4444")) {
                                i = i + 5;
                            } else {
                                i++;
                            }
                        }

                    }

                    //Expire Date
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame("__privateStripeFrame6");
                    driver.findElement(By.cssSelector("input[name='exp-date']")).sendKeys("0223");

                    //CVC
                    driver.switchTo().defaultContent();
                    driver.switchTo().frame("__privateStripeFrame7");
                    driver.findElement(By.cssSelector("input[name='cvc']")).sendKeys("726");
                    driver.switchTo().defaultContent();
                    Thread.sleep(1000);
                }
                return card_number;

            }
     public void verifyIDKafterOrderSubmission(String productName) throws InterruptedException{

        List<LogEntry> enteries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
        List<String> messages = new ArrayList<String>();
        //System.out.println(enteries.size()+"   Total enteries");

        for(LogEntry entry : enteries){
            messages.add(entry.getMessage());
        }
        int idkNetworkWillSendMessage = 0;
        int idkNetworkRecievedMessage = 0;

        for(int i=0;messages.size()>i;i++) {
            if (messages.get(i).contains("orders/?idk=") && messages.get(i).contains("Network.requestWillBeSent")) {
                idkNetworkWillSendMessage = i;
            }
            if (messages.get(i).contains("orders/?idk=") && messages.get(i).contains("Network.responseReceived")) {
                idkNetworkRecievedMessage  = i;
            }

        }
        //System.out.println("Network Will Send IDK ="+messages.get(idkNetworkWillSendMessage));
        //System.out.println("Network Response with IDK ="+messages.get(idkNetworkRecievedMessage));
         Assert.assertNotNull(messages.get(idkNetworkWillSendMessage));
         Assert.assertNotNull(messages.get(idkNetworkRecievedMessage));
     }

     public int setwhichproductpage(String productName){
         int i = 0;

         if (productName.equalsIgnoreCase("Bone Builder Pack")){
             i = 1;
         }
         if (productName.equalsIgnoreCase("AlgaeCal Plus")){
             i = 2;
         }
         if (productName.equalsIgnoreCase("Strontium Boost")){
             i = 3;
         }
         if (productName.equalsIgnoreCase("AlgaeCal Basic")){
             i = 4;
         }
         if (productName.equalsIgnoreCase("Triple Power Omega 3 Fish Oil")){
             i = 5;
         }
         if (productName.equalsIgnoreCase("Omega 3 Blood Test Kit")){
             i = 6;
         }
         return i;
     }

    public String verifyProdConfirmationPageFromMainSite(String productName) throws InterruptedException {

        int counter = setwhichproductpage(productName);
        switch (counter) {
            case 1:

                String URL1 = driver.getCurrentUrl();
                Assert.assertEquals(URL1, "https://www.algaecal.com/up/bbp-add-another");
                Assert.assertTrue(driver.findElement(By.className("purchased-product-header")).isDisplayed());
                break;

            case 2:
                String URL2 = driver.getCurrentUrl();
                Assert.assertEquals(URL2, "https://www.algaecal.com/up/tpo");
                Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Before you go…')]")).isDisplayed());
                break;

            case 3:
                String URL3 = driver.getCurrentUrl();
                Assert.assertEquals(URL3, "https://www.algaecal.com/up/sb");
                Assert.assertTrue(driver.findElement(By.className("purchased-product-header")).isDisplayed());
                break;

            case 4:
                String URL4 = driver.getCurrentUrl();
                //Assert.assertEquals(URL4, "https://stage.algaecal.com/sf/thank-you");
                Assert.assertEquals(URL4, "https://www.algaecal.com/up/ab");
                Assert.assertTrue(driver.findElement(By.className("purchased-product-header")).isDisplayed());
                break;

            case 5:
                String URL5 = driver.getCurrentUrl();
                Assert.assertEquals(URL5, "https://www.algaecal.com/up/tpo");
                Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Before you go…')]")).isDisplayed());

                break;

            case 6:
                String URL6 = driver.getCurrentUrl();
                Assert.assertEquals(URL6, "https://www.algaecal.com/sf/thank-you");
                break;

        }

        return productName;
    }

    public String verifyStageConfirmationPageFromMainSite(String productName) throws InterruptedException {

        int counter = setwhichproductpage(productName);
        switch (counter) {
            case 1:

                String URL1 = driver.getCurrentUrl();
                Assert.assertEquals(URL1, "https://stage.algaecal.com/up/bbp-add-another");
                Assert.assertTrue(driver.findElement(By.className("purchased-product-header")).isDisplayed());
                break;

            case 2:
                String URL2 = driver.getCurrentUrl();
                Assert.assertEquals(URL2, "https://stage.algaecal.com/up/tpo");
                Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Before you go…')]")).isDisplayed());
                break;

            case 3:
                String URL3 = driver.getCurrentUrl();
                Assert.assertEquals(URL3, "https://stage.algaecal.com/up/sb");
                Assert.assertTrue(driver.findElement(By.className("purchased-product-header")).isDisplayed());
                break;

            case 4:
                String URL4 = driver.getCurrentUrl();
                //Assert.assertEquals(URL4, "https://stage.algaecal.com/sf/thank-you");
                Assert.assertEquals(URL4, "https://stage.algaecal.com/up/ab");
                Assert.assertTrue(driver.findElement(By.className("purchased-product-header")).isDisplayed());
                break;

            case 5:
                String URL5 = driver.getCurrentUrl();
                Assert.assertEquals(URL5, "https://stage.algaecal.com/up/tpo");
                Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Before you go…')]")).isDisplayed());

                break;

            case 6:
                String URL6 = driver.getCurrentUrl();
                Assert.assertEquals(URL6, "https://stage.algaecal.com/sf/thank-you");
                break;

        }

            return productName;
    }

    public String skipUpsellAndGoToThankYouPageInStage(String productName) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int counter = setwhichproductpage(productName);

        switch (counter) {
            case 1:
                js.executeScript("arguments[0].click();", noThankYouBB);
                waitForLoad(driver);
                storeOrderIDonTHankyouPage();
                break;

            case 2:

                js.executeScript("arguments[0].click();", noThankYouAP);
                waitForLoad(driver);
                storeOrderIDonTHankyouPage();
                break;

            case 3:
                js.executeScript("arguments[0].click();", noThankYouSB);
                waitForLoad(driver);
                storeOrderIDonTHankyouPage();
                break;

            case 4:
                js.executeScript("arguments[0].click();", noThankYouAB);
                waitForLoad(driver);
                storeOrderIDonTHankyouPage();
                break;

            case 5:
                js.executeScript("arguments[0].click();", noThankYouTFO);
                waitForLoad(driver);
                storeOrderIDonTHankyouPage();
                break;

            case 6:
                String URL6 = driver.getCurrentUrl();
                Assert.assertEquals(URL6, "https://stage.algaecal.com/sf/thank-you");
                storeOrderIDonTHankyouPage();
                break;

        }


        return productName;
    }

    public void storeOrderIDonTHankyouPage(){
        String sentence = driver.findElement(By.xpath("//p[contains(text(),'Your Order')]")).getText();
        String[] sentenceSplit = sentence.split("\\s+");
        String orderID = sentenceSplit[3];
        Assert.assertNotNull(orderID);
        Assert.assertEquals(orderID.length(),6);
        Constant.ORDERid = orderID;
    }

    public String CheckOrderIDBigCommerceAPIprod(String order){
        ApiSteps api = new ApiSteps(driver);
        api.BigCommerceProductionCheckForOrderID(order);
        return order;
    }



    public JSONArray analyzeLog(JSONArray productIDs) throws InterruptedException {
        JavascriptExecutor jsDataLayerProductIDs = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        Object result = jsDataLayerProductIDs.executeScript("return (function(){var productIds = [];for( productKey in Algaecal.pageData.products ){if(typeof " +
                "Algaecal.pageData.products[productKey].algaecal_product_id !== 'undefined'){productIds.push(Algaecal.pageData.products[productKey].algaecal_product_id);}else{productIds.push(" +
                "Algaecal.pageData.products[productKey]);}}return productIds;})()");
        JSONArray list = new JSONArray(result.toString());
        productIDs = list;
        //System.out.println(list);
        return productIDs;
    }

    public void analyzeLogENTRIES() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            //System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            System.out.println(entry.getMessage());
            //do something useful with the data
        }
    }

    public String analyzeLogEcommerce(String product) throws InterruptedException {
        JavascriptExecutor jsDataLayerEcommerceObject = (JavascriptExecutor) driver;

        EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver);
        Thread.sleep(1000);
        Object result = jsDataLayerEcommerceObject.executeScript("return (window.dataLayer.filter(obj => obj.ecommerce).slice(-1).pop())");
        String resultstring = result.toString();
        //System.out.println(resultstring);
        String[] ecommerceObjectArray = resultstring.split("[{=,}]");


        //Assert Ecommerce Data

       // Assert.assertEquals("stripe",ecommerceObjectArray[18]);
        Assert.assertNotNull(ecommerceObjectArray[16]);

        if(product.equalsIgnoreCase("Bone Builder Pack")){

            Assert.assertNotNull(ecommerceObjectArray[20]);

        }
        if(product.equalsIgnoreCase("AlgaeCal Plus")){
            Assert.assertNotNull(ecommerceObjectArray[20]);

        }
        if(product.equalsIgnoreCase("Strontium Boost")){
            Assert.assertNotNull(ecommerceObjectArray[20]);

        }
        if(product.equalsIgnoreCase("AlgaeCal Basic")){
            Assert.assertNotNull(ecommerceObjectArray[20]);
        }

        if(product.equalsIgnoreCase("Triple Power Omega 3 Fish Oil")){
            Assert.assertNotNull(ecommerceObjectArray[20]);

        }
        if(product.equalsIgnoreCase("Omega 3 Blood Test Kit")){
            Assert.assertNotNull(ecommerceObjectArray[20]);
        }

        //JSONArray list = new JSONArray(result.toString());
        //product = list;
        //ORder ID in String
        String orderSentence = ecommerceObjectArray[34];
       // System.out.println(ecommerceObjectArray[34]);
        //System.out.println(orderSentence);
//        String [] orderSentenceSplit = orderSentence.split(" ");


        return product;
    }

    public String VerifyDatalayer(String url) throws InterruptedException {
        //JavascriptExecutor js_datalayer = (JavascriptExecutor) driver;
        JSONArray productIDreturn = analyzeLog(null);
        if (productIDreturn == null) {
            System.out.println("This URL has NO Product IDs returned" + url);
        } else {
            for (int i = 0; i < productIDreturn.length(); i++) {
                String one_ID = productIDreturn.get(i).toString();
                Assert.assertNotNull(one_ID);
            }
        }
        return url;

    }

    public String VerifyEcommerceDataLayerTrackingOnCheckout(String product) throws InterruptedException{

        String ecommerceObject = analyzeLogEcommerce(product);
        return product;
    }

    public String VerifyProductIDs(String url) throws InterruptedException {
        //The following hard-coded comparisons are based on this Google Document:
        // Facebook Product Catalog 2020:
        // https://docs.google.com/spreadsheets/d/11Rm04055GBHC3pimz4UaQasHRAs9xGuzhW14f9PzLxk/edit#gid=0
        JSONArray productIDreturn = analyzeLog(null);
        int size =  productIDreturn.length();
        int iterator = 0;
        int i = 0;

        //System.out.println(url);
        //Select Which URL to test in the SWITCH statement
        if (url.equalsIgnoreCase("https://www.algaecal.com/sp/apsb6a/us/dp/cs/natural-calcium/")) {
            i = 1;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/sp/apsb12a/sp/")) {
            i = 2;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/bone-builder-pack-1-month-supply/")) {
            i = 3;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/bone-builder-pack-3-month-supply/")) {
            i = 4;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/bone-builder-pack-6-month-supply/")) {
            i = 5;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/algaecal-plus-1-month-supply/")) {
            i = 6;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/algaecal-plus-3-month-supply/")) {
            i = 7;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/algaecal-plus-6-month-supply/")) {
            i = 8;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/algaecal-basic-1-month-supply/")) {
            i = 9;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/algaecal-basic-3-month-supply/")) {
            i = 10;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/strontium-boost-1-month-supply/")) {
            i = 11;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/strontium-boost-3-month-supply/")) {
            i = 12;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/strontium-boost-6-month-supply/")) {
            i = 13;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/triple-power-omega-3-fish-oil-1-bottle/")) {
            i = 14;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/triple-power-omega-3-fish-oil-3-month-supply/")) {
            i = 15;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/products/triple-power-omega-3-fish-oil-6-month-supply/")) {
            i = 16;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/product/bone-builder-packs/")) {
            i = 17;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/product/algaecal-plus/")) {
            i = 18;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/product/strontium-boost/")) {
            i = 19;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/product/algaecal-basic/")) {
            i = 20;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/product/triple-omega3-fish-oil/")) {
            i = 21;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/product/omegatest/")) {
            i = 22;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/sp/apsb12a/order/starter")) {
            i = 23;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/sp/apsb12a/order/3month")) {
            i = 24;
        }
        if (url.equalsIgnoreCase("https://www.algaecal.com/sp/apsb12a/order/6month")) {
            i = 25;
        }

//System.out.println(i);

        switch (i) {
            case 1:
                //Note From Asana: (1,3,6 bbp) "inside_count(#)" == # of Products to Search
                int inside_count1 = 3;
                while(iterator < size && inside_count1 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("39274")) { inside_count1--; }
                    if (productIDreturn.get(iterator).toString().contains("15504")) { inside_count1--; }
                    if (productIDreturn.get(iterator).toString().contains("15506")) { inside_count1--; }
                    iterator++;
                }
                    if (inside_count1 !=0){ System.out.println("Product ID is Missing at " +url); }

                break;

            case 2:
                //Note From Asana: (1,3,6 bbp) "inside_count" == # of Products to Search
                int inside_count2 = 3;
                while(iterator < size && inside_count2 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("39274")) { inside_count2--; }
                    if (productIDreturn.get(iterator).toString().contains("15504")) { inside_count2--; }
                    if (productIDreturn.get(iterator).toString().contains("15506")) { inside_count2--; }
                    iterator++;
                }
                if (inside_count2 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 3:
                //Note From Asana: (1 bbp) "inside_count" == # of Products to Search
                int inside_count3 = 1;
                while(iterator < size && inside_count3 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("39274")) { inside_count3--; }
                    iterator++;
                }
                if (inside_count3 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 4:
                //Note From Asana: (3 bbp) "inside_count" == # of Products to Search
                int inside_count4 = 1;
                while(iterator < size && inside_count4 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15504")) { inside_count4--; }
                    iterator++;
                }
                if (inside_count4 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 5:
                //Note From Asana: (6 bbp) "inside_count" == # of Products to Search
                int inside_count5 = 1;
                while(iterator < size && inside_count5 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15506")) { inside_count5--; }
                    iterator++;
                }
                if (inside_count5 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 6:
                //Note From Asana: (1 ap) "inside_count" == # of Products to Search
                int inside_count6 = 1;
                while(iterator < size && inside_count6 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15497")) { inside_count6--; }
                    iterator++;
                }
                if (inside_count6 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 7:
                //Note From Asana: (3 ap) "inside_count" == # of Products to Search
                int inside_count7 = 1;
                while(iterator < size && inside_count7 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15498")) { inside_count7--; }
                    iterator++;
                }
                if (inside_count7 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 8:
                //Note From Asana: (6 ap) "inside_count" == # of Products to Search
                int inside_count8 = 1;
                while(iterator < size && inside_count8 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15499")) { inside_count8--; }
                    iterator++;
                }
                if (inside_count8 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 9:
                //Note From Asana: (1 ab) "inside_count" == # of Products to Search
                int inside_count9 = 1;
                while(iterator < size && inside_count9 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15572")) { inside_count9--; }
                    iterator++;
                }
                if (inside_count9 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 10:
                //Note From Asana: (1 ab) "inside_count" == # of Products to Search
                int inside_count10 = 1;
                while(iterator < size && inside_count10 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15574")) { inside_count10--; }
                    iterator++;
                }
                if (inside_count10 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 11:
            //Note From Asana: (1 sb) "inside_count" == # of Products to Search
            int inside_count11 = 1;
            while(iterator < size && inside_count11 != 0) {
                if (productIDreturn.get(iterator).toString().contains("15500")) { inside_count11--; }
                iterator++;
            }
            if (inside_count11 !=0){ System.out.println("Product ID is Missing at " +url); }
            break;

            case 12:
                //Note From Asana: (3 sb) "inside_count" == # of Products to Search
                int inside_count12 = 1;
                while(iterator < size && inside_count12 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15501")) { inside_count12--; }
                    iterator++;
                }
                if (inside_count12 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 13:
                //Note From Asana: (6 sb) "inside_count" == # of Products to Search
                int inside_count13 = 1;
                while(iterator < size && inside_count13 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15502")) { inside_count13--; }
                    iterator++;
                }
                if (inside_count13 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 14:
                //Note From Asana: (1 tb) "inside_count" == # of Products to Search
                int inside_count14 = 1;
                while(iterator < size && inside_count14 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("26269")) { inside_count14--; }
                    iterator++;
                }
                if (inside_count14 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 15:
                //Note From Asana: (3 tb) "inside_count" == # of Products to Search
                int inside_count15 = 1;
                while(iterator < size && inside_count15 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("26272")) { inside_count15--; }
                    iterator++;
                }
                if (inside_count15 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 16:
                //Note From Asana: (6 tb) "inside_count" == # of Products to Search
                int inside_count16 = 1;
                while(iterator < size && inside_count16 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("26275")) { inside_count16--; }
                    iterator++;
                }
                if (inside_count16 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 17:
                //Note From Asana: (3, 6,12 bbp) "inside_count" == # of Products to Search
                int inside_count17 = 3;
                while(iterator < size && inside_count17 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15504")) { inside_count17--; }
                    if (productIDreturn.get(iterator).toString().contains("15506")) { inside_count17--; }
                    if (productIDreturn.get(iterator).toString().contains("15508")) { inside_count17--; }
                    iterator++;
                }
                if (inside_count17 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 18:
                //Note From Asana: (1,3,6 ap) "inside_count" == # of Products to Search
                int inside_count18 = 3;
                while(iterator < size && inside_count18 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15497")) { inside_count18--; }
                    if (productIDreturn.get(iterator).toString().contains("15498")) { inside_count18--; }
                    if (productIDreturn.get(iterator).toString().contains("15499")) { inside_count18--; }
                    iterator++;
                }
                if (inside_count18 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;
            case 19:
            //Note From Asana: (1,3,6 sb) "inside_count" == # of Products to Search
            int inside_count19 = 3;
            while(iterator < size && inside_count19 != 0) {
                if (productIDreturn.get(iterator).toString().contains("15500")) { inside_count19--; }
                if (productIDreturn.get(iterator).toString().contains("15501")) { inside_count19--; }
                if (productIDreturn.get(iterator).toString().contains("15502")) { inside_count19--; }
                iterator++;
            }
            if (inside_count19 !=0){ System.out.println("Product ID is Missing at " +url); }
            break;

            case 20:
                //Note From Asana: (1,3,6 ab) "inside_count" == # of Products to Search
                int inside_count20 = 3;
                while(iterator < size && inside_count20 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15572")) { inside_count20--; }
                    if (productIDreturn.get(iterator).toString().contains("15574")) { inside_count20--; }
                    if (productIDreturn.get(iterator).toString().contains("15577")) { inside_count20--; }
                    iterator++;
                }
                if (inside_count20 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 21:
                //Note From Asana: (1,3,6 tp) "inside_count" == # of Products to Search
                int inside_count21 = 3;
                while(iterator < size && inside_count21 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("26269")) { inside_count21--; }
                    if (productIDreturn.get(iterator).toString().contains("26272")) { inside_count21--; }
                    if (productIDreturn.get(iterator).toString().contains("26275")) { inside_count21--; }
                    iterator++;
                }
                if (inside_count21 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 22:
                //Note From Asana: (1,2,4 OQ) "inside_count" == # of Products to Search
                int inside_count22 = 3;
                while(iterator < size && inside_count22 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("26539")) { inside_count22--; }
                    if (productIDreturn.get(iterator).toString().contains("26541")) { inside_count22--; }
                    if (productIDreturn.get(iterator).toString().contains("26544")) { inside_count22--; }
                    iterator++;
                }
                if (inside_count22 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 23:
                //Note From Asana: (1 bbp) "inside_count" == # of Products to Search
                int inside_count23 = 1;
                while(iterator < size && inside_count23 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("39274")) { inside_count23--; }
                    iterator++;
                }
                if (inside_count23 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 24:
                //Note From Asana: (3 bbp) "inside_count" == # of Products to Search
                int inside_count24 = 1;
                while(iterator < size && inside_count24 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15504")) { inside_count24--; }
                    iterator++;
                }
                if (inside_count24 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            case 25:
                //Note From Asana: (6 bbp) "inside_count" == # of Products to Search
                int inside_count25 = 1;
                while(iterator < size && inside_count25 != 0) {
                    if (productIDreturn.get(iterator).toString().contains("15506")) { inside_count25--; }
                    iterator++;
                }
                if (inside_count25 !=0){ System.out.println("Product ID is Missing at " +url); }
                break;

            default:
                System.out.println("No URL MATCH FROM FEATURE FILE " + url);
        }




return url;
    }

    public String checkOrderIDinBigCommerceStage(String order){
        driver.get("https://stage.algaecal.com");
        return order;
    }

    public void confirmationPage(){

    }
}

