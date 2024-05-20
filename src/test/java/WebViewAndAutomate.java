import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.Set;

public class WebViewAndAutomate {
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
        //  System.out.println( driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"This page is a Second Selenium sandbox\"]")).getText());
      Set<String> contextHandles=((AndroidDriver)driver).getContextHandles();
      for(String contextHandle:contextHandles)
      {
          System.out.println(contextHandle);
      }
      ((AndroidDriver) driver).context("WEBVIEW");
      ((AndroidDriver) driver).context(contextHandles.toArray()[1].toString());
        System.out.println(driver.findElement(By.cssSelector("body > h1")).getText());
        ((AndroidDriver) driver).context("NATIVE_APP");
    }
}
