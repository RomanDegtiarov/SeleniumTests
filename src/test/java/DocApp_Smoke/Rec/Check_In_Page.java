package DocApp_Smoke.Rec;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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
//        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.cssSelector("a[href*=checkin]")).click();

//        TimeUnit.SECONDS.sleep(3);
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
//        System.out.println(act_tab_names);
//        System.out.println(expected_tab_names);
        Assert.assertEquals(act_tab_names, expected_tab_names);

//Set Checkin status
        driver.findElement(By.cssSelector("td select:not([disabled])")).sendKeys(Keys.DOWN);
        driver.findElement(By.cssSelector("td select:not([disabled])")).sendKeys(Keys.ENTER);
        Sign_Popup();
//        if (isElementPresent(By.cssSelector("td select:not([disabled])")) && isElementPresent(By.cssSelector("td > div > button[aria-hidden=true]"))){
            List<WebElement> expected_patient_info = driver.findElements(By.cssSelector("td"));
            ArrayList<String> act_patient_info = new ArrayList();
            for (int i = 0; i < expected_patient_info.size(); i++){
                String each_tab = expected_patient_info.get(i).getText();
                act_patient_info.add(each_tab);
            }
            System.out.println(act_patient_info);
//        }

//Check that checkin status is set
//        driver.findElement(By.cssSelector("a[ng-href*=rooms]")).click();
//        driver.findElement(By.cssSelector("md-input-container > md-select[ng-model='doc_title']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("md-option[value='Dr. Glenn Nathan']")));
//        driver.findElement(By.cssSelector("md-option[value='Dr. Glenn Nathan']")).click();
//        driver.findElement(By.cssSelector("md-toolbar > div > div.block-inline > button")).click();
//
//        List<WebElement> checkin_table  = driver.findElements(By.cssSelector("div.d-modal-body table > tbody > tr:nth-child(2) > td"));
//        ArrayList<String> checkin_table_info = new ArrayList<>();
//        for (int i=0; i<checkin_table.size(); i++){
//            TimeUnit.SECONDS.sleep(1);
//            String actual_checkin_info = checkin_table.get(i).getText();
//            checkin_table_info.add(actual_checkin_info);
//        }
//        System.out.println(checkin_table_info);
//        Assert.assertEquals(act_tab_names, expected_tab_names);

//        driver.findElement(By.cssSelector("img.user-image")).click();
//        driver.findElement(By.cssSelector("a[ng-if*=assistant]")).click();
//        driver.findElement(By.cssSelector("button[ng-click*=show_checkin_for_assistant]")).click();

    }
}
