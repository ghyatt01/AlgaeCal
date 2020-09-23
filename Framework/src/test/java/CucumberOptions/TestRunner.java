package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;


@RunWith(Cucumber.class)
@CucumberOptions (
        plugin = {"pretty"},
        glue = {"/src/test/java/stepDefinitions"},
        features = {"/src/test/java/features/MainSiteOrdersStage.feature"},
        tags = {"@smoke", "@wip","@regression"})
public class TestRunner {


}
