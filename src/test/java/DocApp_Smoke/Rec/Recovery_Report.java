package DocApp_Smoke.Rec;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Recovery_Report extends TestBase {
    @Test
    public void Recovery_Rep() throws InterruptedException {
        Doctor_Login();
//Navigate to recovery room and Switch to Assistant
        Locator.recovery_rooms();
        Locator.switch_user();

//Open rec.room
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[md-colors*=room_occupied]")));
        WebElement patient_name = driver.findElement(By.cssSelector("a[md-colors*=room_occupied] > h3"));
        String name = patient_name.getText();
        System.out.println(name);
        driver.findElement(By.cssSelector("a[md-colors*=room_occupied]")).click();
        if(isElementPresent(By.cssSelector("md-dialog[aria-label='Room is busy']"))){
            Locator.taking_over();
        }

//Pass Aldrete Score System
        List<WebElement> button_list = driver.findElements(By.cssSelector("div.form-group > div.radio > label"));
        for(int i = 0; i < button_list.size(); i += 3){
        button_list.get(i).click();
        }
        driver.findElement(By.cssSelector("button[ng-click*='calculate_aldrete_score']")).click();

//Navigate to Rooms and switch to Doctor
        Locator.rooms();
        Locator.switch_user();

//Submit report
        driver.findElement(By.cssSelector("li.notifications-menu")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[ng-click='page_options.get_aldrete_info(i)']")));
        List <WebElement> patient_in_list =  driver.findElements(By.cssSelector("a[ng-click='page_options.get_aldrete_info(i)'] > span"));
        for(WebElement a : patient_in_list){
            for (int i=0; i<name.length();i++){
                if(a.getText().startsWith(name)){
                    a.click();
                }
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-footer")));
        driver.findElement(By.cssSelector("button.btn-success[ng-click*=discharge_recovery_patient]")).click();

//Check that report submitted and displayed in patient card
        TimeUnit.SECONDS.sleep(3);
        Locator.patients();
        driver.findElement(By.name("title")).sendKeys(name);
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("div[ng-show*='patients_result'] > table > tbody > tr:last-child")).click();
        driver.findElement(By.cssSelector("li[heading='Reports']")).click();
        driver.findElement(By.cssSelector("a[href*='/reports/#/rr_report']")).click();
        Locator.Active_Tab_Switch();

//Check report values
        driver.get("http://docdev.dentalelink.com/reports/#/rr_report/5c790a3bcb58df0024df672e");
        List exp_opt = Arrays.asList("ActivityCanmovevoluntaryoroncommand:4extremities", "Respiration:Candeep-breatheandcoughfreely",
                "CirculationPreoperativeBPmmHg:BP-20mmHgofbaseline", "Consciousness:FullyAwake", "Color:Normal");
        List<WebElement> options_list = driver.findElements(By.cssSelector("div.form-group"));
        List<WebElement> values_list = driver.findElements(By.cssSelector("div.form-group span.ng-scope"));
        ArrayList<String> act_opt = new ArrayList();
            for (int i=0; i<options_list.size(); i++){
                String each_opt = options_list.get(i).getText().replaceAll("\\s+","");
                act_opt.add(each_opt);
            }
            assertThat(exp_opt).isEqualTo(act_opt);
// Zoom out and take a screenshot
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-xs-6 > div[ng-style*=image]")));
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(Screen_Path +" - Post_operation_recovery_Report"+ System.currentTimeMillis() +".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}