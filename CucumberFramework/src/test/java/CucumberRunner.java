import cucumber.api.CucumberOptions;
//import cucumber.api.testng.TestNGCucumberRunner;
//import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"/src/test/java/stepdefs"},
        tags = {"@smoke", "@wip","@regression"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class CucumberRunner {

}