import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class WebViewInspectUsingAI {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();
        WebElement element= driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction","up","percent",0.75
        ));
        driver.findElement(AppiumBy.accessibilityId("WebView2")).click();
        Thread.sleep(2000);
       // driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"This page is a Second Selenium sandbox\"]")).getText();
        System.out.println( driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"This page is a Second Selenium sandbox\"]")).getText());

    }
}
