package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class MainsiteFunctional {

    public WebDriver driver;

    public MainsiteFunctional(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Links
    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Log In')]")
    private WebElement hcp_loginLink;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Sign Up')]")
    private WebElement hcp_signupLink;

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(pageLoadCondition);
    }

    public void navigate_to_hcp_page_production(){
        driver.navigate().to("https://www.algaecal.com/hcp/");
        waitForLoad(driver);
    }
    public void navigate_to_hcp_page_stage(){
        driver.navigate().to("https://stage.algaecal.com/hcp/");
        waitForLoad(driver);
    }

    public void if_hcp_popUp_shows_close_it(){

        for(int i=1 ; i<=5 ; i++)
        {
            try{
                if(driver.findElement(By.id("madison-ButtonElement--U1wi8PV68GDQ0RPQOziC")).isDisplayed()){
                    driver.switchTo().alert().accept();
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(By.id("madison-ButtonElement--U1wi8PV68GDQ0RPQOziC")));}
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
//        if(driver.findElement(By.id("madison-ButtonElement--U1wi8PV68GDQ0RPQOziC")).isDisplayed())
//        {
//        driver.findElement(By.id("madison-ButtonElement--U1wi8PV68GDQ0RPQOziC")).click();
//        }
    }

    public void verify_hcp_links(){
        assertEquals(hcp_loginLink.isDisplayed(),true);
        assertEquals(hcp_signupLink.isDisplayed(),true);

    }

    public String get_stage_links(String URL) throws IOException {
        InputStream input = new FileInputStream("src/test/java/config/StageURLS.properties");
        Properties prop = new Properties();

        // load a properties file
        prop.load(input);

        // get the property value and print it out
        System.out.println(prop.getProperty("URL"+URL));
        Object[] keys = prop.keySet().toArray();
        System.out.println(keys);
        System.out.println(keys.length);

        return URL;
    }

    public void verify_links_site_wide_stage() throws IOException {
        InputStream input = new FileInputStream("src/test/java/config/StageURLS.properties");
        Properties prop = new Properties();
        // load a properties file
        prop.load(input);
        Object[] keys = prop.keySet().toArray();
        int lengthOfPropertiesFile = keys.length;
        // get the property value and print it out
        int i = 0;
        while (i < lengthOfPropertiesFile) {
            System.out.println(prop.getProperty("URL" + i));

            String homePage = prop.getProperty("URL"+i);
            String url = "";
            HttpURLConnection huc = null;
            int respCode = 200;
            String message = null;
            String headerfield = null;
            //System.out.println("Links Below are for " + homePage);
            driver.get(homePage);
            System.out.println("Links Below are for " + homePage);
            List<WebElement> links = driver.findElements(By.tagName("a"));
            Assert.assertNotNull(links);
            Iterator<WebElement> it = links.iterator();
            while (it.hasNext()) {

                try{url = it.next().getAttribute("href");}
                catch(ElementNotInteractableException e){
                    System.out.println("ELEMENT NOT INTERACTABLE");
                   // e.printStackTrace();
                }
                catch(StaleElementReferenceException e){
                    //System.out.println("STALE ELEMENT");
                   // e.printStackTrace();
                }

                // System.out.println(url);

                if (url == null || url.length() == 0) {
                   // System.out.println(url + " - URL is either not configured for anchor tag or it is empty");
                    continue;
                }


                try {
                    try{huc = (HttpURLConnection) (new URL(url).openConnection());
                        huc.setRequestMethod("GET");

                        huc.connect();

                        respCode = huc.getResponseCode();
                        message = huc.getResponseMessage();


                    }
                    catch(ClassCastException e){
                        //e.printStackTrace();
                        System.out.println("HTTPURL Connection Class Exception");
                    }

                    if (respCode >= 400) {
                        System.out.println(url + " is a broken link");
                        System.out.println(message);
                        System.out.println(headerfield);
                    }
                    if (respCode >= 301 && respCode<400) {
                        System.out.println(url + " Gives 301 Response (Re-Direct)");
                        System.out.println(message);
                        System.out.println(headerfield);
                    } else {

                        //Enable This if you want to see all valid links
                        // System.out.println(url + " is a valid link");
                    }

                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    System.out.println("Erroneous Formatted URL at  "+url);
                    //e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        i++;}
    }

    public String set_phone_number(String transferPhoneSlug){
        String phone_slug = transferPhoneSlug;
        String phoneNumber = "";
        if(phone_slug.equalsIgnoreCase("adroll"))
        {
            phoneNumber="8776276074";
        }
        else if(phone_slug.equalsIgnoreCase("display")){
            phoneNumber="8776201456";
        }
        else if(phone_slug.equalsIgnoreCase("gads")){
            phoneNumber="8002246132";
        }
        else if(phone_slug.equalsIgnoreCase("gads-shop-brand")){
            phoneNumber="8779568898";
        }
        else if(phone_slug.equalsIgnoreCase("gads-shop-nonbrand")){
            phoneNumber="8779410472";
        }
        else if(phone_slug.equalsIgnoreCase("bing-shop-brand")){
            phoneNumber="8778549376";
        }
        else if(phone_slug.equalsIgnoreCase("bing-shop-nonbrand")){
            phoneNumber="8777122926";
        }
        else if(phone_slug.equalsIgnoreCase("bing")){
            phoneNumber="8779781503";
        }
        else if(phone_slug.equalsIgnoreCase("fb")){
            phoneNumber="8776739470";
        }
        else if(phone_slug.equalsIgnoreCase("pinterest")){
            phoneNumber="8773183793";
        }
        else{
            System.out.println("No Phone Number Match");
        }
        transferPhoneSlug = phoneNumber;
        return transferPhoneSlug;
    }

    public String removeCharfromPhone(String phoneNoSpaces){
        StringBuilder sb = new StringBuilder();
        String newnumber = "";
        if(phoneNoSpaces.length() > 0) {
            char[] chars = phoneNoSpaces.toCharArray();
            char t = 't';
            char e = 'e';
            char l = 'l';
            char colon = ':';
            char line = '-';
            char plus = '+';
            char space = ' ';
            //Arrays.sort(chars);

            //sb.append(chars[0]);
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != t && chars[i] != e && chars[i] != l && chars[i] != colon && chars[i] != line && chars[i] != plus && chars[i] != space) {
                    sb.append(chars[i]);
                }
            }
           // if (chars[0] == t)
           // {chars[0] = '';

            newnumber = sb.toString();
            //System.out.println("char method "+newnumber);
        }
        phoneNoSpaces=newnumber;
        return phoneNoSpaces;
    }

    public String insert_phone_slug_stage_homepage(String phone_slug){
        driver.get("https://stage.algaecal.com/?ph="+phone_slug);
        waitForLoad(driver);
        return phone_slug;
    }

    public String insert_phone_slug_stage_salesPages(String phone_slug, String salesPage){
        String stagetestURL = "https://stage.algaecal.com"+salesPage+"?ph="+phone_slug;
        driver.get("https://stage.algaecal.com"+salesPage+"?ph="+phone_slug);
        waitForLoad(driver);
        System.out.println("1st URL Of Test: "+stagetestURL);
        System.out.println("-----------------------------");
        System.out.println(" ");
        return phone_slug;
    }

    public String insert_phone_slug_prod_salesPages(String phone_slug, String salesPage){
        String stagetestURL = "https://www.algaecal.com"+salesPage+"?ph="+phone_slug;
        driver.get("https://www.algaecal.com"+salesPage+"?ph="+phone_slug);
        waitForLoad(driver);
        System.out.println("1st URL Of Test: "+stagetestURL);
        System.out.println("-----------------------------");
        System.out.println(" ");
        return phone_slug;
    }
    public void validate_product_pages_in_stage_for_phone_slugs(String phone_slug){
        driver.get("https://stage.algaecal.com/product/bone-builder-packs/");
        waitForLoad(driver);
        validate_phone_numbers_on_page(phone_slug);

        driver.get("https://stage.algaecal.com/product/algaecal-plus/");
        waitForLoad(driver);
        validate_phone_numbers_on_page(phone_slug);

        driver.get("https://stage.algaecal.com/product/strontium-boost/");
        waitForLoad(driver);
        validate_phone_numbers_on_page(phone_slug);

        driver.get("https://stage.algaecal.com/product/algaecal-basic/");
        waitForLoad(driver);
        validate_phone_numbers_on_page(phone_slug);

        driver.get("https://stage.algaecal.com/product/triple-omega3-fish-oil/");
        waitForLoad(driver);
        validate_phone_numbers_on_page(phone_slug);

        driver.get("https://stage.algaecal.com/product/omegatest/");
        waitForLoad(driver);
        validate_phone_numbers_on_page(phone_slug);
    }

    public void validate_cart_page_in_stage_for_phone_slugs(String phone_slug){
        driver.get("https://stage.algaecal.com/cart/");
        waitForLoad(driver);
        validate_phone_numbers_on_page(phone_slug);
    }

    public void validate_checkout_in_stage_for_phone_slugs(String phone_slug){
        driver.get("https://stage.algaecal.com/checkout?type=main");
        waitForLoad(driver);
        validate_phone_numbers_on_page(phone_slug);
    }

    public String validate_phone_numbers_on_page(String phone_slug){
        driver.navigate().refresh();
        waitForLoad(driver);
        int i = 0;
        String phoneNumber = set_phone_number(phone_slug);
        System.out.println(" ");
        System.out.println("Phone Number to Look for "+phoneNumber+" for phone slug "+phone_slug);
        String phonelink = "";
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Assert.assertNotNull(links);
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {

            try {
                phonelink = it.next().getAttribute("href");

            } catch (ElementNotInteractableException e) {
                System.out.println("ELEMENT NOT INTERACTABLE");
                // e.printStackTrace();
            } catch (StaleElementReferenceException e) {
                System.out.println("STALE ELEMENT");
                // e.printStackTrace();
            }
            try {
                if (phonelink.startsWith("tel")) {
                    phonelink = removeCharfromPhone(phonelink);
                    try{
                        Assert.assertEquals(phoneNumber,phonelink);
                    }
                    catch(AssertionError e){
                        System.out.println(driver.getCurrentUrl()+"  =Phone Number Incorrect:"+phonelink);
                    }
                }
            }
            catch(NullPointerException e){
                //System.out.println("href doesn't start with tel");
            }
        }
        driver.navigate().refresh();
        //waitForLoad(driver);
        return phone_slug;
    }
}
