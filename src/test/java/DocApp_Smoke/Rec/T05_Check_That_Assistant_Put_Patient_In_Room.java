package DocApp_Smoke.Rec;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class T05_Check_That_Assistant_Put_Patient_In_Room extends TestBase {
    @Test
    public void Patient_In_Room_Check() throws IOException {
        Assistant_Login();
// Select Doctor
//        driver.findElement(By.cssSelector("div md-input-container md-select[ng-model=doc_title]")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(
//        By.cssSelector("md-content md-option[value='Dr. Glenn Nathan']")));
//        driver.findElement(By.cssSelector("md-content md-option[value='Dr. Glenn Nathan']")).click();
//
//// Select empty room
//        driver.findElement(By.xpath("//md-content/div/div/a[not(contains(@class,'ng-'))]")).click();
//        List<WebElement> bef = driver.findElements(By.cssSelector("a[md-colors*=room_occupied]"));
//
////Put Patient in room
//        driver.findElement(By.cssSelector("div > table > tbody > tr[ng-repeat] > td > button.btn.ng-scope:not([class*=ng-hide])")).click();
//        driver.findElement(By.cssSelector("div.modal-footer > button[ng-click*=confirm_patient]")).click();
//        Sign_Popup();
//        if(isElementPresent(By.cssSelector("div.modal-dialog"))){
//            driver.findElement(By.cssSelector("div.modal-body div:nth-child(2) > button")).click();
//            driver.findElement(By.cssSelector("td > a[callback*=set_parent]")).click();
//            driver.findElement(By.cssSelector("button[ng-click*=apply]")).click();
////            driver.findElement(By.cssSelector("div.modal-footer > button:nth-child(1)")).click();
//        }

//        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div[1]/div[1]/button")));
//        if(webElement!=null){
//            driver.findElement(By.xpath("//div[2]/div[1]/div[1]/button")).click();
//            driver.findElement(By.cssSelector("div.modal-footer > button[ng-click*=\"apply_procedure\"]")).click();
//        }

//Taking Screenshot
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("div.margin-top-15.ng-scope.md-whiteframe-3dp > md-content")));
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(scrFile, new File(Screen_Path +" - Put_Patient_In_Room"+ System.currentTimeMillis() +".png"));
//        } catch (IOException x) {
//            x.printStackTrace();
//        }

//Set patient status and closing room
//        driver.findElement(By.xpath("//md-content/div/div/a[contains(@class,'ng-scope')]")).click();
//        if (isElementPresent(By.cssSelector("md-dialog-actions.layout-row"))) {
//            driver.findElement(By.cssSelector("md-dialog-actions.layout-row > div.text-center > button[ng-click*='submit']")).click();
//        }
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3 > span[ng-click*='show_room_status']")));
//        driver.findElement(By.cssSelector("h3 > span[ng-click*='show_room_status']")).click();
//        driver.findElement(By.cssSelector("div > md-toolbar > div > i")).click();
//        String room_stat = "Referral attached";
//        List<WebElement> status_options = driver.findElements(By.cssSelector("div.modal-body div > button.ng-binding.ng-scope"));
//        for (WebElement i : status_options){
//            if(i.getText().equals(room_stat)){
//                i.click();
//            }
//        }
//        WebElement selected_option = driver.findElement(By.cssSelector("div.modal-body div > button.ng-binding.ng-scope.btn-primary"));
//        String selected_shortcut = selected_option.getText();
//        driver.findElement(By.cssSelector("div.modal-dialog div.modal-footer > button[ng-click*='update_room']")).click();
//        System.out.println(selected_shortcut);

        String url = ("http://docdev.dentalelink.com/api/v3/screens/assistant/ping_room_info?office_id=1&room_code=1");
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpGet request = new HttpGet("http://docdev.dentalelink.com/api/v3/screens/assistant/ping_room_info?office_id=1&room_code=1");
//        System.setProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");

        URLConnection openConnection = new URL(url).openConnection();
        System.setProperty("http.agent", "Chrome");
        openConnection.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        openConnection.connect();
        BufferedReader r  = new BufferedReader(new InputStreamReader(openConnection.getInputStream(), Charset.forName("UTF-8")));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            sb.append(line);
        }
        System.out.println(sb.toString());

//        Locator.rooms();

//Comparing quantity of occupied rooms before and after test execution
//        List<WebElement> aft = driver.findElements(By.cssSelector("a[md-colors*=room_occupied]"));
//        int b = bef.size();
//        int a = aft.size();
//        if (a == b + 1) {
//            System.out.println("Occupied rooms before test run: " + bef.size());
//            System.out.println("Occupied rooms after test run: " + aft.size());
//        }
//        else {
//            throw new java.lang.Error("Something went wrong");
//        }

//Check that room status is displayed
//        driver.findElement(By.cssSelector(""));
    }
}