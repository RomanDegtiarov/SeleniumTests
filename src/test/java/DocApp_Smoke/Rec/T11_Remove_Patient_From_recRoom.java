package DocApp_Smoke.Rec;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T11_Remove_Patient_From_recRoom extends TestBase {

    @Test
    public void Remove_Rec() throws InterruptedException {
        Assistant_Login();
//Click on button "Rec.Room" in header
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//md-menu-bar/a[contains(@href,'recovery_rooms')]")));
        driver.findElement(By.xpath("//md-menu-bar/a[contains(@href,'recovery_rooms')]")).click();
        TimeUnit.SECONDS.sleep(3);

// Click on some rec.room with patient
        List<WebElement> bef = driver.findElements(By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]"));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]")));

        WebElement no_dental_insurance_button = driver.findElement(By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]/h2"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", no_dental_insurance_button);

        driver.findElement(By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]/h2")).click();
        if(isElementPresent(By.cssSelector("md-dialog-actions.layout-row"))){
            driver.findElement(By.cssSelector("md-dialog-actions.layout-row > div.text-center > button[ng-click*=\"submit\"]")).click();
        }

//Remove Patient from room
        driver.findElement(By.cssSelector("#content > div > div.text-center > div > button[ng-click*='show_room_status']")).click();
//        driver.findElement(By.cssSelector("div.modal-content > div.modal-footer > button[ng-click*='update_room_state']")).click();
//        driver.findElement(By.cssSelector("div.modal-content > div.modal-footer > button[ng-click*='update_room_state']")).click();

//Comparing quantity of occupied rooms before and after test execution
//        List<WebElement> aft = driver.findElements(By.xpath("//md-content/div/div/a[contains(@md-colors,\"room_occupied\")]"));
//        int b = bef.size();
//        int a = aft.size();
//        if (a == b - 1) {
//            System.out.println("Occupied rec.rooms before test run: " + bef.size());
//            System.out.println("Occupied rec.rooms after test run: " + aft.size());
//        }
    }
}