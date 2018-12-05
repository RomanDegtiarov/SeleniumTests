package DocApp_Smoke.Rec;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T08_Insurance_Verification_Completion extends TestBase {

    @Test
    public void Insurance_Verification() throws InterruptedException {
        Doctor_Login();

//Open insurance verification page
        driver.findElement(By.cssSelector("md-toolbar > a > md-icon[aria-label*=address-card]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("md-menu-bar > a[ng-href=\"#/need_insverif\"] > md-icon[aria-label*='pencil']")));
        driver.findElement(By.cssSelector("md-menu-bar > a[ng-href=\"#/need_insverif\"] > md-icon[aria-label*='pencil']")).click();

//Check Insurance Verification Appointments table
        TimeUnit.SECONDS.sleep(3);
        List expected_tab_names = Arrays.asList("", "#", "Name", "DOB", "Office", "Doctor", "Insurance", "Time", "Type", "Insurance Verification Completed");
        List<WebElement> actual_tab_list = driver.findElements(By.cssSelector("md-content > table > tbody > tr > th"));
        ArrayList<String> act_tab_names = new ArrayList();
        for (int i = 0; i < actual_tab_list.size(); i++)
        {
            String each_tab = actual_tab_list.get(i).getText();
            act_tab_names.add(each_tab);
        }
        System.out.println(act_tab_names);
        System.out.println(expected_tab_names);
        Assert.assertEquals(act_tab_names, expected_tab_names);

//Set count of unverified verification forms to list
        List<WebElement> bef = driver.findElements(By.cssSelector("tbody > tr > td > a >span.bg-red"));

//Open Insurance Verification form of some patient
        driver.findElement(By.cssSelector("tbody > tr > td > a > span.bg-red")).click();
        TimeUnit.SECONDS.sleep(3);
        if(isElementPresent(By.cssSelector("div.modal-dialog"))){
            driver.findElement(By.cssSelector("div.modal-footer > button[ng-click*=\"close_prefill_modal\"]")).click();
        }
        TimeUnit.SECONDS.sleep(10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("button[ng-click*=\"toggleIsHMOInsurance\"]")));
        driver.findElement(By.cssSelector("button[ng-click*=\"toggleIsHMOInsurance\"]")).click();
//        WebElement no_dental_insurance_button = driver.findElement(By.cssSelector("body > div > div.content-wrapper > section > div.box.ng-scope > div > div:nth-child(3) > div > form > div.row.top15 > div:nth-child(2) > div > button.btn.btn-sm.btn-danger.ng-isolate-scope"));
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", no_dental_insurance_button);
//
//        driver.findElement(By.cssSelector("div.modal-dialog div.text-center > button[ng-click=\"vm.apply()\"]")).click();
//        driver.findElement(By.cssSelector("div.form-group > div > input[name=\"estFee\"]")).sendKeys("2000");

//Zoom out and take a screenshot
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='60%'");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Roma&Nastya\\Desktop\\Upwork\\Screenshots\\Selenium\\screenshot" +" - Insurance_Verification_Form"+ System.currentTimeMillis() +".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }

//Finalize verification
        js.executeScript("document.body.style.zoom='100%'");
        driver.findElement(By.cssSelector("div.pull-right > input[value=\"Finalize\"]")).click();

//Comparing quantity of unverified insurances before and after test execution
        List<WebElement> aft = driver.findElements(By.cssSelector("tbody > tr > td > a >span.bg-red"));
        int b = bef.size();
        int a = aft.size();
        if (a == b - 1){
            System.out.println("Unverified insurances before test run: " + bef.size());
            System.out.println("Unverified insurances after test run: " + aft.size());
        }
    }
}