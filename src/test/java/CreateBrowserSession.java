import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
public class CreateBrowserSession {
    public static AppiumDriver initializeDriver(String platformName) throws Exception {
    DesiredCapabilities caps=new DesiredCapabilities();
    caps.setCapability("platformName",platformName);
    caps.setCapability("newCommandTimeout",300);
    URL url=new URL("http://127.0.0.1:4723");
    switch(platformName){
        case "Android":
            caps.setCapability("automationName","uiautomator2");
            caps.setCapability("deviceName","pixel_5");
            caps.setCapability("platformVersion","11.0");
            caps.setCapability("udid","emulator-5554");
           caps.setCapability("BROWSER_NAME","Chrome");
//           caps.setCapability("chromedriverExecutable","C:\\Users\\pkatta\\Downloads\\chromedriver_win32\\chromedriver.exe");
            caps.setCapability("appPackage","com.android.chrome");
            caps.setCapability("appActivity","com.google.android.apps.chrome.Main");
            return new AndroidDriver(url,caps);

        case "iOS":
        caps.setCapability("automationName","XCUITest");
        caps.setCapability("deviceName","iphone 11");
       caps.setCapability("udid","89895554");
        String iOSAppUrl=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+
                "resources"+File.separator+"UIKitCatalog-iphonesimulator.app";
        caps.setCapability("simulatorStartupTimeout","180000");
        caps.setCapability("bundleId","com.example.apple-samplecode.UICatalog");
        // caps.setCapability("app","andAppUrl");
        return new IOSDriver(url,caps);
        default:
            throw new Exception("invalid platform");

    }
    }
}
