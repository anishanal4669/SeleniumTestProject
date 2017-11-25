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

public class LaunchBrowser extends BasePage {
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

    @Then("^user verifies \"([^\"]*)\" tab is present on the screen$")
    public void user_verifies_something_tab_is_present_on_the_screen(String labelName) throws Throwable {
        Hm.validateLinksPresent(labelName);
    }

    @Then("^users hovers on \"([^\"]*)\" and then on \"([^\"]*)\" and then clicks on \"([^\"]*)\"$")
    public void users_hovers_on_something_and_then_on_something_and_then_clicks_on_something(String labelName, String labelName1, String labelName2) throws Throwable {
        BP.hoverElement(labelName, labelName1, labelName2);
    }

    @Then("^user waits maximum \"([^\"]*)\" seconds for pageload$")
    public void user_waits_maximum_something_seconds_for_pageload(int time) throws Throwable {
        BP.pageLoad(time);
    }

    @Then("^user click on the link \"([^\"]*)\"$")
    public void user_click_on_the_link_something(String labelName) throws Throwable {
        BP.scrollScreen();
        Hm.clickLink(labelName);

    }
}