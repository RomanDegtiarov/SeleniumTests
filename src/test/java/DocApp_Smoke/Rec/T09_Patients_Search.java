package DocApp_Smoke.Rec;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T09_Patients_Search extends TestBase{
    @Test
    public void Patient_Search(){
        Doctor_Login();
//Open Patients page
        Locator.patients();
        driver.findElement(By.cssSelector("md-content._md > form > md-input-container > input")).sendKeys("ao*");
        driver.findElement(By.cssSelector("div[ng-show*=\"patients_result\"] > table > tbody > tr:last-child")).click();
        driver.findElement(By.cssSelector("md-content._md ul.nav-tabs[ng-class*=\"nav-stacked\"]"));

//Compare actual tab names with expected
        List<String> expected_tab_names = Arrays.asList("Date/time Doctor Office Summary Reports");
        List <WebElement> actual_tab_list = driver.findElements(By.cssSelector("div.panel-collapse > div > table > thead > tr"));
        List <WebElement> A = Collections.singletonList(actual_tab_list.get(0));
        ArrayList<String> act_tab_names = new ArrayList<>();
        for (int i = 0; i < A.size(); i++){
            String each_tab = A.get(i).getText();
            act_tab_names.add(each_tab);
 }
        Assert.assertEquals(expected_tab_names, act_tab_names);

// Zoom out and take a screenshot
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='60%'");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Roma&Nastya\\Desktop\\Upwork\\Screenshots\\Selenium\\screenshot" +" - Patients_Search_Patient_Card"+ System.currentTimeMillis() +".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}