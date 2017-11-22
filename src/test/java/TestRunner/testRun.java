package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "Features/" },
        glue = { "Stepdefs", "src/main/java/scriptUtil/BasePage" },
        format = {"pretty", "html:target/Destination"})
public class testRun {
	
}
