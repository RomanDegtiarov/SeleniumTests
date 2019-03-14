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
        Locator.front();
        driver.findElement(By.cssSelector("md-checkbox[ng-model=show_all]")).click();

//Check Insurance Verification Appointments table
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(("md-content > table > tbody > tr > th"))));
        List expected_tab_names = Arrays.asList("", "#", "Name", "DOB", "Office", "Doctor", "Insurance", "Time", "Type", "Insurance Verification Completed");
        List<WebElement> actual_tab_list = driver.findElements(By.cssSelector("md-content > table > tbody > tr > th"));
        ArrayList<String> act_tab_names = new ArrayList();
        for (int i = 0; i < actual_tab_list.size(); i++) {
            String each_tab = actual_tab_list.get(i).getText();
            act_tab_names.add(each_tab);
        }
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
        Locator.ins_opt_fillout();

//Zoom out and take a screenshot
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='60%'");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(Screen_Path +" - Insurance_Verification_Form"+ System.currentTimeMillis() +".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }

//Finalize verification
        js.executeScript("document.body.style.zoom='100%'");
        driver.findElement(By.cssSelector("div.pull-right > input[value=\"Finalize\"]")).click();

//Comparing quantity of unverified insurances before and after test execution
        List<WebElement> aft = driver.findElements(By.cssSelector("tbody > tr > td > a >span.bg-red"));
        if (aft.size() == bef.size() - 1){
            System.out.println("Unverified insurances before test run: " + bef.size());
            System.out.println("Unverified insurances after test run: " + aft.size());
        }
    }
}