package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import pages.Mainsite;


public class TrackingSteps {
    WebDriver driver;
    
    @Given("I navigate to the production URL of {string}")
    public void iNavigateToTheProductionURLOf(String url) {
        ChromeOptions chOption = new ChromeOptions();
        ChromeDriverService chSvc = new ChromeDriverService.Builder().usingAnyFreePort().build();


        driver = new ChromeDriver(chSvc,chOption);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();

    }

    @When("I validate the product IDs from data layer for {string}")
    public void iValidateTheProductIDsFromDataLayerFor(String url) throws InterruptedException {
        Mainsite page = new Mainsite(driver);
        page.VerifyDatalayer(url);
        //driver.quit();
    }

    @Then("I will see the correct product IDs for {string}")
    public void iWillSeeTheCorrectProductIDsFor(String url) throws InterruptedException {
        Mainsite page = new Mainsite(driver);
        page.VerifyProductIDs(url);
        driver.quit();

    }

    @Given("I navigate to the production URL of {string} for datalayer tracking")
    public void iNavigateToTheProductionURLOfForDatalayerTracking(String url) {
        String pathToExtension = "/Users/Hyatt/Library/Application Support/Google/Chrome/Default/Extensions/kejbdjndbnbjgmefkgdddjlbokphdefk/20.65.0_0";
        ChromeOptions options = new ChromeOptions();
        options.addExtensions (new File("src/test/java/plugins/Tag-Assistant-(by-Google)_v20.65.0.crx"));
        options.addArguments("load-extension=" + pathToExtension);
        options.addArguments("--always-authorize-plugins=true");
        options.addArguments("--auto-open-devtools-for-tabs");
        options.addArguments("--whitelisted-ips=");
        options.addArguments("disable-infobars");

        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("chrome-extension://kejbdjndbnbjgmefkgdddjlbokphdefk/popup2.html?tabId=1020");
        driver.findElement(By.id("welcome-screen-done-button")).click();
        driver.findElement(By.id("turn-on-ta")).click();
        driver.navigate().refresh();
        driver.get(url);
        driver.manage().window().maximize();
        Mainsite page = new Mainsite(driver);
        page.waitForLoad(driver);
    }
}
