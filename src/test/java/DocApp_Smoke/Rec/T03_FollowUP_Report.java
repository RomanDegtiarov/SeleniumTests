package DocApp_Smoke.Rec;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;

public class T03_FollowUP_Report extends TestBase{
    @Test
    public void Follow_Report() {
        Doctor_Login();
//Select occupied room
        driver.findElement(By.xpath("//md-content/div/div/a[contains(@class,'ng-scope')]")).click();

//Navigate to Follow Up page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("md-menu-bar > a.md-ink-ripple[ng-href*='/#/fu_surgical']")));
        driver.findElement(By.cssSelector("md-menu-bar > a.md-ink-ripple[ng-href*='/#/fu_surgical']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > ul > li[heading=Disposition]")));
        driver.findElement(By.cssSelector("div > ul > li[heading=Disposition]")).click();

//Open Follow Up report
        WebElement Follow_report = driver.findElement(By.cssSelector("div.col-xs-12 > button[ng-click*='/reports/#/fu_report/']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", Follow_report);

// Zoom out and take a screenshot
        Locator.Active_Tab_Switch();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='70%'");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-xs-6 > div[ng-style*=image]")));
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Roma&Nastya\\Desktop\\Upwork\\Screenshots\\Selenium\\screenshot" +" - FollowUp_Report"+ System.currentTimeMillis() +".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}