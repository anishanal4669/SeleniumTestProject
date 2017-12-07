package Stepdefs;

import PageObjects.Products;
import cucumber.api.java.en.Then;
import scriptUtil.BasePage;

public class Product_Stepdef extends BasePage {
Products Pts = new Products();
    @Then("^user clicks on the element \"([^\"]*)\"$")
    public void user_clicks_on_the_element_something(String labelName) throws Throwable {
        Pts.clickonButton(labelName);
    }

    @Then("^user scrolls the screen to \"([^\"]*)\"$")
    public void user_scrolls_the_screen_to_something(String labelName) throws Throwable {
        scrollintoView(labelName);
    }
    @Then("^user capture the table headers$")
    public void user_capture_the_table_headers() throws Throwable {
        handleFrame("ceeboxiframe");
        Pts.validateTableData();
        defaultContent();
    }
    @Then("^user clicks on \"([^\"]*)\" tab$")
    public void user_clicks_on_something_tab(String labelName) throws Throwable {
        clickElement(labelName);
    }




}
