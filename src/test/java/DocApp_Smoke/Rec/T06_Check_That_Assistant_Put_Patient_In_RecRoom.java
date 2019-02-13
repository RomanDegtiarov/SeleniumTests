package DocApp_Smoke.Rec;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class T06_Check_That_Assistant_Put_Patient_In_RecRoom extends TestBase {
    @Test
    public void Put_In_RecRoom() throws InterruptedException {
        Assistant_Login();
//Click on button "Rec.Room" in header
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//md-menu-bar/a[contains(@href,'recovery_rooms')]")));
        driver.findElement(By.xpath("//md-menu-bar/a[contains(@href,'recovery_rooms')]")).click();

// Select empty room
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//md-content/div/div/a[not(contains(@class,'ng-'))]")).click();

//Put Patient in room
        driver.findElement(By.cssSelector("md-dialog > md-dialog-actions > button[ng-click=\"toggleShowAll()\"]")).click();
        driver.findElement(By.cssSelector("div > table > tbody > tr[ng-repeat] > td > button.btn.ng-scope:not([class*=ng-hide])")).click();

//Taking screenshot
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Roma&Nastya\\Desktop\\Upwork\\Screenshots\\Selenium\\screenshot" +" - Put_Patient_In_RecRoom_Report"+ System.currentTimeMillis() +".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }

// Closing rec.room
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("div > a[ng-href='/#/recovery_rooms']")).click();
    }
}
