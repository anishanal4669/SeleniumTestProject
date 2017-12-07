package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

import java.util.Map;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "Features/Products.feature" },
        glue = { "Stepdefs", "src/main/java/scriptUtil/" },
        tags = { "@ignore"},
        format = {"pretty", "html:target/Destination"})
public class testRun {
    public static Map<String, String> config;
    public static Scenario scenario;
}
