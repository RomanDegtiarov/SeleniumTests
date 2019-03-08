package DocApp_Smoke.Rec;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class T10_RecRoom_Check_PatientInfo extends TestBase{
    @Test
    public void Room_Check(){
        Doctor_Login();
        Locator.recovery_rooms();

// Click on some rec.room with patient
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-content/div/div/a[contains(@class,'recovery')][contains(@md-colors,'room_occupied')]")));
        driver.findElement(By.xpath("//md-content/div/div/a[contains(@md-colors,'room_occupied')]")).click();

//Taking Screenshot
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
        FileUtils.copyFile(scrFile, new File("C:\\Users\\Roma&Nastya\\Desktop\\Upwork\\Screenshots\\Selenium\\screenshot" +" - Rec.Room"+ System.currentTimeMillis() +".png"));
        } catch (IOException x) {
            x.printStackTrace();
        }
// Closing rec.room
        driver.findElement(By.xpath("//div[@class='modal-footer']/button[@class='btn btn-default']")).click();
    }
}