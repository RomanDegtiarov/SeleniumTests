package DocApp_Smoke.Rec;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T11_Remove_Patient_From_recRoom extends TestBase {

    @Test
    public void Remove_Rec(){
        Assistant_Login();
        Locator.recovery_rooms();

// Click on some rec.room with patient
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]")));
        List<WebElement> bef = driver.findElements(By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]")));

        WebElement no_dental_insurance_button = driver.findElement(By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]/h2"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", no_dental_insurance_button);

        driver.findElement(By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]/h2")).click();
        if(isElementPresent(By.cssSelector("md-dialog-actions.layout-row"))){
            driver.findElement(By.cssSelector("md-dialog-actions.layout-row > div.text-center > button[ng-click*=\"submit\"]")).click();
        }

//Remove Patient from room
        driver.findElement(By.cssSelector("div.text-center > h3 > span.btn.btn-primary.ng-binding")).click();
        driver.findElement(By.cssSelector("#room_ready_status_button")).click();
        driver.findElement(By.cssSelector("div.modal-dialog div.modal-footer > button[ng-click*=\"update_room\"]")).click();
        driver.findElement(By.cssSelector("div.modal-footer > button[ng-click*=\"update\"]")).click();

//Comparing quantity of occupied rooms before and after test execution
        List<WebElement> aft = driver.findElements(By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]"));
        if (aft.size() == bef.size() - 1) {
            System.out.println("Occupied rec.rooms before test run: " + bef.size());
            System.out.println("Occupied rec.rooms after test run: " + aft.size());
        }
        else {
            throw new java.lang.Error("Something went wrong");
        }
    }
}