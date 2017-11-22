package Stepdefs;

import PageObjects.Home;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import scriptUtil.BasePage;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;

public class LaunchBrowser extends BasePage{
    Home Hm = new Home();
    BasePage BP = new BasePage();
    @Given("^user launches Browser$")
    public void user_launches_browser() throws Throwable {
        BP.launchBrowser();
    }
    @When("^user launches the Url$")
    public void user_launches_the_url() throws Throwable {
        BP.launchUrl();
    }
//    @Then("^user clicks on \"([^\"]*)\"$")
//    public void user_clicks_on_something(String labelName) throws Throwable {
//        BP.clickElement(labelName);
//    }
    @Then("^user closes the alert present$")
    public void user_closes_the_alert_present() throws Throwable {
    Hm.closePop();
    }



    }
