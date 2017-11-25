package Stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import org.junit.After;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import scriptUtil.BasePage;

import static org.junit.Assert.*;

public class BasePageTest extends BasePage {
    @Before
    public void setUp() throws Exception {
    System.out.println("Print First");
    }

    @cucumber.api.java.After
    public void tearDown(Scenario scenario) throws InterruptedException {
        try{
        if (scenario.isFailed()) {
            System.out.println("Taking Screenshot");
            final byte[] screenshot = ((TakesScreenshot)driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }}
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            Thread.sleep(10000);
            System.out.println("Closing Browser");
            driver.close();
        }

    }

}