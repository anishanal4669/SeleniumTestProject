package scriptUtil;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;


import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BasePage implements MainSchema {
    public static WebDriver driver;
    public static WebElement element;
    JavascriptExecutor JSE = (JavascriptExecutor)driver;
    public static void launchBrowser() {
        if (Browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "D://Selenium//chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver(options);
        } else if (Browser.equalsIgnoreCase("IE")) {

            System.setProperty("webdriver.ie.driver", "D://Selenium//IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if (Browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
    }

    public void launchUrl() {
        driver.get(Url);
        driver.manage().window().maximize();
    }

    public static void clickElement(String labelName) {
        //By WebElementXpath =By.xpath("//a[contains(text(),'labelName')]");
        driver.findElement(By.xpath("//a[contains(text(),'" + labelName + "')]")).click();
    }

    public static void enterVal(String Val, String labelName) {
        By WebElementXpath = By.xpath("//input[@name='" + labelName + "']");
        driver.findElement(WebElementXpath).sendKeys(Val);

    }
    public static void handleAlert(String enterText){
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(enterText);
        alert.dismiss();
    }
    public static void handleWindows(){
        String winTitle = driver.getWindowHandle();
        Set<String> winHandle = driver.getWindowHandles();
        String title="";
        for(String Handles : winHandle){
            if (!winTitle.equalsIgnoreCase(Handles))
            {
                driver.switchTo().window(Handles);
            }
        }
    }
    public static void handleFrame(String id){
        driver.switchTo().frame(id);
    }

    public static void defaultContent(){
        driver.switchTo().defaultContent();
    }

    public static WebElement find(String Xpath){
        element = driver.findElement(By.xpath((Xpath)));
        return element;
    }
    public static void handledropDowns(String Xpath, String VisibleText){
        WebElement DDelement = find(Xpath);
        Select se = new Select(DDelement);
        se.selectByVisibleText(VisibleText);
    }
    public static void wait(int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void hoverElement(String labelName, String labelName1, String labelName2){
        Actions action = new Actions(driver);
        String WebElementXpath =String.format("//a[text()='" + labelName + "']");
        String WebElementXpath1 =String.format("//a[text()='" + labelName1 + "']");
        String WebElementXpath2 =String.format("//a[text()='" + labelName2 + "']");
        WebElement we = find(WebElementXpath);
        action.moveToElement(we).perform();
        action.moveToElement(find(WebElementXpath1)).perform();
        action.moveToElement(find(WebElementXpath2)).click().build().perform();


    }
    public void pageLoad(int time){
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    public void scrollScreen(){

        JSE.executeScript("window.scrollTo(0,300)", "");
    }
    public void scrollintoView(String labelName){
        String WebElementXpath =String.format("//a[text()='" + labelName + "']");
        WebElement element = find(WebElementXpath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }





    }



