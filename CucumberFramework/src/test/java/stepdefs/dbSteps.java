package stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.sql.*;


public class dbSteps {

    public WebDriver driver;

    public dbSteps(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public void connectDB() {
        String connectionUrl =
                "jdbc:sqlserver://yourserver.database.windows.net:1433;"
                        + "database=AdventureWorks;"
                        + "user=yourusername@yourserver;"
                        + "password=yourpassword;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        ResultSet resultSet = null;

//        try (Connection connection = DriverManager.getConnection(connectionUrl);
//             Statement statement = connection.createStatement();) {
//
//            // Create and execute a SELECT SQL statement.
//            String selectSql = "SELECT TOP 10 Title, FirstName, LastName from SalesLT.Customer";
//            resultSet = statement.executeQuery(selectSql);
//
//            // Print results from select statement
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
    }


}
