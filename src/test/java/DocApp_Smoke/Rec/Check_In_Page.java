package DocApp_Smoke.Rec;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Check_In_Page extends TestBase {
    @Test
    public void Check_In()throws InterruptedException {
        Assistant_Login();

//Go to Check-In page
        driver.findElement(By.cssSelector("md-toolbar > a > md-icon[aria-label*=address-card]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("md-toolbar > md-menu-bar > md-menu:nth-child(1) > button")));
        driver.findElement(By.cssSelector("md-toolbar > md-menu-bar > md-menu:nth-child(1) > button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href*=checkin]")));
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("a[href*=checkin]")).click();

        TimeUnit.SECONDS.sleep(3);
//        driver.findElement(By.cssSelector("body > div.wrapper > div.content-wrapper > section > div > md-toolbar > div > button > i")).click();
//        driver.findElement(By.cssSelector("[id*=month-2019-0-21]")).click();

//Check that all columns are exist
        TimeUnit.SECONDS.sleep(3);
        List expected_tab_names = Arrays.asList("", "Start time", "Code", "Name", "DOB", "Doctor", "Current Checkin Status", "Change Status", "");
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

//Set Checkin status

//        driver.findElement(By.cssSelector("td select:not([disabled])")).sendKeys(Keys.DOWN);
//        driver.findElement(By.cssSelector("td select:not([disabled])")).sendKeys(Keys.ENTER);
//        if(isElementPresent(By.cssSelector("md-dialog div.layout-align-center-center > input[ng-model=\"initials\"]"))){
//            driver.findElement(By.cssSelector("md-dialog div.layout-align-center-center > input[ng-model=\"initials\"]")).sendKeys("AutoTest");
//            driver.findElement(By.cssSelector("md-dialog-actions > button.md-ink-ripple[ng-click=\"apply(initials)\"]")).click();
//        }
//        TimeUnit.SECONDS.sleep(3);
//        if (isElementPresent(By.cssSelector("td select:not([disabled])")) && isElementPresent(By.cssSelector("td > div > button[aria-hidden=true]"))){
//            List<WebElement> expected_patient_info = driver.findElements(By.cssSelector("td"));
//            ArrayList<String> act_patient_info = new ArrayList();
//            for (int i = 0; i < expected_patient_info.size(); i++)
//            {
//                String each_tab = expected_patient_info.get(i).getText();
//                act_patient_info.add(each_tab);
//            }
//            System.out.println(act_patient_info);
////            System.out.println(expected_tab_names);
////            Assert.assertEquals(act_tab_names, expected_tab_names);
//        }
//
////Check that checkin status is set
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.cssSelector("a[ng-href*=rooms]")).click();

        List<WebElement> expected_patient_info_01 = driver.findElements(By.cssSelector("table.table th"));
        ArrayList<String> act_patient_info_01 = new ArrayList();
        for (int t = 0; t < expected_patient_info_01.size(); t++)
        {
            String each_line = expected_patient_info_01.get(t).getText();
            act_patient_info_01.add(each_line);
        }
        System.out.println(act_patient_info_01);
//            System.out.println(expected_tab_names);
//            Assert.assertEquals(act_tab_names, expected_tab_names);

//        driver.findElement(By.cssSelector("img.user-image")).click();
//        driver.findElement(By.cssSelector("a[ng-if*=assistant]")).click();
//        driver.findElement(By.cssSelector("button[ng-click*=show_checkin_for_assistant]")).click();

    }
}
