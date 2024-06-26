import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class AndLockAndUnlockDevice {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By views= AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();
        WebElement element= driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)element).getId(),
                "direction","up",
                "percent","0.75"
        ));
        By textFields= AppiumBy.accessibilityId("TextFields");
        driver.findElement(textFields).click();
        By editText= AppiumBy.id("io.appium.android.apis:id/edit");
        driver.findElement(editText).click();
        Thread.sleep(3000);
        System.out.println(((AndroidDriver)driver).isKeyboardShown());
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.C));
       // ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));
        //((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.CALENDAR));

        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.A));
        ((AndroidDriver)driver).pressKey(new KeyEvent().withKey(AndroidKey.B));
        Thread.sleep(3000);
        ((AndroidDriver)driver).hideKeyboard();

       // ((AndroidDriver)driver).lockDevice(Duration.ofSeconds(5));
        /*((AndroidDriver)driver).lockDevice();
        Thread.sleep(1000);
        System.out.println(((AndroidDriver) driver).isDeviceLocked());
        Thread.sleep(1000);
        ((AndroidDriver)driver).unlockDevice();
        Thread.sleep(1000);*/
            }
}
