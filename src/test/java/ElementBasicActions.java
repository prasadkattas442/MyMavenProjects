import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class ElementBasicActions {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver=CreateDriverSession.initializeDriver("Android");
        //click,sendkeys.clear

         WebElement views1=driver.findElement(By.xpath("//*[@text=\"Views\"]"));
        views1.click();
        WebElement textFields=driver.findElement(By.xpath("//*[@text=\"TextFields\"]"));
        WebElement editText=driver.findElement(By.id("io.appium.android.apis:id/edit"));



        WebElement element= driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).
        getId(),"direction","up","percent", 0.75));
        textFields.click();
        editText.sendKeys("my text prasad");
        Thread.sleep(3000);

    }
}
