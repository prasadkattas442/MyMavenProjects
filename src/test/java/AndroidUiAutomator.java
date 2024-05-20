import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class AndroidUiAutomator
{
    public static void main(String[] args) throws Exception {
        AppiumDriver driver=CreateDriverSession.initializeDriver("Android");
        WebElement myElement=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println(myElement.getText());
        myElement=driver.findElement((AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")));
        System.out.println(myElement.getText());

    }
}
