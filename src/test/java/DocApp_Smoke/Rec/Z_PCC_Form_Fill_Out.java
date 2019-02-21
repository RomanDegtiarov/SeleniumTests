package DocApp_Smoke.Rec;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Z_PCC_Form_Fill_Out extends TestBase {
    @Test
    public void PCC_Form() throws InterruptedException {
        //Doctor_Login();

//Go to Patient Portal
//        driver.findElement(By.cssSelector(".md-menu-toolbar > a > span")).click();
//        driver.findElement(By.cssSelector("md-menu-bar > md-menu > button > md-icon[md-font-icon*=check]")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("md-menu-content > md-menu-item > a[href=\"/new_portal\"]")));
//        driver.findElement(By.cssSelector("md-menu-content > md-menu-item > a[href=\"/new_portal\"]")).click();
//
////Invite Patient
//        String currentTab = driver.getWindowHandle();
//        for (String tab : driver.getWindowHandles()) {
//            if (!tab.equals(currentTab)){
//                driver.switchTo().window(tab);
//            }
//        }
//        TimeUnit.SECONDS.sleep(2);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("div.col-6 > button.mb-2")));
//        File scrFile_01 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(scrFile_01, new File("C:\\Users\\Roma&Nastya\\Desktop\\Upwork\\Screenshots\\Selenium\\screenshot" +" - Patient_Portal"+ System.currentTimeMillis() +".png"));
//        } catch (IOException x) {
//            x.printStackTrace();
//        }
//        driver.findElement(By.cssSelector("div.col-6 > button.mb-2")).click();
//        driver.findElement(By.cssSelector("input#lastNameEdit")).sendKeys("Green");
//        driver.findElement(By.cssSelector("input#firstNameEdit")).sendKeys("John");
//        TimeUnit.SECONDS.sleep(3);
//        driver.findElement(By.cssSelector(".modal-footer > div > div > button.btn-primary")).click();
//        driver.findElement(By.cssSelector("input#dueDateId")).sendKeys("01/01/2030");
//        driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(1) > input")).sendKeys("4436728871");
//        TimeUnit.SECONDS.sleep(2);
//        driver.findElement(By.cssSelector("div > button.btn.btn-primary.ml-2 > span:nth-child(1)")).click();
//        TimeUnit.SECONDS.sleep(2);
//
////Navigate to PatientCompleteCare
//        driver.findElement(By.cssSelector("div.col-6 tbody.valign-middle > tr:nth-child(1) > td > a")).click();
//        TimeUnit.SECONDS.sleep(5);
//        File scrFile_02 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(scrFile_02, new File("C:\\Users\\Roma&Nastya\\Desktop\\Upwork\\Screenshots\\Selenium\\screenshot" +" - Invite_Patient_From_WinOMS"+ System.currentTimeMillis() +".png"));
//        } catch (IOException x) {
//            x.printStackTrace();
//        }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("div.col-md-6 > div > button.btn-default")));
//        driver.findElement(By.cssSelector("div.col-md-6 > div > button.btn-default")).click();
//        TimeUnit.SECONDS.sleep(2);
//
//        WebElement access_code = driver.findElement(By.cssSelector("div.text-center code"));
//        access_code.getText();
//        driver.get("http://app1717.pcare.us/4C");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("input#login-code")));
//        WebElement input = driver.findElement(By.cssSelector("input#login-code"));
//        input.sendKeys("access_code");
//
//        TimeUnit.SECONDS.sleep(5);
//        driver.findElement(By.cssSelector("button[ng-click*=login_by_code]")).click();


    }
}
