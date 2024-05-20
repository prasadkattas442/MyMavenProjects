import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

public class AndroidGestures {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        scrollGesture(driver);
}
    public static void longClickGesture(AppiumDriver driver) throws InterruptedException {
       driver.findElement(AppiumBy.xpath("//*[@text=\"Views\"]")).click();
        Thread.sleep(1000);
        driver.findElements(AppiumBy.id("android:id/text1")).get(7).click();
        Thread.sleep(1000);

      //  driver.findElement(AppiumBy.accessibilityId("io.appium.android.apis:id/drag_dot_1")).click();
       WebElement element= driver.findElements(AppiumBy.className("android.view.View")).get(1);
       // element.isEnabled();

       // WebElement element=driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]"));
        Thread.sleep(1000);
        driver.executeScript("mobile:longClickGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "endX",650,
                "endY",600,
                "duration",1000
        ));
    }
    public static void pinchOpenGesture(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
        Thread.sleep(5000);
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left",200,
                "top",470,
                "width",600,
                "height",600,
                "percent",0.75
        ));
    }
    public static void swipeGesture(AppiumDriver driver) throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//*[@text=\"Views\"]")).click();
        Thread.sleep(1000);
       // WebElement element= driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture",ImmutableMap.of(
                "left", 100, "top", 100, "width", 600, "height", 1700,
              //  "elementId",((RemoteWebElement)element).getId(),
                "duration", 1000,
                "direction","up","percent",0.75
        ));
        Thread.sleep(1000);
        driver.executeScript("mobile: swipeGesture",ImmutableMap.of(
                "left", 100, "top", 1700, "width", 600, "height", 100,
                //  "elementId",((RemoteWebElement)element).getId(),
                "duration", 1000,
                "direction","down","percent",0.75
        ));

}
    public static void swipeleftGesture(AppiumDriver driver) throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//*[@text=\"Views\"]")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        //*[@resource-id="io.appium.android.apis:id/gallery"]/android.widget.ImageView[1]
        WebElement element= driver.findElement(AppiumBy.xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));
        driver.executeScript("mobile: swipeGesture",ImmutableMap.of(
                "left", 100, "top", 100, "width", 600, "height", 1700,
                  "elementId",((RemoteWebElement)element).getId(),
                "duration", 1000,
                "direction","left","percent",0.75
        ));

    }
    public static void scrollGesture(AppiumDriver driver) throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//*[@text=\"Views\"]")).click();
        Thread.sleep(1000);
      //  WebElement element= driver.findElement(AppiumBy.accessibilityId("Animation"));
        boolean canScrollMore=true;
        while(canScrollMore){
            canScrollMore= (boolean) driver.executeScript("mobile: scrollGesture",ImmutableMap.of(
                    "left", 100, "top", 100, "width", 600, "height", 600,
                    //  "elementId",((RemoteWebElement)element).getId(),
                    "direction","down","percent",1.0
            ));
        }

    }
}
