package DocApp_Smoke.Rec;

import okhttp3.MediaType;
import okhttp3.Response;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

public class T07_Patient_Portal_AND_Patient_Invite extends TestBase{
    @Test
    public void Patient_Invite() throws InterruptedException {
//        Doctor_Login();
////Go to Patient Portal
//        Locator.front();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("md-menu-bar > md-menu > button > md-icon[md-font-icon*=check]")));
//        driver.findElement(By.cssSelector("md-menu-bar > md-menu > button > md-icon[md-font-icon*=check]")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("md-menu-content > md-menu-item > a[href='/new_portal']")));
//        driver.findElement(By.cssSelector("md-menu-content > md-menu-item > a[href='/new_portal']")).click();
//
////Invite Patient
//        Locator.Active_Tab_Switch();
//        TimeUnit.SECONDS.sleep(2);
//        JavascriptExecutor js_01 = (JavascriptExecutor) driver;
//        js_01.executeScript("document.body.style.zoom='75%'");
//        File scrFile_01 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(scrFile_01, new File("C:\\Users\\Roma&Nastya\\Desktop\\Upwork\\Screenshots\\Selenium\\screenshot" +" - Patient_Portal"+ System.currentTimeMillis() +".png"));
//        } catch (IOException x) {
//            x.printStackTrace();
//        }
//        WebElement invite_button = driver.findElement(By.cssSelector("div.col-6 > button.mb-2 > span.fa-plus"));
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("arguments[0].click();", invite_button);
//
//        JavascriptExecutor js_02 = (JavascriptExecutor) driver;
//        js_02.executeScript("document.body.style.zoom='100%'");

//Fill out patient invite info
//        driver.get("http://172.16.4.41/api/v3/login");
        try {
            URL url = new URL("http://172.16.4.41/api/v3/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            String input = "{\"username\":demo,\"pwd\":\"docapptest\"}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

//        driver.findElement(By.cssSelector("input#lastNameEdit")).sendKeys("A");
//        driver.findElement(By.cssSelector("input#firstNameEdit")).sendKeys("John");
//        driver.findElements(By.cssSelector("div.modal-content > .modal-footer > div > div > button.btn-primary")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.modal-content > .modal-footer > div > div > button.btn-primary")));
//        driver.findElement(By.cssSelector("div.modal-content > .modal-footer > div > div > button.btn-primary")).click();
//        driver.findElement(By.cssSelector("input#dueDateId")).sendKeys("01/01/2030");
//        driver.findElement(By.cssSelector("form > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(1) > input")).sendKeys("4436728871");
//        driver.findElement(By.cssSelector("textarea.form-control")).sendKeys("Patient invited by AutoTest");
//        TimeUnit.SECONDS.sleep(2);
//        driver.findElement(By.cssSelector("div > button.btn.btn-primary.ml-2 > span:nth-child(1)")).click();
//        TimeUnit.SECONDS.sleep(2);
//
////Navigate to PatientCompleteCare
//        driver.findElement(By.cssSelector("div.card-deck tbody.valign-middle > tr:nth-child(1) > td > a")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.card-header > div > i.fa-file-text")));
//        File scrFile_02 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(scrFile_02, new File(Screen_Path +" - Invite_Patient_From_WinOMS"+ System.currentTimeMillis() +".png"));
//        } catch (IOException x) {
//            x.printStackTrace();
//        }
    }
}