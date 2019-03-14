package DocApp_Smoke.Rec;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class T05_Check_That_Assistant_Put_Patient_In_Room extends TestBase {
    @Test
    public void Patient_In_Room_Check(){
        Assistant_Login();
// Select Doctor
//        driver.findElement(By.cssSelector("div md-input-container md-select[ng-model=doc_title]")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(
//        By.cssSelector("md-content md-option[value='Dr. Glenn Nathan']")));
//        driver.findElement(By.cssSelector("md-content md-option[value='Dr. Glenn Nathan']")).click();
//
//// Select empty room
//        driver.findElement(By.xpath("//md-content/div/div/a[not(contains(@class,'ng-'))]")).click();
//        List<WebElement> bef = driver.findElements(By.cssSelector("a[md-colors*=room_occupied]"));
//
////Put Patient in room
//        driver.findElement(By.cssSelector("div > table > tbody > tr[ng-repeat] > td > button.btn.ng-scope:not([class*=ng-hide])")).click();
//        driver.findElement(By.cssSelector("div.modal-footer > button[ng-click*=confirm_patient]")).click();
//        Sign_Popup();
//        if(isElementPresent(By.cssSelector("div.modal-dialog"))){
//            driver.findElement(By.cssSelector("div.modal-body div:nth-child(2) > button")).click();
//            driver.findElement(By.cssSelector("td > a[callback*=set_parent]")).click();
//            driver.findElement(By.cssSelector("button[ng-click*=apply]")).click();
////            driver.findElement(By.cssSelector("div.modal-footer > button:nth-child(1)")).click();
//        }
//
////        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/button")));
////        if(webElement!=null){
////            driver.findElement(By.xpath("//div[2]/div[1]/div[1]/button")).click();
////            driver.findElement(By.cssSelector("div.modal-footer > button[ng-click*=\"apply_procedure\"]")).click();
////        }
//
////Taking Screenshot
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("div.margin-top-15.ng-scope.md-whiteframe-3dp > md-content")));
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(scrFile, new File(Screen_Path +" - Put_Patient_In_Room"+ System.currentTimeMillis() +".png"));
//        } catch (IOException x) {
//            x.printStackTrace();
//        }

//Set patient status and closing room
        String room_stat = "Referral attached";
        driver.findElement(By.xpath("//md-content/div/div/a[contains(@class,'ng-scope')]")).click();
        if (isElementPresent(By.cssSelector("md-dialog-actions.layout-row"))) {
            driver.findElement(By.cssSelector("md-dialog-actions.layout-row > div.text-center > button[ng-click*=\"submit\"]")).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3 > span[ng-click*='show_room_status']")));
        driver.findElement(By.cssSelector("h3 > span[ng-click*='show_room_status']")).click();
        List<WebElement> status_options = driver.findElements(By.cssSelector("div.modal-body div > button.ng-binding.ng-scope"));
        for (WebElement option: status_options){
            if(option.getText().equals(room_stat)){
                option.click();
            }
        }
        WebElement selected_option = driver.findElement(By.cssSelector("div.modal-body div > button.ng-binding.ng-scope.btn-primary"));
        String selected_shortcut = selected_option.getText();
        driver.findElement(By.cssSelector("div.modal-dialog div.modal-footer > button[ng-click*=\"update_room\"]")).click();
        Locator.rooms();

//Comparing quantity of occupied rooms before and after test execution
//        List<WebElement> aft = driver.findElements(By.cssSelector("a[md-colors*=room_occupied]"));
//        int b = bef.size();
//        int a = aft.size();
//        if (a == b + 1) {
//            System.out.println("Occupied rooms before test run: " + bef.size());
//            System.out.println("Occupied rooms after test run: " + aft.size());
//        }
//        else {
//            throw new java.lang.Error("Something went wrong");
//        }

//Check that room status is displayed

    }
}