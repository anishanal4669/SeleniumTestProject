package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scriptUtil.BasePage;

import java.util.ArrayList;
import java.util.List;

public class Products extends BasePage{

    public void clickonButton(String labelName){
        String WebElementXpath =String.format("//p[text()='" + labelName + "']");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        if(find(WebElementXpath).isDisplayed()){
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(WebElementXpath)));
            find(WebElementXpath).click();
        }
    }

    public void validateTableData(){
        ArrayList<String> AList = new ArrayList<String>();

        WebElement tableElement = find("//div[@class='tabledata']");
        List<WebElement> list = tableElement.findElements(By.tagName("tr"));

        for(WebElement li:list){
            List<WebElement> CellList = li.findElements(By.tagName("th"));
            for(WebElement cell:CellList){
                System.out.println(cell.getText().toString());
                AList.add(cell.getText().toString());
            }

        }
    }




}
























