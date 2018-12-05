package DocApp_Smoke.Rec;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;

public class T05_Check_That_Assistant_Put_Patient_In_Room extends TestBase {
    @Test
    public void Patient_In_Room_Check() {
        Assistant_Login();
// Select Doctor
        driver.findElement(By.cssSelector("div md-input-container md-select[ng-model=doc_title]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector("md-content md-option[value=\"Dr. Glenn Nathan\"]")));
        driver.findElement(By.cssSelector("md-content md-option[value=\"Dr. Glenn Nathan\"]")).click();

// Select empty room
        driver.findElement(By.xpath("//md-content/div/div/a[not(contains(@class,'ng-'))]")).click();

//Put Patient in room
        driver.findElement(By.cssSelector("div > table > tbody > tr[ng-repeat] > td > button.btn.ng-scope:not([class*=ng-hide])")).click();
        driver.findElement(By.cssSelector("div.modal-footer > button[ng-click*=confirm_patient]")).click();
        if(isElementPresent(By.cssSelector("div.modal-dialog"))){
            driver.findElement(By.cssSelector("div.modal-body div:nth-child(1) > button")).click();
            driver.findElement(By.cssSelector("div.modal-footer > button:nth-child(1)")).click();
        }
        if(isElementPresent(By.cssSelector("md-dialog div.layout-align-center-center > input[ng-model=\"initials\"]"))){
            driver.findElement(By.cssSelector("md-dialog div.layout-align-center-center > input[ng-model=\"initials\"]")).sendKeys("AutoTest");
            driver.findElement(By.cssSelector("md-dialog-actions > button.md-ink-ripple[ng-click=\"apply(initials)\"]")).click();
        }
        if(isElementPresent(By.xpath("//div[2]/div[1]/div[1]/button"))){
            driver.findElement(By.xpath("//div[2]/div[1]/div[1]/button")).click();
            driver.findElement(By.cssSelector("div.modal-footer > button[ng-click*=\"apply_procedure\"]")).click();
        }

//Taking Screenshot
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.margin-top-15.ng-scope.md-whiteframe-3dp > md-content")));
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Roma&Nastya\\Desktop\\Upwork\\Screenshots\\Selenium\\screenshot" +" - Put_Patient_In_Room"+ System.currentTimeMillis() +".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}