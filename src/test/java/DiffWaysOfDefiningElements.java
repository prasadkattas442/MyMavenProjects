import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiffWaysOfDefiningElements {
    @FindBy(xpath="//*[@text=\"Accessibility\"]")
    private  static WebElement element1;
    @AndroidFindBy(xpath="//*[@text=\"Accessibility\"]")
   // @iOSXCUITFindBy("accessibility"="Accessibility")
    private  static WebElement element12;


    public DiffWaysOfDefiningElements(AppiumDriver driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public static void main(String[] args) throws Exception {
        AppiumDriver driver= CreateDriverSession.initializeDriver("Android");
        DiffWaysOfDefiningElements diffWaysOfDefiningElements=new DiffWaysOfDefiningElements(driver);
        System.out.println(element1.getText());

        By element= AppiumBy.accessibilityId("accessibility");
        System.out.println(driver.findElement(element).getText());

    }
}
