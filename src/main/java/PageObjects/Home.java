package PageObjects;


import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scriptUtil.*;

import java.util.List;

public class Home extends BasePage{

    public void closePop(){
        String WebElementXpath =String.format("//div[@id='cee_closeBtn']/img");
        try {
            if (find(WebElementXpath).isDisplayed()) {
                find(WebElementXpath).click();

            }
            else{
                System.out.println("Alert not present");
            }
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }

    public boolean isElementPresent(String labelName) {
        String WebElementXpath =String.format("//a[text()='" + labelName + "']");
        List<WebElement> allOptions = (List<WebElement>) find(WebElementXpath);
        String[] expected = {};
        for(WebElement actual: allOptions){
            String actualValue = actual.getAttribute("value");
            if(actualValue.equalsIgnoreCase(String.valueOf(expected))){

            }
        }

        try {
            find(WebElementXpath).isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }

    }
    public void validateLinksPresent(String labelName){
        String WebElementXpath =String.format("//a[text()='" + labelName + "']");
        if(find(WebElementXpath).isDisplayed()){
            Assert.assertTrue(find(WebElementXpath).getText().equalsIgnoreCase(labelName));
        }
        else{
            System.out.println("Element didn't matched");
        }
    }
    public void clickLink(String labelName){
        String WebElementXpath =String.format("//span[text()='" + labelName + "']");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        if(find(WebElementXpath).isDisplayed()){
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(WebElementXpath)));
            find(WebElementXpath).click();
        }
    }





}
