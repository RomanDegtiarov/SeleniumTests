package DocApp_Smoke.Rec;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T12_Remove_Patient_From_Room extends TestBase {
    @Test
    public void Remove_Patient(){
        Assistant_Login();
//Select occupied room & count occupied rooms
        List<WebElement> bef = driver.findElements(By.xpath("//md-content/div/div/a[contains(@class,'ng-scope')]"));
        driver.findElement(By.xpath("//md-content/div/div/a[contains(@class,'ng-scope')]")).click();
        if (isElementPresent(By.cssSelector("md-dialog-actions.layout-row"))) {
            driver.findElement(By.cssSelector("md-dialog-actions.layout-row > div.text-center > button[ng-click*=\"submit\"]")).click();
        }

//Remove Patient from room
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#main-content")));
        driver.findElement(By.cssSelector("div.text-center.ng-scope.md-whiteframe-3dp > md-content > h3 > span.btn.btn-primary.ng-binding")).click();
        driver.findElement(By.cssSelector("#room_ready_status_button")).click();
////        if (isElementPresent(By.cssSelector("md-content._md > div button.font20.ng-scope[ng-click*=\"show_room_status\"]"))){
////                driver.findElement(By.cssSelector("md-content._md > div button.font20.ng-scope[ng-click*=\"show_room_status\"]")).click();
////                driver.findElement(By.cssSelector("div.top15 > table td > button:nth-child(12)")).click();
//
////            }
////        if (isElementPresent(By.cssSelector("div.text-center > button[ng-click*='show_room_status']"))) {
////                driver.findElement(By.cssSelector("div.text-center > button[ng-click*='show_room_status']")).click();
////            driver.findElement(By.cssSelector("div.top15 > table td > button:nth-child(12)")).click();
////            driver.findElement(By.cssSelector("div.modal-footer > button[ng-click*=\"update\"]")).click();
////            driver.findElement(By.cssSelector("div.modal-dialog div.modal-footer > button[ng-click*=\"update_room\"]")).click();
////            }
////        if (isElementPresent(By.cssSelector("#content > div > div.text-center > div > button[ng-click*='show_confirm_room_ready']"))){
////            driver.findElement(By.cssSelector("#content > div > div.text-center > div > button[ng-click*='show_confirm_room_ready']")).click();
////        }
        driver.findElement(By.cssSelector("div.modal-dialog div.modal-footer > button[ng-click*=\"update_room\"]")).click();
        driver.findElement(By.cssSelector("div.modal-footer > button[ng-click*=\"update\"]")).click();

//Comparing quantity of occupied rooms before and after test execution
        List<WebElement> aft = driver.findElements(By.xpath("//md-content/div/div/a[contains(@class,'ng-scope')]"));
        int b = bef.size();
        int a = aft.size();
        if (a == b - 1) {
            System.out.println("Occupied rooms before test run: " + bef.size());
            System.out.println("Occupied rooms after test run: " + aft.size());
        }
        else {
            throw new java.lang.Error("Something went wrong");
        }
    }
}