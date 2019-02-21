package DocApp_Smoke.Rec;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class T08_Insurance_Verification_Completion extends TestBase {
    @Test
    public void Insurance_Verification() throws InterruptedException {
        Doctor_Login();

//Open insurance verification page
        driver.findElement(By.cssSelector("md-toolbar > a > md-icon[aria-label*=address-card]")).click();
        driver.findElement(By.cssSelector("md-checkbox[ng-model=show_all]")).click();

//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector("md-menu-bar > a[ng-href=\"#/need_insverif\"] > md-icon[aria-label*='pencil']")));
//        driver.findElement(By.cssSelector("md-menu-bar > a[ng-href=\"#/need_insverif\"] > md-icon[aria-label*='pencil']")).click();

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
        if(isElementPresent(By.cssSelector("div.modal[style*=display] div.modal-dialog button[ng-click*=close_prefill_modal]"))){
            driver.findElement(By.cssSelector("div.modal-footer > button[ng-click*=\"close_prefill_modal\"]")).click();
        }

//Define and Fill out required info
        WebElement spoke_with = driver.findElement(By.cssSelector("input[ng-model*=spoke_with].form-control.ng-invalid"));
        WebElement ins_name = driver.findElement(By.cssSelector("input#ins_name"));
        WebElement ssn = driver.findElement(By.cssSelector("input#ssn"));
        WebElement radio_self = driver.findElement(By.cssSelector("input[value=self]"));
        WebElement mailing_address = driver.findElement(By.cssSelector("input#claims_mailing"));
        WebElement deductible = driver.findElement(By.name("deductible"));
        WebElement amount_met = driver.findElement(By.name("amount_met"));
        WebElement maximum = driver.findElement(By.name("maximum"));
        WebElement amount_used = driver.findElement(By.name("amount_used"));
        WebElement fee_schedule = driver.findElement(By.cssSelector("select#fee_schedule"));
        WebElement insurance_option = driver.findElement(By.cssSelector("option[label=Aetna]"));
        WebElement D0330_choice = driver.findElement(By.name("D0330_choice"));
        WebElement D0330_percent = driver.findElement(By.name("D0330_percent"));
        WebElement D0330_freq = driver.findElement(By.cssSelector("div:nth-child(8) > input[ng-model*=freq]"));
        WebElement est_fee = driver.findElement(By.cssSelector("div:nth-child(14) > div > div > div > div > div:nth-child(1) > div:nth-child(13) > input[ng-model*=est_fee]"));
        WebElement max_d0330 = driver.findElement(By.cssSelector("label:nth-child(4) > input[name=max_d0330]"));
        WebElement ded_d0330 = driver.findElement(By.cssSelector("label:nth-child(3) > input[name=ded_d0330]"));
        WebElement d0367_no_charge = driver.findElement(By.cssSelector("input[ng-change*=check_d0367_no_charge]"));
        WebElement d09310_no_charge = driver.findElement(By.cssSelector("input[ng-change*=check_d9310_no_charge]"));
        WebElement all_oral_surgery = driver.findElement(By.cssSelector("input[ng-change*=validate_all_oral_surgery][value=Yes]"));
        WebElement impactions_only = driver.findElement(By.cssSelector("input[ng-change*=validate_impactions][value=No]"));
        WebElement coordination_benefits = driver.findElement(By.cssSelector("input[ng-model*=standard_coordination][value=No]"));
        WebElement final_est_fee = driver.findElement(By.name("estFee"));

        spoke_with.sendKeys("AutoTest");
        ins_name.sendKeys("AutoTest");
        ssn.sendKeys("AutoTest");
        radio_self.click();
        mailing_address.sendKeys("AutoTest@");
        deductible.sendKeys("5000");
        amount_met.sendKeys("3000");
        maximum.sendKeys("3000");
        amount_used.sendKeys("2000");
        fee_schedule.click();
        insurance_option.click();
        D0330_choice.click();
        D0330_percent.sendKeys("25");
        D0330_freq.sendKeys("3");
        est_fee.sendKeys("85");
        max_d0330.click();
        ded_d0330.click();
        d0367_no_charge.click();
        d09310_no_charge.click();
        all_oral_surgery.click();
        impactions_only.click();
        coordination_benefits.click();
        final_est_fee.sendKeys("3000");

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