package DocApp_Smoke.Rec;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T06_Check_That_Assistant_Put_Patient_In_RecRoom extends TestBase {
    @Test
    public void Put_In_RecRoom() {
        Assistant_Login();
//Click on button "Rec.Room" in header
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//md-menu-bar/a[contains(@href,'recovery_rooms')]")));
        driver.findElement(By.xpath("//md-menu-bar/a[contains(@href,'recovery_rooms')]")).click();

// Select empty room
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-content/div/div/a[not(contains(@class,'ng-'))]")));
        List<WebElement> bef = driver.findElements(By.cssSelector("a[md-colors*=room_occupied]"));
        driver.findElement(By.xpath("//md-content/div/div/a[not(contains(@class,'ng-'))]")).click();

//Put Patient in room
        driver.findElement(By.cssSelector("md-dialog > md-dialog-actions > button[ng-click=\"toggleShowAll()\"]")).click();
        driver.findElement(By.cssSelector("div > table > tbody > tr[ng-repeat] > td > button.btn.ng-scope:not([class*=ng-hide])")).click();

//Taking screenshot
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[ng-click='showPopover()']")));
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Roma&Nastya\\Desktop\\Upwork\\Screenshots\\Selenium\\screenshot" + " - Put_Patient_In_RecRoom_Report" + System.currentTimeMillis() + ".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }

// Closing rec.room
        driver.findElement(By.cssSelector("div > a[ng-href='/#/recovery_rooms']")).click();

//Comparing quantity of occupied rooms before and after test execution
        List<WebElement> aft = driver.findElements(By.cssSelector("a[md-colors*=room_occupied]"));
        int b = bef.size();
        int a = aft.size();
        if (a == b + 1) {
            System.out.println("Occupied rec.rooms before test run: " + bef.size());
            System.out.println("Occupied rec.rooms after test run: " + aft.size());
        }
        else {
            throw new java.lang.Error("Something went wrong");
        }
    }
}
