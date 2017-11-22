package scriptUtil;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.*;


import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BasePage implements MainSchema {
    public static WebDriver driver;
    public static WebElement element;
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
    public static void handleFrame(String name){
        driver.switchTo().frame(name);
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

    }



