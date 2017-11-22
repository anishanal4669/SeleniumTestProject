package PageObjects;


import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        String[] expected = {};
        List<WebElement> allOptions = (List<WebElement>) find(WebElementXpath);

// make sure you found the right number of elements
        if (expected.length != allOptions.size()) {
            System.out.println("fail, wrong number of elements found");
        }
// make sure that the value of every <option> element equals the expected value
        for (int i = 0; i < expected.length; i++) {
            String optionValue = allOptions.get(i).getAttribute("value");
            if (optionValue.equals(expected[i])) {
                System.out.println("passed on: " + optionValue);
            } else {
                System.out.println("failed on: " + optionValue);
            }
        }

    }





}
