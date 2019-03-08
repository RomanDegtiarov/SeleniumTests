package DocApp_Smoke.Rec;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Locator extends TestBase {
    public static WebElement recovery_room;
    public static WebElement front;
    public static WebElement switch_user;
    public static WebElement taking_over;
    public static WebElement rooms;
    public static WebElement patients;
    public static WebElement checkout;
    public static WebElement ins_opt_fillout;

    @Test
    static void Active_Tab_Switch() {
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)){
                driver.switchTo().window(tab);
            }
        }
    }
    static WebElement ins_opt_fillout() {
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
        return ins_opt_fillout;
    }
    static WebElement switch_user() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.dropdown.user.user-menu")));
        driver.findElement(By.cssSelector("li.dropdown.user.user-menu")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[ng-click='switch_user()']")));
        driver.findElement(By.cssSelector("a[ng-click='switch_user()']")).click();
        return switch_user;
    }
    static WebElement rooms() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/#/rooms']")));
        driver.findElement(By.cssSelector("a[href='/#/rooms']")).click();
        return rooms;
    }
    static WebElement recovery_rooms() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-menu-bar/a[contains(@href,'recovery_rooms')]")));
        driver.findElement(By.xpath("//md-menu-bar/a[contains(@href,'recovery_rooms')]")).click();
        return recovery_room;
    }
    static WebElement front() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("md-toolbar > a > md-icon[aria-label*=address-card]")));
        driver.findElement(By.cssSelector("md-toolbar > a > md-icon[aria-label*=address-card]")).click();
        return front;
    }
    static WebElement checkout(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("md-menu > button.menu-dropdown > md-icon[md-font-icon*='fa-users']")));
        driver.findElement(By.cssSelector("md-menu > button.menu-dropdown > md-icon[md-font-icon*='fa-users']")).click();
        return checkout;
    }
    static WebElement taking_over() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("md-dialog[aria-label='Room is busy']")));
        driver.findElement(By.cssSelector("md-dialog[aria-label='Room is busy'] button[ng-click='submit()']")).click();
        return taking_over;
    }
    static WebElement patients() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/#/patients']")));
        driver.findElement(By.cssSelector("a[href='/#/patients']")).click();
        return patients;
    }

}

