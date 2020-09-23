package stepdefs;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static utility.Constant.IDK_id;

import pages.Mainsite;


public class ApiSteps {


    public WebDriver driver;

    public ApiSteps(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String BigCommerceProductionCheckForOrderID(String orderID) {
        Mainsite UIpage = new Mainsite(driver);
        //orderID = UIpage.getOrderID("");

        System.out.println(" in bigCommerce API method, order ID is "+orderID);

        given().header("X-Auth-Client", "a72fht0wt28bq90lqmm5t9caxgo259o")
                .and().header("X-Auth-Token","k8hkts3iucnys4jnsls5tt132ttwgf8")
                .when().
                get("https://api.bigcommerce.com/stores/91vdl7wdzc/v2/orders/"+orderID).
                then().statusCode(200).assertThat()
                .body("id", notNullValue());

        return orderID;
    }

    public String CheckIDKidResponseStage(String productName) {

        System.out.println(" From Checkout Page, the IDK ID is "+IDK_id);

        given().header("X-Auth-Client", "a72fht0wt28bq90lqmm5t9caxgo259o")
                .and().header("X-Auth-Token","k8hkts3iucnys4jnsls5tt132ttwgf8")
                .when().
                get("https://stage.algaecal.com/bc/v2/orders/?idk="+IDK_id).
                then().statusCode(200).assertThat();
        return productName;
    }

    public String CheckIDKidResponseProd(String productName) {

        System.out.println(" From Checkout Page, the IDK ID is "+IDK_id);

        given().header("X-Auth-Client", "a72fht0wt28bq90lqmm5t9caxgo259o")
                .and().header("X-Auth-Token","k8hkts3iucnys4jnsls5tt132ttwgf8")
                .when().
                get("https://wwws.algaecal.com/bc/v2/orders/?idk="+IDK_id).
                then().statusCode(200).assertThat();
        return productName;
    }






}
