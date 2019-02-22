package DocApp_Smoke.Rec;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class TestBase {
//    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static WebElement checkout;

//Common locators and methods
    String DocApp =("http://docdev.dentalelink.com");
    public void Sign_Popup(){
        var testinput = "md-dialog > md-dialog-content input";
        while (isElementPresent(By.cssSelector(testinput))){
            driver.findElement(By.cssSelector("md-dialog > md-dialog-content input")).sendKeys("AUTOTEST");
            driver.findElement(By.cssSelector("md-dialog-actions > button[ng-click=\"apply(initials)\"]")).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("md-dialog-actions > button[ng-click=\"apply(initials)\"]")));
        }
    }
    static WebElement getcheckout(){
        checkout = driver.findElement(By.cssSelector("md-menu > button.menu-dropdown > md-icon[md-font-icon*='fa-users']"));
        return checkout;
    }
    public void Doctor_Login() {

//Login as Doctor
        driver.get(DocApp);
        driver.findElement(By.name("username")).sendKeys("demo");
        driver.findElement(By.name("password")).sendKeys("docapptest");
        driver.findElement(By.cssSelector("#form-signin > p:nth-child(5) > button")).click();
        driver.findElement(By.cssSelector("#form-signin > button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//md-dialog-content[@id='dialogContent_10']/div/button")));
        driver.findElement(By.xpath("//md-dialog-content[@id='dialogContent_10']/div/button")).click();
        // FIXME: change dialog id
        driver.findElement(By.xpath("//md-dialog[@aria-describedby='dialogContent_10']/md-dialog-actions/button")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("md-content._md > div")));
    }
    public void Assistant_Login(){

//Login as Assistant
        driver.get(DocApp);
        driver.findElement(By.name("username")).sendKeys("assistant");
        driver.findElement(By.name("password")).sendKeys("docapptest");
        driver.findElement(By.cssSelector("#form-signin > p:nth-child(5) > button")).click();
        driver.findElement(By.cssSelector("#form-signin > button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//md-dialog-content[@id='dialogContent_10']/div/button")));
        driver.findElement(By.xpath("//md-dialog-content[@id='dialogContent_10']/div/button")).click();
        // FIXME: change dialog id
        driver.findElement(By.xpath("//md-dialog[@aria-describedby='dialogContent_10']/md-dialog-actions/button")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("md-content._md > div")));
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (InvalidSelectorException ex) {
            throw ex;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @Before
        public void start() throws MalformedURLException {
//        DesiredCapabilities capability = new DesiredCapabilities();
//        capability.setBrowserName("chrome");
//        capability.setPlatform(Platform.WINDOWS);
//        driver = new RemoteWebDriver(new URL("http://192.168.0.104:4444/wd/hub"),capability);
//
//        URL server = new URL("http://192.168.0.104:4444/wd/hub");
//        System.out.println("Connecting to " + server);
//        WebDriver driver = new RemoteWebDriver(server, capability);

//        if (tlDriver.get() != null){
////            driver = tlDriver.get();
////            wait = new WebDriverWait(driver,10);
////            return;
////        }
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,6);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
//        driver.manage().window().fullscreen();

//       Runtime.getRuntime().addShutdownHook(
//           new Thread(() -> {driver.quit(); driver = null;}));
    }
//    @After
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }
}

