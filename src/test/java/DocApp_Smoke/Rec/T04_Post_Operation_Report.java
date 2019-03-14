package DocApp_Smoke.Rec;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class T04_Post_Operation_Report extends TestBase {
    @Test
    public void Post_Rec() throws InterruptedException {
        Doctor_Login();
//Click on button "Rec.Room" in header
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-menu-bar/a[contains(@href,'recovery_rooms')]")));
        driver.findElement(By.xpath("//md-menu-bar/a[contains(@href,'recovery_rooms')]")).click();

// Click on some rec.room with patient
        TimeUnit.SECONDS.sleep(3);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]")));
        driver.findElement(By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]")).click();

// Open Post Operation Report
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-content > div.modal-footer > a[ng-href*=\"/reports/#/rr_report\"]")));
        driver.findElement(By.cssSelector("div.modal-content > div.modal-footer > a[ng-href*=\"/reports/#/rr_report\"]")).click();

// Zoom out and take a screenshot
        Locator.Active_Tab_Switch();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-xs-6 > div[ng-style*=image]")));

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(Screen_Path +" - Post_Operation_Report"+ System.currentTimeMillis() +".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}