import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits
{
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      //  By views1= (By) driver.findElement(By.xpath("//*[@text=\"Views\"]"));
        By views2= AppiumBy.xpath("/*[@text=\\\"Views\\\"]");
       // views1.click();
        WebElement textFields=driver.findElement(AppiumBy.xpath("//*[@text=\"TextFields\"]"));

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(views2)).click();
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(textFields)).click();
    }
}
