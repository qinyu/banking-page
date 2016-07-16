import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Created by yqin on 7/16/16.
 */
public class LocalAndroidDriverProvider implements WebDriverProvider {

    private String getAppPath(){
        return Paths.get(System.getProperty("user.dir"), "..", "platforms", "android", "build", "outputs", "apk", "android-debug.apk").toAbsolutePath().toString();
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "5.1.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.58.101:5555");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, getAppPath());
        try {
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
            driver.context("WEBVIEW");
            return driver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
