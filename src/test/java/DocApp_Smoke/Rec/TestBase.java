package DocApp_Smoke.Rec;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
public class TestBase {
//    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void Doctor_Login() {

//Login as Doctor
        driver.get("http://docnew.dentalelink.com");
        driver.findElement(By.name("username")).sendKeys("demo");
        driver.findElement(By.name("password")).sendKeys("docapptest");
        driver.findElement(By.cssSelector("button.btn-default[ng-click*=room]")).click();
        driver.findElement(By.cssSelector("button[ng-click*=login]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//md-dialog-content[@id='dialogContent_10']/div/button")));
        driver.findElement(By.xpath("//md-dialog-content[@id='dialogContent_10']/div/button")).click();
        // FIXME: change dialog id
        driver.findElement(By.xpath("//md-dialog[@aria-describedby='dialogContent_10']/md-dialog-actions/button")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("md-content._md > div")));
    }
    public void Assistant_Login(){

//Login as Assistant
        driver.get("http://docnew.dentalelink.com");
        driver.findElement(By.name("username")).sendKeys("assistant");
        driver.findElement(By.name("password")).sendKeys("docapptest");
        driver.findElement(By.cssSelector("button.btn-default[ng-click*=room]")).click();
        driver.findElement(By.cssSelector("button[ng-click*=login]")).click();
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
    public void start() {
//        if (tlDriver.get() != null){
//            driver = tlDriver.get();
//            wait = new WebDriverWait(driver,10);
//            return;
//        }
        driver = new ChromeDriver();
//        tlDriver.set(driver);
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//       Runtime.getRuntime().addShutdownHook(
//           new Thread(() -> {driver.quit(); driver = null;}));
    }
//    @After
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }
}

