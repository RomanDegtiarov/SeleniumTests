package DocApp_Smoke.Rec;

import jdk.jfr.Timespan;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Treatment_Estimation extends TestBase {
    @Test
    public void Treat_Estimate() throws InterruptedException{
        Doctor_Login();
//Go to Daily Appointments page
        driver.findElement(By.cssSelector(".md-menu-toolbar > a > span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("md-menu > button.menu-dropdown > md-icon[md-font-icon*='fa-users']")));
        driver.findElement(By.cssSelector("md-menu > button.menu-dropdown > md-icon[md-font-icon*='fa-users']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
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
        WebElement plus_button = driver.findElement(By.cssSelector("ul > li.pull-right.ng-scope > a > i"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", plus_button);
        driver.findElement(By.cssSelector("md-dialog-content > div:nth-child(1) > div:nth-child(2)")).click();
        driver.findElement(By.cssSelector("md-dialog-actions > button[ng-click*=\"content.apply\"]")).click();
        Assert.assertTrue(isElementPresent((By.linkText("Anesthesia")))&&(isElementPresent(By.linkText("Extraction")))&&
                (isElementPresent(By.linkText("xNav Workup"))));
        driver.findElement(By.linkText("Extraction")).click();

//Add D-code
        driver.findElement(By.cssSelector("div.tab-content tr[ng-repeat*=\"extractions\"] > td > input.ng-empty")).click();
        driver.findElement(By.cssSelector("div.tab-content tr[ng-repeat*=\"extractions\"] > td > input.ng-empty")).sendKeys("D7210");
        driver.findElement(By.cssSelector("div.slide:not(.ng-hide)[ng-hide='ex.no_teeth']")).click();

        WebElement teeth = driver.findElement(By.cssSelector("button[ng-click=\"select_withdom()\"]"));
        JavascriptExecutor executor_01 = (JavascriptExecutor)driver;
        executor_01.executeScript("arguments[0].click();", teeth);
        WebElement teeth_subm = driver.findElement(By.cssSelector("md-dialog-actions > button[ng-click=\"submit()\"]"));
        JavascriptExecutor executor_02 = (JavascriptExecutor)driver;
        executor_02.executeScript("arguments[0].click();", teeth_subm);

//Add prices to xNav
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("button[ng-click=\"select_withdom()\"]")));
        driver.findElement(By.linkText("xNav Workup")).click();
        driver.findElement(By.cssSelector("div.box.ng-scope > div:nth-child(2) div.tab-pane.ng-scope.active > table > tbody > tr:nth-child(2) > td:nth-child(8) > button")).click();
        WebElement input_field_01 = driver.findElement(By.cssSelector("div.tab-pane.ng-scope.active > table > tbody > tr:nth-child(2) > td:nth-child(3) > div > input"));
        input_field_01.sendKeys("10");

        driver.findElement(By.cssSelector("div.tab-pane.ng-scope.active > table > tbody > tr:nth-child(3) > td:nth-child(8) > button")).click();
        WebElement input_field_02 = driver.findElement(By.cssSelector("div.tab-pane.ng-scope.active > table > tbody > tr:nth-child(3) > td:nth-child(3) > div > input"));
        input_field_02.sendKeys("10");
        driver.findElement(By.cssSelector("button.btn-info[ng-click*=\"toggle_tr_edit\"]")).click();

//Finalize Estimation
        driver.findElement(By.cssSelector("div.layout-row > div > div:nth-child(4) > div > div > div > input")).sendKeys("AutoTest");
        driver.findElement(By.cssSelector("")).click();
    }
}