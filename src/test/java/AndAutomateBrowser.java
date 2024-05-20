

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class AndAutomateBrowser {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.tesla.com/");
        driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
        driver.findElement(By.id("com.android.chrome:id/positive_button")).click();
        Thread.sleep(1000);


    }

    }
