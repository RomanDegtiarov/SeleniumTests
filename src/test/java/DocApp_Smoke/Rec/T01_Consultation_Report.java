package DocApp_Smoke.Rec;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.io.IOException;

public class T01_Consultation_Report extends TestBase {
    @Test
    public void Cons_Report(){
        Doctor_Login();
//Select occupied room
        driver.findElement(By.xpath("//md-content/div/div/a[contains(@class,'ng-scope')]")).click();
        Sign_Popup();

//Navigate to PE: Specific Site
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("md-menu-bar > md-menu > button > md-icon[md-font-icon*=\"stethoscope\"]")));
        WebElement consult = driver.findElement(By.cssSelector("md-menu-bar > md-menu > button > md-icon[md-font-icon*=\"stethoscope\"]"));
        JavascriptExecutor executor_01 = (JavascriptExecutor)driver;
        executor_01.executeScript("arguments[0].click();", consult);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("md-menu-content > md-menu-item:nth-child(3)")));
        driver.findElement(By.cssSelector("md-menu-content > md-menu-item:nth-child(3)")).click();
        WebElement summary = driver.findElement(By.cssSelector("div > ul > li[select*=\"validate_before_summary\"]"));
        JavascriptExecutor executor_02 = (JavascriptExecutor)driver;
        executor_02.executeScript("arguments[0].click();", summary);
        driver.findElement(By.cssSelector("div.md-whiteframe-4dp"));

//Open Consultation Report
        WebElement Consult_report = driver.findElement(By.cssSelector("div.col-xs-12 > button.btn.btn-success.text-uppercase[ng-click*='cn_report']"));
        JavascriptExecutor executor_03 = (JavascriptExecutor)driver;
        executor_03.executeScript("arguments[0].click();", Consult_report);

// Zoom out and take a screenshot
        Locator.Active_Tab_Switch();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-xs-6 > div[ng-style*=image]")));
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(Screen_Path +" - Consultation_Report"+ System.currentTimeMillis() +".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}
