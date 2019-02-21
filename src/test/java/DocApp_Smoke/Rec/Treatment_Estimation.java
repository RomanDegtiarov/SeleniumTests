package DocApp_Smoke.Rec;

import jdk.jfr.Timespan;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Treatment_Estimation extends TestBase {
    @Test
    public void Treat_Estimate() throws InterruptedException{
        Doctor_Login();
//Go to Daily Appointments page
        driver.findElement(By.cssSelector(".md-menu-toolbar > a > span")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
//                ("md-menu > button.menu-dropdown > md-icon[md-font-icon*='fa-users']")));
        WebElement checkout = TestBase.getcheckout();
        checkout.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("#menu_container_1 > md-menu-content > md-menu-item:nth-child(1)")));
        driver.findElement(By.cssSelector("#menu_container_1 > md-menu-content > md-menu-item:nth-child(1)")).click();

//Open Treatment Estimation of Patient
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("md-content._md")));
        driver.findElement(By.cssSelector("tbody > tr.ng-scope:nth-child(2) > td > button > i.fa-calculator")).click();
        driver.findElement(By.cssSelector("button.btn-default[ng-click*='goto_estimate']")).click();

//"Insurance information not found" pop-up
        if (isElementPresent(By.cssSelector("div.modal-dialog"))){
         driver.findElement(By.cssSelector("div.modal-footer > button[ng-click=\"apply_initial_iv()\"]")).click();
        }

//Doctor's sign pop-up
        var testinput = "md-dialog > md-dialog-content input";
        while (isElementPresent(By.cssSelector(testinput))){
            driver.findElement(By.cssSelector("md-dialog > md-dialog-content input")).sendKeys("AUTOTEST");
            driver.findElement(By.cssSelector("md-dialog-actions > button[ng-click=\"apply(initials)\"]")).click();
            TimeUnit.SECONDS.sleep(1);
        }

//Prepare Treatment Plan for sign
        driver.findElement(By.cssSelector("md-checkbox[aria-label=\"General anesthesia\"]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("input.ng-not-empty[ng-blur*=\"Anesthesia units\"]")));
        driver.findElement(By.cssSelector("md-checkbox[aria-label=\"Xnav\"]")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("md-checkbox[aria-checked=\"true\"][aria-label=\"scan3d\"]")));
        driver.findElement(By.cssSelector("md-radio-group > md-radio-button:nth-child(1)")).click();
        driver.findElement(By.cssSelector("button > i.fa-calculator")).click();

//Add TX Option
        WebElement plus_button = driver.findElement(By.cssSelector("li > button[location-list='treatment_lst'] > i"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", plus_button);
        driver.findElement(By.cssSelector("md-dialog-content > div:nth-child(1) > div:nth-child(2)")).click();
        driver.findElement(By.cssSelector("md-dialog-actions > button[ng-click*=\"content.apply\"]")).click();
        Assert.assertTrue(isElementPresent((By.linkText("Anesthesia")))&&(isElementPresent(By.linkText("Extraction")))&&
                (isElementPresent(By.linkText("xNav Workup"))));
        driver.findElement(By.linkText("Extraction")).click();

//Add D-code
//        driver.findElement(By.cssSelector("input[ng-model='ex.code']")).click();
        driver.findElement(By.cssSelector("div.tab-pane.active input[ng-model='ex.code']")).click();
        driver.findElement(By.cssSelector("div.tab-pane.active input[ng-model='ex.code']")).sendKeys("D7210");
        driver.findElement(By.cssSelector("div.tab-pane.active div.block-inline > button[ng-disabled='ex.no_teeth']")).click();

        WebElement teeth = driver.findElement(By.cssSelector("button[ng-click='select_withdom()']"));
        JavascriptExecutor executor_01 = (JavascriptExecutor)driver;
        executor_01.executeScript("arguments[0].click();", teeth);
        WebElement teeth_subm = driver.findElement(By.cssSelector("md-dialog-actions > button[ng-click='submit()']"));
        JavascriptExecutor executor_02 = (JavascriptExecutor)driver;
        executor_02.executeScript("arguments[0].click();", teeth_subm);

//Add prices to xNav
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("button[ng-click=\"select_withdom()\"]")));
        driver.findElement(By.linkText("xNav Workup")).click();
        driver.findElement(By.cssSelector("div.tab-pane.ng-scope.active > div.list-group.ng-scope > div:nth-child(1) > div:nth-child(3) > button")).click();
        WebElement input_field_01 = driver.findElement(By.cssSelector("div.tab-pane.ng-scope.active > div.list-group.ng-scope > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div > input"));
        input_field_01.sendKeys("10");

        driver.findElement(By.cssSelector("div.tab-pane.ng-scope.active > div.list-group.ng-scope > div:nth-child(2) > div:nth-child(3) > button")).click();
        WebElement input_field_02 = driver.findElement(By.cssSelector("div.list-group.ng-scope > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div > input"));
        input_field_02.sendKeys("10");
        driver.findElement(By.cssSelector("button.btn-info[ng-click*=\"toggle_tr_edit\"]")).click();

//Finalize Estimation
        driver.findElement(By.cssSelector("div.layout-row > div > div:nth-child(4) > div > div > div > input")).sendKeys("AutoTest");
        driver.findElement(By.cssSelector("input[placeholder='Date']")).sendKeys("02/19/2019");
        driver.findElement(By.cssSelector("input[placeholder='Time']")).click();
        WebElement finalize = driver.findElement(By.cssSelector("input[value='Finalize']"));
        finalize.sendKeys(Keys.ENTER);
        WebElement mySelectElement  = driver.findElement(By.cssSelector("select[ng-model*=office_name]"));
        Select dropdown= new Select(mySelectElement);
        dropdown.selectByVisibleText("Hunt Valley Med Center");

//Add Sign code to string
        String sign_code;
        WebElement sign_element = driver.findElement(By.cssSelector("strong > i"));
        sign_code = sign_element.getText();
        System.out.println(sign_code);
        driver.findElement(By.cssSelector("button[ng-click*=back_to_needest]")).click();

//Navigate to checkout
        checkout.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("#menu_container_1 > md-menu-content > md-menu-item:nth-child(3)")));
        driver.findElement(By.cssSelector("#menu_container_1 > md-menu-content > md-menu-item:nth-child(3)")).click();
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        driver.findElement(By.cssSelector("input")).sendKeys(sign_code);
        driver.findElement(By.cssSelector("button[ng-click*='goto_patient_sign']")).click();

// Zoom out and take a screenshot
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='75%'");

        TimeUnit.SECONDS.sleep(3);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Roma&Nastya\\Desktop\\Upwork\\Screenshots\\Selenium\\screenshot" +" - Treatment_Estimate"+ System.currentTimeMillis() +".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}