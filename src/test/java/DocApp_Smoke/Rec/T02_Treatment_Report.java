package DocApp_Smoke.Rec;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
public class T02_Treatment_Report extends TestBase {
    @Test
    public void Treat_Report() {
        Doctor_Login();
//Select occupied room
        driver.findElement(By.xpath("//md-content/div/div/a[contains(@class,'ng-scope')]")).click();

//Navigate to Op.Notes page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("md-menu-bar > a.md-ink-ripple > md-icon.fa-heartbeat")));
        driver.findElement(By.cssSelector("md-menu-bar > a.md-ink-ripple > md-icon.fa-heartbeat")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > ul > li[index*=discharge]")));
        driver.findElement(By.cssSelector("div > ul > li[index*=discharge]")).click();

//Open Treatment Report
        WebElement Treatm_report = driver.findElement(By.cssSelector("div.col-xs-12 > button[ng-click*='/reports/#/tr_report/']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Treatm_report);

// Zoom out and take a screenshot
        Locator.Active_Tab_Switch();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='70%'");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.col-xs-6 > div[ng-style*=image]")));
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(Screen_Path +" - Treatment_Report"+ System.currentTimeMillis() +".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}